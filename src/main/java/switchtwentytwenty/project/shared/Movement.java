package switchtwentytwenty.project.shared;

import switchtwentytwenty.project.ValueObject;

public class Movement implements ValueObject {

    private AccountID account;

    public Movement(AccountID accountID) {
        this.account = accountID;
    }
}
