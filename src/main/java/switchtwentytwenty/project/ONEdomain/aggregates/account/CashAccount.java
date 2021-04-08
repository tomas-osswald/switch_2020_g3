package switchtwentytwenty.project.ONEdomain.aggregates.account;

import switchtwentytwenty.project.ONEdomain.valueobject.AccountID;
import switchtwentytwenty.project.ONEdomain.valueobject.ID;

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