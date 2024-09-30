package model;

import java.util.UUID;

public class History {
    public UUID id;

    public String from;
    public String to;
    public double amount;

    public History() {
        this.id = UUID.randomUUID();
    }

    public History(String from, String to, double amount) {
        this();
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

//    public History(String from, String to, double amount) {
//        this.from = from;
//        this.to = to;
//        this.amount = amount;
//    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", amount=" + amount +
                '}';
    }
}
