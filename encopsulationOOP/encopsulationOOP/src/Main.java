import model.Card;
import model.User;
import service.CardService;
import service.UserService;

import java.util.Scanner;

public class Main {
    static Scanner scannerInt = new Scanner(System.in);
    static Scanner scannerStr = new Scanner(System.in);

    public static void main(String[] args) {
        UserService userService = new UserService();
        CardService cardService = new CardService();

        int stepCode = 10;

        while (stepCode != 0) {
            System.out.println("1. Register user 2. Login ");
            stepCode = scannerInt.nextInt();
            if (stepCode == 1) {
                User user = getRegisterMenu();
                User user1 = userService.addUser(user);
                if (user1 == null) {
                    System.out.println("Already registered user");
                } else {
                    System.out.println("Successfully");
                }

            } else if (stepCode == 2) {

                System.out.println("Enter phone number:");
                String phoneNumber = scannerStr.nextLine();

                System.out.println("Enter password:");
                String password = scannerStr.nextLine();

                User currentUser = userService.loginUser(phoneNumber, password);
                if (currentUser == null) {
                    System.out.println("Invalid user!!!");
                } else {
                    int stepCode2 = 10;
                    while (stepCode2 != 0) {
                        System.out.println("1. Add card");
                        System.out.println("2. Delete card");
                        System.out.println("3. P2P");
                        System.out.println("4. Get balance");
                        System.out.println("5. Change user password");
                        System.out.println("6. Get cards");
                        System.out.println("0. Exit");
                        stepCode2 = scannerInt.nextInt();
                        switch (stepCode2) {
                            case 1 -> {

                                Card card = getAddCardMenu(currentUser);
                                boolean isTrue = cardService.addCard(card, currentUser);
                                if (isTrue) {
                                    System.out.println("Successfully add card");
                                } else System.out.println("Already exist card");

                            }

                            case 2 -> {
                                getMyCards(cardService, currentUser);

                                System.out.println();
                                System.out.println("Which card you choose and enter card number:");
                                String cardNumber = scannerStr.nextLine();

                                cardService.deleteCard(cardNumber, currentUser);
                            }

                            case 3 -> {
                                getMyCards(cardService, currentUser);

                                System.out.println();
                                System.out.println("Which card you choose and enter card number:");
                                String cardNumber = scannerStr.nextLine();

                                System.out.println("Enter recipient card number:");
                                String recipientCardNumber = scannerStr.nextLine();

                                System.out.println("Enter amount:");
                                double amount = scannerInt.nextDouble();

                                String result = cardService.p2p(cardNumber, recipientCardNumber, amount, currentUser);
                                System.out.println(result);
                            }
                            case 4 -> {
                                System.out.println("Enter card number:");
                                String cardNumber = scannerStr.nextLine();

                                double balance = cardService.getBalance(cardNumber);
                                if (balance == 0) {
                                    System.out.println("Not founded card number");
                                } else {
                                    System.out.println(balance);
                                }
                            }
                            case 6 -> getMyCards(cardService, currentUser);
                        }
                    }
                }
            }
        }
    }

    private static void getMyCards(CardService cardService, User currentUser) {
        Card[] myCards = cardService.getMyCards(currentUser);

        for (Card myCard : myCards) {
            System.out.println(myCard);
        }
    }

    private static Card getAddCardMenu(User currentUser) {
        Card card = new Card();

        System.out.println("Enter card number:(XXXX XXXX XXXX XXXX)");
        card.setCardNumber(scannerStr.nextLine());

        System.out.println("Enter card expiration date (XX/XX)");
        card.setExpirationDate(scannerStr.nextLine());

        System.out.println("Enter card name:");
        card.setName(scannerStr.nextLine());

        System.out.println("Enter balance");
        card.setBalance(scannerInt.nextDouble());

        card.setOwnerName(currentUser.getName());
        return card;
    }

    private static User getRegisterMenu() {
        User user = new User();
        System.out.println("Enter name:");
        String name = scannerStr.nextLine();

        System.out.println("Enter phone: (+998 XX XXX XX XX)");
        String phoneNumber = scannerStr.nextLine();

        System.out.println("Enter password");
        String password = scannerStr.nextLine();

        user.setName(name);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);

        return user;

    }

}

