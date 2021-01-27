package switch2020.project.domain.model.accounts;

import switch2020.project.domain.model.categories.StandardCategory;
import switch2020.project.domain.utils.TransferenceDTO;
import switch2020.project.domain.utils.exceptions.InvalidAccountDesignationException;

public class CreditCardAccount implements Account {

    // Attributes
    private AccountData accountData;
    private double withdrawalLimit;

    // Constructors
    public CreditCardAccount(double withdrawalLimit, String cardDescription, int accountID) {
        validadeWithrawLimit(withdrawalLimit);
        try {
            this.accountData = new AccountData(withdrawalLimit, cardDescription, accountID);
        } catch (InvalidAccountDesignationException exception) {
            String cardDescriptionDefault = "Credit Card Account " + "-" + " Account #" + accountID;
            this.accountData = new AccountData(withdrawalLimit, cardDescriptionDefault, accountID);
        }
        this.withdrawalLimit = withdrawalLimit;
    }

    // Bussiness Methods

    /**
     *
     * @param withdrawalLimit
     */

    private void validadeWithrawLimit(double withdrawalLimit) {
        if (!validateWithrawalLimit(withdrawalLimit)) {
            throw new IllegalArgumentException("withdrawal limit can't be less than 0");
        }
    }
    /**
     * @param withrawalLimit
     * @return
     */

    private boolean validateWithrawalLimit(Double withrawalLimit) {
        if (withrawalLimit == null)
            return false;
        return withrawalLimit > 0.0;
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

    /*public double getWithdrawalLimit() {
        return withdrawalLimit;
    }*/

    public void changeBalance(double value) { //expense
        if ((this.accountData.getBalance() - Math.abs(value)) > 0)
            throw new IllegalArgumentException("ultrapassa credito");
        this.accountData.setBalance(this.accountData.getBalance() - Math.abs(value));
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof CreditCardAccount)) return false;
        CreditCardAccount otherAccount = (CreditCardAccount) other;
        return this.accountData.equals(otherAccount.accountData);
    }

    public String getDescription() {
        return this.accountData.getDescription();
    }

    public boolean isIDOfThisAccount(int accountID){
        return this.accountData.isIDOfThisAccount(accountID);
    }

    public boolean hasEnoughMoneyForTransaction(double transferenceAmount ){
        return accountData.hasEnoughMoneyForTransaction(transferenceAmount);

    }
    public boolean registerTransaction(Account targetAccount, StandardCategory category, TransferenceDTO transferenceDTO){
        return accountData.registerTransaction(targetAccount, category, transferenceDTO);
    }

}
