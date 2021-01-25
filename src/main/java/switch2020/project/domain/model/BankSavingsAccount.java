package switch2020.project.domain.model;

import java.util.Objects;

public class BankSavingsAccount implements Account {


    // Attributes
    private AccountData accountData;
    private double interestRate;


    // Constructors
    public BankSavingsAccount(String name, Double balance, Double interestRate) {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankSavingsAccount that = (BankSavingsAccount) o;
        return Double.compare(that.interestRate, interestRate) == 0 && accountData.equals(that.accountData);
    }
}
