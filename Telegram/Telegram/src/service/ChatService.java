package service;

import model.Chat;
import model.Group;
import model.Notification;
import model.User;

import java.util.Arrays;
import java.util.Objects;

public class ChatService {

    private Chat[] chats = new Chat[100];
    private Notification[] notifications = new Notification[1000]; // Array to store notifications
    private int countChat = 0;
    private int notificationCount = 0;

    public void sendMessage(User fromUser, User toUser, String message) {
        // Send the message
        chats[countChat++] = new Chat(fromUser, toUser, message);

        // Save notification for the recipient
        notifications[notificationCount++] = new Notification(fromUser, message);
    }

    public void sendMessage(User fromUser, Group group, String message) {
        chats[countChat++] = new Chat(fromUser, group.getOwner(), message);
    }

    public Notification[] getNotifications(User user) {
        // Retrieve all notifications for the user
        Notification[] userNotifications = new Notification[1000];
        int count = 0;
        for (Notification notification : notifications) {
            if (notification != null && notification.getUser().equals(user)) {
                userNotifications[count++] = notification;
            }
        }
        return Arrays.copyOf(userNotifications, count);
    }




    public Notification[] getMessages(Group group) {
        Notification[] resultNotification = new Notification[countChat];
        int countNotification = 0;
        for (int i = 0; i < countChat; i++) {
            if (Objects.equals(chats[i].getChatGroup(), group)) {
                Notification notification = new Notification(chats[i].getFromUser(), chats[i].getMessage());
                resultNotification[countNotification] = notification;
            }
        }

        return resultNotification;
    }




}
