package switch2020.project.domain.model;

public class AccountData {

    private double balance = 0;
    private String description;
    private int accountID;


    public AccountData(double balance, String description, int accountID) {
        this.balance = balance;
        this.description = description;
        this.accountID = accountID;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }



}
