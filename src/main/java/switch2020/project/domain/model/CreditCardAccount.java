package switch2020.project.domain.model;

public class CreditCardAccount implements Account {


    // Attributes
    private int accountID;
    private double balance;
    private double withrawalLimit;
    private FamilyMember familyMember;
    private Family family;
    private String accountName;

    public CreditCardAccount(int accountID, double withrawalLimit) {
        this.accountID = accountID;
        this.balance = 0;
        this.withrawalLimit = withrawalLimit;
    }

    //constructors

    public CreditCardAccount(FamilyMember familyMember, Family familyID, int accountID, String accountName, double withrawalLimit){
        this.familyMember = familyMember;
        this.family = family;

    }

    @Override
    public Account createAccount() {
        return null;
    }

    public int getAccountID() {
        return this.accountID;
    }

    public double getBalance() {
        return this.balance;
    }

    public void changeBalance(double value) {
        if ((this.balance + value) < (withrawalLimit * -1)) throw new IllegalArgumentException("ultrapassa credito");
        this.balance = this.balance + value;
    }
}
