package switchtwentytwenty.project.domain.account;

import switchtwentytwenty.project.shared.AccountID;
import switchtwentytwenty.project.shared.ID;

public class CashAccount implements Account {


    private AccountID id;

    @Override
    public ID id() {
        return null;
    }

    @Override
    public boolean hasID(ID id) {
        return false;
    }
}