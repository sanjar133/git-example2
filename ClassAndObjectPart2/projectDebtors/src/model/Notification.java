package model;

import java.util.UUID;

public class Notification {
    public UUID id;
    public UUID fromId;
    public UUID toId;
    public double amount;
    public boolean isActive = true;

    public Notification() {
        this.id = UUID.randomUUID();
    }

    public Notification(UUID fromId, UUID toId, double amount) {
        this();
        this.fromId = fromId;
        this.toId = toId;
        this.amount = amount;
    }
}
