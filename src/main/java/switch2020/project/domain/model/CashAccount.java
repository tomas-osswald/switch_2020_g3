package switch2020.project.domain.model;

import switch2020.project.domain.utils.exceptions.InvalidAccountDesignationException;

public class CashAccount implements Account {


    // Attributes
    private AccountData accountData;


    // Constructors
    public CashAccount(double balance) {
        if (!validateBalance(balance)) {
            throw new IllegalArgumentException("Balance can't be less than 0");
        }
        this.accountData = new AccountData(balance, "Cash Account", 0);
    }

    public CashAccount(String designation, double balance, int cashAccountID) {

        if (!validateBalance(balance)) {
            throw new IllegalArgumentException("Balance can't be less than 0");
        }
        try {
            this.accountData = new AccountData(balance, designation.toUpperCase(), cashAccountID);
        } catch (InvalidAccountDesignationException exception) {
            String defaultDesignation = "Cash Account nº" + " " + cashAccountID;
            this.accountData = new AccountData(balance, defaultDesignation.toUpperCase(), cashAccountID);
        }

    }

    public CashAccount(int cashAccountID) {
        if (!validateID(cashAccountID)) {
            throw new IllegalArgumentException("Cash Account ID is not valid");
        }
        this.accountData = new AccountData(0, "Cash Account" + " " + cashAccountID, cashAccountID);
    }

    public CashAccount(int cashAccountID, double balance) {
        if (!validateID(cashAccountID)) {
            throw new IllegalArgumentException("Cash Account ID is not valid");
        }
        if (!validateBalance(balance)) {
            throw new IllegalArgumentException("Balance can't be less than 0");
        }
        this.accountData = new AccountData(balance, "Cash Account" + " " + cashAccountID, cashAccountID);
    }

    // Business Methods

    /**
     * A method that validates if the given cash account ID is valid
     *
     * @param cashAccountID given cash account ID to validate
     * @return a boolean validID, true if valid, false if invalid
     */
    private boolean validateID(int cashAccountID) {
        boolean validID = true;
        if (cashAccountID < 0) {
            validID = false;
        }
        return validID;
    }

    /**
     * A method that validates if the given cash account balance is valid. Balance of a physical cash account can never
     * be less than 0.
     *
     * @param balance given cash account balance to validate
     * @return boolean validBalance, true if valid, false if invalid
     */
    private boolean validateBalance(double balance) {
        boolean validBalance = true;
        if (balance < 0) {
            validBalance = false;
        }
        return validBalance;
    }



    /**
     * Getter for the ID of this cash account object
     *
     * @return returns the ID of this cash account
     */
    public int getAccountID() {
        return
                this.accountData.getAccountID();
    }

    /**
     * Getter for the balance of this cash account object
     *
     * @return returns the balance of this cash account
     */
    public double getBalance() {
        return this.accountData.getBalance();
    }

    /**
     * Changes the balance of this cash account object by a given value
     *
     * @param value given value to add to this cash account's balance
     */
    public void changeBalance(double value) {
        if (!validateBalance(this.accountData.getBalance() + value)) {
            throw new IllegalStateException("Balance can't be less than 0");
        }
        this.accountData.setBalance(this.accountData.getBalance() + value);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof CashAccount)) return false;
        CashAccount otherAccount = (CashAccount) other;
        return (this.accountData.getAccountID() == otherAccount.getAccountID() && this.accountData.getBalance() == otherAccount.getBalance());
    }
}
