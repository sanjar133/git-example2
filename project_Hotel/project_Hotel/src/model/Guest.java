package model;

public class Guest {
    private String name;
    private String contactNumber;
    private String email;

    public Guest(String name, String contactNumber, String email) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Guest{name='" + name + "', contactNumber='" + contactNumber + "', email='" + email + "'}";
    }
}
