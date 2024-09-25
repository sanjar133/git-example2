package forUser;

import enums.Role;

public class User {
    public  String name ;
    public  String surname ;
    public  Integer id ;
    public  String phoneNumber ;
    public Role role ;

    public User(String name, String surname, String phone, String id) {
    }

    public User(String name, String surname, Integer id, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.phoneNumber = phoneNumber;
        role=Role.User ;
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", id='" + id + '\'' +
                ", role=" + role +
                '}';
    }
}
