import model.Debtor;
import model.History;
import model.Market;
import model.Notification;
import service.DebtorsService;
import service.HistoryService;
import service.MarketService;
import service.NotificationService;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    static Scanner scannerInt = new Scanner(System.in);
    static Scanner scannerStr = new Scanner(System.in);

    public static void main(String[] args) {
        int stepCode = 10;
        MarketService marketService = new MarketService(100);
        DebtorsService debtorsService = new DebtorsService();
        NotificationService notificationService = new NotificationService();
        HistoryService historyService = new HistoryService();

        while (stepCode != 0) {
            System.out.println("1. Add Market 2. Login 3. Exit");
            stepCode = scannerInt.nextInt();
            if (stepCode == 1) {
                Market market = getMarketFromConsole();
                if (marketService.addMarket(market)) {
                    System.out.println("Market added successfully");
                } else {
                    System.out.println("Market already exists");
                }
            } else if (stepCode == 2) {
                System.out.println("Enter username: ");
                String username = scannerStr.nextLine();
                System.out.println("Enter password: ");
                String password = scannerStr.nextLine();
                Market currentMarket = marketService.login(username, password);

                if (currentMarket != null) {
                    int stepCode2 = 10;
                    while (stepCode2 != 0) {
                        System.out.println("1. Add Or Update Debtors. 2. Get Debtors. 3. Minus Debt 4.Notification 5.Transfer debt to friend 6.History 0.Exit");
                        stepCode2 = scannerInt.nextInt();
                        switch (stepCode2) {
                            case 1 -> {
                                Debtor debtor = getDebtorFromConsole();
                                debtorsService.addOrUpdateDebt(currentMarket, debtor);
                            }
                            case 2 -> {
                                Debtor[] debtors = debtorsService.getDebtors();
                                printDebtors(currentMarket, debtors);
                            }
                            case 3 -> {
                                Debtor debtor = getDebtorFromConsole();
                                Debtor minusDebt = debtorsService.minusDebt(currentMarket, debtor);
                                if (minusDebt != null) {
                                    System.out.println(minusDebt.name + " li userda " + minusDebt.debtAmount + "qarzing qoldi");
                                } else {
                                    System.out.println("Bunday user topilmadi");
                                }
                            }
                            case 4 -> {
                                System.out.println("please enter your name");
                                String name = scannerStr.nextLine();
                                Debtor debtor = debtorsService.getDebtorsByName(currentMarket.id, name);
                                if (debtor != null) {
                                    Notification[] notifications = notificationService.getNotifications(debtor.id);
                                    printNotifications(notifications, debtorsService);
                                }
                                System.out.println("1.Agree 2.Disagree");
                                int command = scannerInt.nextInt();
                                switch (command) {
                                    case 1 -> {
                                        System.out.println("Notification id: ");

                                        String notificationId = scannerStr.nextLine();
                                        notificationService.transferMoney(UUID.fromString(notificationId), debtorsService);
                                    }
                                }
                            }
                            case 5 -> {
                                System.out.println("please enter your name");
                                String name = scannerStr.nextLine();

                                System.out.println("please enter your friend name");
                                String friendName = scannerStr.nextLine();

                                System.out.println("please enter amount");
                                double amount = scannerInt.nextDouble();

                                notificationService.createNotification(debtorsService.getDebtorsByName(currentMarket.id, name).id, debtorsService.getDebtorsByName(currentMarket.id, friendName).id, amount);
                            }
                            case 6 -> {
                                System.out.println("History: ");
                                System.out.println("Enter username: ");
                                String userHistory = scannerStr.nextLine();
                                List histories = historyService.getHistories(userHistory);
                                if (histories==null) {
                                    System.out.println("no history");
                                    break;
                                }
                                for (Object history : histories) {
                                    System.out.println(history);
                                }

                            }
                        }
                    }
                }
            }
        }
    }


    public static Market getMarketFromConsole() {
        Market market = new Market();
        System.out.println("Enter Market Name: ");
        market.name = scannerStr.nextLine();
        System.out.println("Enter Market Username: ");
        market.username = scannerStr.nextLine();
        System.out.println("Enter Market Password: ");
        market.password = scannerStr.nextLine();
        System.out.println("Enter Market Location: ");
        market.location = scannerStr.nextLine();
        return market;
    }

    public static Debtor getDebtorFromConsole() {
        Debtor debtor = new Debtor();
        System.out.println("Enter Debtor Name: ");
        debtor.name = scannerStr.nextLine();
        System.out.println("Enter Debt Amount: ");
        debtor.debtAmount = scannerInt.nextDouble();
        return debtor;
    }

    public static void printDebtors(Market currentMarket, Debtor[] debtors) {
        for (Debtor debtor : debtors) {
            if (debtor != null && debtor.marketId.equals(currentMarket.id)) {
                System.out.println("Name: " + debtor.name + " Debt: " + debtor.debtAmount);
            }
        }
    }

    public static void printNotifications(Notification[] notifications, DebtorsService debtorsService) {
        for (Notification notification : notifications) {
            if (notification != null) {
                Debtor debtor = debtorsService.getDebtorById(notification.fromId);
                System.out.println("Id: " + notification.id + " Name: " + debtor.name + " Debt: " + notification.amount);
            }
        }
    }

}
