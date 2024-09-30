package model;

import java.time.LocalDateTime;

public class Notification extends Base {
    private User user;
    private String message;
    private LocalDateTime date;

    // Constructor
    public Notification(User user, String message) {
        this.user = user;
        this.message = message;
        this.date = date;
    }

    // Getters and setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
