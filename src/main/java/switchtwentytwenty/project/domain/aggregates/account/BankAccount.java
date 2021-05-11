package switchtwentytwenty.project.domain.aggregates.account;

import switchtwentytwenty.project.domain.valueobject.*;

import java.util.List;

public class BankAccount extends AbNonCashAccount {

    private AccountID accountID;

    private OwnerID ownerID;

    private Designation designation;

    private Balance balance;

    private List<Movement> movements;


    public BankAccount() {
    }

    @Override
    public AccountID id() {
        return null;
    }

    @Override
    public boolean hasID(AccountID id) {
        return false;
    }

    @Override
    public OwnerID getOwnerId() {
        return null;
    }

    @Override
    public Designation getDesignation() {
        return null;
    }

    @Override
    public Balance getBalance() {
        return null;
    }

    @Override
    public AccountType getAccountType() {
        return null;
    }
}