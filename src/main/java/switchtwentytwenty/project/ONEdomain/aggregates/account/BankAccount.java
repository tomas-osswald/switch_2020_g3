package switchtwentytwenty.project.ONEdomain.aggregates.account;

import switchtwentytwenty.project.ONEdomain.valueobject.ID;

import java.util.UUID;

public class BankAccount extends NonCashAccount {
    public BankAccount(UUID id) {
        super(id);
    }

    @Override
    public ID id() {
        return null;
    }

    @Override
    public boolean hasID(ID id) {
        return false;
    }
}
