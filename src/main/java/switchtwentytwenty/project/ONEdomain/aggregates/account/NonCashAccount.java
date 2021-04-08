package switchtwentytwenty.project.ONEdomain.aggregates.account;

import switchtwentytwenty.project.ONEdomain.valueobject.AccountID;

import java.util.UUID;

public abstract class NonCashAccount implements Account {

    /**
     *
     */
    private AccountID id;

    public NonCashAccount(UUID id) {
        this.id = new AccountID(id);
    }
}