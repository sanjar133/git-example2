package model;

public class User {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private User[] contacts = new User[1000]; // Array to store contacts

    // Constructor
    public User(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User[] getContacts() {
        return contacts;
    }

    public void setContacts(User[] contacts) {
        this.contacts = contacts;
    }
}

