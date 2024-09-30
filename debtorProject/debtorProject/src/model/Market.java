package model;

import java.util.UUID;

public class Market {
    public UUID id;
    public String name;
    public String username;
    public String password;
    public String location;
    public Market() {
        this.id = UUID.randomUUID();
    }
    public Market(String name, String location) {
        this();
        this.name = name;
        this.location = location;
    }
    public Market(String name, String username, )

}
