package switchtwentytwenty.project.domain.account;

import switchtwentytwenty.project.shared.ID;

import java.util.UUID;

public class DebitCardAccount extends NonCashAccount {

    public DebitCardAccount(UUID id) {
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
