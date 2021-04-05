package switchtwentytwenty.project.domain.account;

import switchtwentytwenty.project.util.ID;

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
