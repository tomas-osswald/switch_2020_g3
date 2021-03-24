package switchtwentytwenty.project.domain.account;

import switchtwentytwenty.project.shared.AccountID;

import java.util.UUID;

public abstract class NonCashAccount implements Account {

    private AccountID id;

    public NonCashAccount(UUID id) {
        this.id = new AccountID(id);
    }
}
