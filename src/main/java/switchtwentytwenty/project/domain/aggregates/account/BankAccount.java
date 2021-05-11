package switchtwentytwenty.project.domain.aggregates.account;

import switchtwentytwenty.project.domain.valueobject.*;

public class BankAccount extends NonCashAccount {

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
    public AccountID getId() {
        return null;
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