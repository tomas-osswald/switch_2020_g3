package switch2020.project.domain.model;

public class CreditCardAccount implements Account {

    // Attributes
    private AccountData accountData;
    private double withdrawalLimit;

    // Constructors
       public CreditCardAccount(double withdrawalLimit, int accountID) {
        if (!validateWithrawalLimit(withdrawalLimit)) {
            throw new IllegalArgumentException("withdrawal limit can't be less than 0");
        }
        this.accountData = new AccountData(withdrawalLimit, "Credit Card Account", accountID);
    }

    // Methods

    /**
     *
     * @param withrawalLimit
     * @return
     */
    private boolean validateWithrawalLimit(double withrawalLimit) {
        boolean validWithdrawalLimit = true;
        if (withrawalLimit < 0) {
            validWithdrawalLimit = false;
        }
        return validWithdrawalLimit;
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

    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }

        public void changeBalance(double value) { //expense
        if ((this.accountData.getBalance() - Math.abs(value)) > 0)
            throw new IllegalArgumentException("ultrapassa credito");
        this.accountData.setBalance(this.accountData.getBalance() - Math.abs(value));
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof CashAccount)) return false;
        CashAccount otherAccount = (CashAccount) other;
        return (this.accountData.getAccountID() == otherAccount.getAccountID() && this.accountData.getBalance() == otherAccount.getBalance());
    }

}
