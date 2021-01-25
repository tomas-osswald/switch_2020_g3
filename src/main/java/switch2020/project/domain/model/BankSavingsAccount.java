package switch2020.project.domain.model;

public class BankSavingsAccount implements Account {


    // Attributes
    private AccountData accountData;
    private double interestRate;


    // Constructors
    public BankSavingsAccount(String name, double balance, Double interestRate) {

    }


    // Business Methods

    public double getInterestRate() {
        return 0;
    }

    private boolean validateBalance() {
        return false;
    }

    private boolean validateInterestRate() {
        return false;
    }


    @Override
    public int getAccountID() {
        return 0;
    }

    @Override
    public double getBalance() {
        return 0;
    }

    @Override
    public void changeBalance(double value) {

    }
}
