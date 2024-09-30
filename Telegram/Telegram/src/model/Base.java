package model;

import java.util.UUID;

public class Base {
    protected UUID id;

    public Base() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }
}
