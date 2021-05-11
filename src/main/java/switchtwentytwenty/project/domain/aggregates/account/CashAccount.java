package switchtwentytwenty.project.domain.aggregates.account;

import switchtwentytwenty.project.domain.valueobject.*;

import java.util.List;

public class CashAccount extends AbCashAccount{

    /*private Monetary calculateBalance(List<Movement> movements) {
        Monetary balance = new Monetary()
        // for every movement in movements, balance.sum(movement)
        return balance
    }*/


    public CashAccount(OwnerID ownerID, Designation designation, AccountID accountID, List<Movement> movements) {
    }

    @Override
    public AccountID getId() {
        return null;
    }

    @Override
    public AccountType getAccountType() {
        return null;
    }
}