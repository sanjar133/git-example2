package model;

import java.util.UUID;

public class Debtor {
    public UUID id;
    public String name;
    public double debtAmount;
    public UUID marketId;

    public Debtor() {
        this.id = UUID.randomUUID();
    }

    public Debtor(String name, double debtAmount) {
        this();
        this.name = name;
        this.debtAmount = debtAmount;
    }
}
