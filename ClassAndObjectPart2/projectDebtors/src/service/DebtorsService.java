package service;


import model.Debtor;
import model.Market;

import java.util.UUID;

public class DebtorsService {
    private Debtor[] debtors = new Debtor[1000];
    public int indexDebtors = 0;

    public Debtor addOrUpdateDebt(Market market, Debtor debtor) {
        Debtor existingDebtor = getDebtorsByName(market.id, debtor.name);
        if (existingDebtor == null) {
            debtor.marketId = market.id;
            debtors[indexDebtors++] = debtor;
            return debtor;
        }
        existingDebtor.debtAmount += debtor.debtAmount;
        return existingDebtor;
    }

    public Debtor minusDebt(Market market, Debtor debtor) {
        Debtor existingDebtor = getDebtorsByName(market.id, debtor.name);
        if (existingDebtor != null) {
            if (existingDebtor.debtAmount >= debtor.debtAmount) {
                existingDebtor.debtAmount -= debtor.debtAmount;
                return existingDebtor;
            }
            return debtor;
        }
        return null;
    }

    public Debtor getDebtorsByName(UUID marketId, String name) {
        for (Debtor debtor : debtors) {
            if (debtor != null &&
                    debtor.name.equals(name) && debtor.marketId.equals(marketId)) {
                return debtor;
            }
        }
        return null;
    }

    public Debtor[] getDebtors() {
        return debtors;
    }

    public Debtor getDebtorById(UUID id) {
        for (Debtor debtor : debtors) {
            if (debtor != null && debtor.id.equals(id)) {
                return debtor;
            }
        }
        return null;
    }
}
