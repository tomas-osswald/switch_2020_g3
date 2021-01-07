package switch2020.project.model;

public class CashAccount {

    // Attributes
    private int cashAccountID;
    private double balance;

    // Constructors
    public CashAccount() {
        this.cashAccountID = 0;
        this.balance = 0;
    }

    public CashAccount(int cashAccountID) {
        if (!validateID(cashAccountID)) {
            throw new IllegalArgumentException("Cash Account ID is not valid");
        }
        this.cashAccountID = cashAccountID;
        this.balance = 0;
    }

    // Business Methods
    /**
     * A method that validates if the given cash account ID is valid
     *
     * @param cashAccountID given cash account ID to validate
     * @return a boolean validID, true if valid, false if invalid
     */
    private boolean validateID(int cashAccountID) {
        boolean validID = false;
        if (cashAccountID >= 0) {
            validID = true;
        }
        return validID;
    }

    /**
     * Getter for the ID of this cash account object
     * @return returns the ID of this cash account
     */
    public int getCashAccountID() {
        return cashAccountID;
    }

    /**
     * Getter for the balance of this cash account object
     * @return returns the balance of this cash account
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Changes the balance of this cash account object by a given value
     * @param value given value to add to this cash account's balance
     */
    public void changeBalance(double value) {
        this.balance = this.balance + value;
    }
}
