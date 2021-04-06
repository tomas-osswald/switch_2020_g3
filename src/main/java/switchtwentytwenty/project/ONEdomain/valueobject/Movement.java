package switchtwentytwenty.project.ONEdomain.valueobject;

public class Movement implements ValueObject {

    private AccountID account;

    public Movement(AccountID accountID) {
        this.account = accountID;
    }
}
