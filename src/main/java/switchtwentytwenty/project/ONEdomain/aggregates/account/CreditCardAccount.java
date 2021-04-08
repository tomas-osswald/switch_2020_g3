package switchtwentytwenty.project.ONEdomain.aggregates.account;

import switchtwentytwenty.project.ONEdomain.valueobject.ID;

import java.util.UUID;

public class CreditCardAccount extends NonCashAccount {

    public CreditCardAccount(UUID id) {
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
