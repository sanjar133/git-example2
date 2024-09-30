package model;

import java.time.LocalDateTime;

public class Chat extends Base {
    private User fromUser;
    private User toUser;
    private User chatGroup;
    private String message;
    private LocalDateTime date;

    // Constructor
    public Chat(User fromUser, User chatGroup, String message) {
        this.fromUser = fromUser;
        this.message=message;
        this.chatGroup = chatGroup;
        this.date = date.now();
    }

    // Getters and setters
    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public User getChatGroup() {
        return chatGroup;
    }

    public void setChatGroup(Group chatGroup) {
        this.chatGroup = chatGroup.getOwner();
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
