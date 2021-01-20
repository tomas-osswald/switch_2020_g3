package switch2020.project.domain.model;

public class CashAccount {

    // Attributes
    private final int cashAccountID;
    private double balance;

    // Constructors
    public CashAccount(double balance) {
        if (!validateBalance(balance)) {
            throw new IllegalArgumentException("Balance can't be less than 0");
        }
        this.cashAccountID = 0;
        this.balance = balance;
    }

    public CashAccount(int cashAccountID) {
        if (!validateID(cashAccountID)) {
            throw new IllegalArgumentException("Cash Account ID is not valid");
        }
        this.cashAccountID = cashAccountID;
        this.balance = 0;
    }

    public CashAccount(int cashAccountID, double balance) {
        if (!validateID(cashAccountID)) {
            throw new IllegalArgumentException("Cash Account ID is not valid");
        }
        if (!validateBalance(balance)) {
            throw new IllegalArgumentException("Balance can't be less than 0");
        }
        this.cashAccountID = cashAccountID;
        this.balance = balance;
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
    public int getCashAccountID() {
        return cashAccountID;
    }

    /**
     * Getter for the balance of this cash account object
     *
     * @return returns the balance of this cash account
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Changes the balance of this cash account object by a given value
     *
     * @param value given value to add to this cash account's balance
     */
    public void changeBalance(double value) {
        if (!validateBalance(balance + value)) {
            throw new IllegalStateException("Balance can't be less than 0");
        }
        this.balance = this.balance + value;
    }

    public void addAmmount(double valueToAdd) {
        this.balance += valueToAdd;
    }

    public void subtractAmmount(double valueToSubtract) {
        this.balance -= valueToSubtract;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof CashAccount)) return false;
        CashAccount otherAccount = (CashAccount) other;
        return (this.cashAccountID == otherAccount.cashAccountID && this.balance == otherAccount.balance);
    }
}
