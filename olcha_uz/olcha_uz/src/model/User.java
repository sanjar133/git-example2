package model;

import java.util.UUID;

public class User {
    private UUID id;
    private String username;
    private String password;
    public User() {
        this.id = UUID.randomUUID();
    }

    public User(String username, String password) {
        this();
        this.username = username;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
