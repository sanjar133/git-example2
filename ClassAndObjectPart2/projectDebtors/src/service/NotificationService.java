package service;

import model.Debtor;
import model.Notification;

import javax.lang.model.type.DeclaredType;
import java.util.UUID;

public class NotificationService {

    public Notification[] notifications = new Notification[100];
    public int notificationCount = 0;

    public void createNotification(UUID fromId, UUID toId, double amount) {
        Notification notification = new Notification(fromId, toId, amount);
        notifications[notificationCount ++] = notification;
    }

    public Notification[] getNotifications(UUID toId){
        Notification[] not = new Notification[100];
        int indexNot = 0;
        for (int i = 0; i < notificationCount; i++) {
            if (notifications[i].toId.equals(toId) && notifications[i].isActive) {
                not[indexNot++] = notifications[i];
            }
        }
        return not;
    }

    public Notification getById(UUID notificationId) {
        for (Notification notification : notifications) {
            if (notification != null && notification.isActive && notification.id.equals(notificationId)) {
                return notification;
            }
        }
        return null;
    }

    public void transferMoney(UUID notificationId, DebtorsService debtorsService) {
        Notification notification = getById(notificationId);
        Debtor from = debtorsService.getDebtorById(notification.fromId);
        Debtor to = debtorsService.getDebtorById(notification.toId);
        from.debtAmount -= notification.amount;
        to.debtAmount += notification.amount;
        notification.isActive = false;
        HistoryService historyService = new HistoryService();
        historyService.printHistory(from.name, to.name, notification.amount);
    }
}
