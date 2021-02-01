package switchtwentytwenty.project.domain.model.accounts;

import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.dtos.input.AddCreditCardAccountDTO;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.sandbox.Transaction;
import switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO;
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
        validateWithrawalLimit(addCreditCardAccountDTO.getWithdrwaLimit());


        try {
            this.accountData = new AccountData(addCreditCardAccountDTO.getTotalDebt(), addCreditCardAccountDTO.getCardDescription(), accountID);
        } catch (InvalidAccountDesignationException exception) {
            String cardDescriptionDefault = "Credit Card Account " + "-" + " Account #" + accountID;
            this.accountData = new AccountData(addCreditCardAccountDTO.getTotalDebt(), cardDescriptionDefault, accountID);
        }

        this.withdrawalLimit = new MoneyValue(addCreditCardAccountDTO.getWithdrwaLimit(), addCreditCardAccountDTO.getCurrency());

        if (validateInterestDebt(addCreditCardAccountDTO.getInterestDebt())) {
            interestDebtLessThanTotalDebt(addCreditCardAccountDTO.getInterestDebt(), addCreditCardAccountDTO.getTotalDebt());

            this.interestDebt = new MoneyValue(addCreditCardAccountDTO.getInterestDebt(), addCreditCardAccountDTO.getCurrency());
        } else{
            this.interestDebt = new MoneyValue(0.00, addCreditCardAccountDTO.getCurrency());
        }
    }

    // Bussiness Methods

    private void interestDebtLessThanTotalDebt(Double intertestDebt, Double totalDebt) {
        if (intertestDebt > totalDebt)
            throw new IllegalArgumentException("Interest Debt must be inferior than Total Debt");
    }

    private boolean validateInterestDebt(Double interestDebt) {
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
     * @param withdrawalLimit
     */

   /* private void validadeWithrawLimit(double withdrawalLimit) {
        if (!validateWithrawalLimit(withdrawalLimit)) {
            throw new IllegalArgumentException("withdrawal limit can't be less than 0");
        }
    }*/

    /**
     * @param withrawalLimit
     */

    private void validateWithrawalLimit(Double withrawalLimit) {
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

    //TODO: Deixar em java doc a diferença entre debit e credit no credit card account

    public void debit(MoneyValue value) { //expense
        if ((this.accountData.getMoneyValue().credit(value).compareTo(withdrawalLimit) > 0.00))
            throw new IllegalArgumentException("Credit exceeded");

        this.accountData.setBalance(this.accountData.getMoneyValue().credit(value));
    }

    public void credit(MoneyValue value) { //expense
        if ((this.accountData.getMoneyValue().credit(value).compareTo(withdrawalLimit) > 0.00))
            throw new IllegalArgumentException("Credit exceeded");

        this.accountData.setBalance(this.accountData.getMoneyValue().debit(value));
    }

    //while
    //25 the balance of a credit card account is the amount due at that moment

    public void changeBalance(double value) { //expense
        // validar se mesma moeda
        if ((this.accountData.getBalance() + Math.abs(value)) > withdrawalLimit.getValue())
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

    public boolean isIDOfThisAccount(int accountID) {
        return this.accountData.isIDOfThisAccount(accountID);
    }

    public boolean hasEnoughMoneyForTransaction(MoneyValue transferenceAmount) {
        if (transferenceAmount.getValue() + this.accountData.getMoneyValue().getValue() < withdrawalLimit.getValue())
            return true;
        return false;
    }

    public boolean registerTransaction(Account targetAccount, Category category, FamilyCashTransferDTO familyCashTransferDTO) {
        return accountData.registerTransaction(targetAccount, category, familyCashTransferDTO);
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
}
