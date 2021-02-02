package switchtwentytwenty.project.domain.model.accounts;

import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.dtos.input.AddCreditCardAccountDTO;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.sandbox.Transaction;
import switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;
import switchtwentytwenty.project.domain.utils.exceptions.InvalidAccountDesignationException;

import java.util.List;

public class CreditCardAccount implements Account {

    // Attributes
    private AccountData accountData;
    private MoneyValue withdrawalLimit;
    private MoneyValue interestDebt;
    private final AccountType accountType = new AccountType(AccountTypeEnum.CREDITCARDACCOUNT);

    // Constructors
    public CreditCardAccount(AddCreditCardAccountDTO addCreditCardAccountDTO, int accountID) {
        validateWithrawalLimit(addCreditCardAccountDTO.getWithdrawalLimit());
        try {
            this.accountData = new AccountData(addCreditCardAccountDTO.getTotalDebt(), addCreditCardAccountDTO.getCardDescription(), accountID, addCreditCardAccountDTO.getCurrency());
        } catch (InvalidAccountDesignationException exception) {
            String cardDescriptionDefault = "Credit Card Account " + "-" + " Account #" + accountID;
            this.accountData = new AccountData(addCreditCardAccountDTO.getTotalDebt(), cardDescriptionDefault, accountID, addCreditCardAccountDTO.getCurrency());
        }

        this.withdrawalLimit = new MoneyValue(addCreditCardAccountDTO.getWithdrawalLimit(), addCreditCardAccountDTO.getCurrency());

        if (validateInterestDebt(addCreditCardAccountDTO.getInterestDebt())) {
            validateTotalDebt(addCreditCardAccountDTO.getTotalDebt());
            interestDebtLessThanTotalDebt(addCreditCardAccountDTO.getInterestDebt(), addCreditCardAccountDTO.getTotalDebt());

            this.interestDebt = new MoneyValue(addCreditCardAccountDTO.getInterestDebt(), addCreditCardAccountDTO.getCurrency());
        } else {
            this.interestDebt = new MoneyValue(0.00, addCreditCardAccountDTO.getCurrency());
        }
    }



    // Bussiness Methods

    protected void validateTotalDebt(Double totalDebt) {
        if (totalDebt == null || totalDebt < 0.00)
            throw new IllegalArgumentException("Total debt must not be null or greater than Zero");
    }

    protected void interestDebtLessThanTotalDebt(Double intertestDebt, Double totalDebt) {
        if (intertestDebt > totalDebt)
            throw new IllegalArgumentException("Interest Debt must be inferior than Total Debt");
    }

    protected boolean validateInterestDebt(Double interestDebt) {
        if (interestDebt == null)
            return false;

        if (interestDebt < 0.00)
            return false;
        return true;
    }

    public MoneyValue getInterestDebt() {
        return this.interestDebt;
    }

    /**
     * @param withrawalLimit
     */

    protected void validateWithrawalLimit(Double withrawalLimit) {
        if (withrawalLimit == null || withrawalLimit < 0.00)
            throw new IllegalArgumentException("withdrawal limit can't be less than 0");
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

    //TODO: Deixar em java doc a diferença entre debit e credit no credit card account

    /**
     * Method to debit from a Credit Card Account, will add (credit) the amount to balance
     * End balance must not be greater than withdrawalLimit
     * @param value MoneyValue to debit
     */
    public void debit(MoneyValue value) { //expense
        if ((this.accountData.getMoneyValue().credit(value).compareTo(withdrawalLimit) > 0.00))
            throw new IllegalArgumentException("Credit exceeded");

        this.accountData.credit(value);
    }

    /**
     * Method to credit from a Credit Card Account, will subtract (debit) the amount to balance
     * End balance must not be less than zero
     * @param value MoneyValue to credit
     */
    public void credit(MoneyValue value) { //expense
        if ((this.accountData.getMoneyValue().debit(value).getValue() < 0.00))
            throw new IllegalArgumentException("Balance must be zero or greater");

        this.accountData.debit(value);
    }


    /*
    //while
    //25 the balance of a credit card account is the amount due at that moment

    public void changeBalance(MoneyValue value) { //expense
        // validar se mesma moeda
        if ((this.accountData.getBalance() + Math.abs(value.getValue())) > withdrawalLimit.getValue())
            throw new IllegalArgumentException("ultrapassa credito");

        this.accountData.setBalance(this.accountData.getCurrentBalance().getValue() + Math.abs(value.getValue()));

    }
     */

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

    public boolean isIDOfThisAccount(int accountID) {
        return this.accountData.isIDOfThisAccount(accountID);
    }

    public boolean hasEnoughMoneyForTransaction(MoneyValue transferenceAmount) {
        if (transferenceAmount.getValue() + this.accountData.getMoneyValue().getValue() <= withdrawalLimit.getValue())
            return true;
        return false;
    }

    public boolean checkAccountType(AccountTypeEnum accountTypeEnum) {
        return this.accountType.getAccountType().equals(accountTypeEnum);
    }

    public MoneyValue getMoneyBalance() {
        return this.accountData.getCurrentBalance();
    }

    /**
     * A method that returns the list of movements stored in this account's AccountData attribute
     *
     * @return List of movements
     */
    public List<Transaction> getListOfMovements() {
        return this.accountData.getListOfMovements();
    }

    public boolean checkCurrency(CurrencyEnum currency){
        return accountData.checkCurrency(currency);
    }

}
