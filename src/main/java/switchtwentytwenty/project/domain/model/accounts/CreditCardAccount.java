package switchtwentytwenty.project.domain.model.accounts;

import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.dtos.input.AddCreditCardAccountDTO;
import switchtwentytwenty.project.domain.dtos.output.AccountIDAndDescriptionDTO;
import switchtwentytwenty.project.domain.model.transactions.Transaction;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;
import switchtwentytwenty.project.domain.utils.exceptions.InvalidAccountDesignationException;

import java.util.List;
import java.util.Objects;

public class CreditCardAccount implements Account {

    private final MoneyValue withdrawalLimit;
    private final AccountType accountType = AccountType.CREDITCARDACCOUNT;
    // Attributes
    private AccountData accountData;
    private MoneyValue interestDebt;

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

    /**
     * Method to validate TotalDebt, must be not null and not less than zero
     *
     * @param totalDebt Value to be checked
     *                  If not valid throws an exception
     */
    protected void validateTotalDebt(Double totalDebt) {
        if (totalDebt == null || totalDebt < 0.00)
            throw new IllegalArgumentException("Total debt must not be null or greater than Zero");
    }

    /**
     * Method to check if interest is less than total debt
     *
     * @param intertestDebt Interest Debt
     * @param totalDebt     Total Debt
     *                      If interest debt greater than total debt throws an exception
     */
    protected void interestDebtLessThanTotalDebt(Double intertestDebt, Double totalDebt) {
        if (intertestDebt > totalDebt)
            throw new IllegalArgumentException("Interest Debt must be inferior than Total Debt");
    }

    /**
     * Method to validade InterestDebt
     *
     * @param interestDebt Value to be checked
     * @return false if is null or less than Zero (0)
     * true if equals or greater than zero
     */
    protected boolean validateInterestDebt(Double interestDebt) {
        if (interestDebt == null)
            return false;

        return interestDebt >= 0.00;
    }

    /**
     * Method to validade Withdrawal Limit
     *
     * @param withrawalLimit Value to be checked
     *                       If null or less than zero throws an exception
     */
    protected void validateWithrawalLimit(Double withrawalLimit) {
        if (withrawalLimit == null || withrawalLimit < 0.00)
            throw new IllegalArgumentException("withdrawal limit can't be less than 0");
    }

    /**
     * Method to get Interest Debt
     *
     * @return interestDebt
     */
    public MoneyValue getInterestDebt() {
        return this.interestDebt;
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
     * Method to debit from a Credit Card Account, will add (credit) the amount to balance
     * End balance must not be greater than withdrawalLimit
     *
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
     *
     * @param value MoneyValue to credit
     */
    public void credit(MoneyValue value) { //expense
        if ((this.accountData.getMoneyValue().debit(value).getValue() < 0.00))
            throw new IllegalArgumentException("Balance must be zero or greater");

        this.accountData.debit(value);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof CreditCardAccount)) return false;
        CreditCardAccount otherAccount = (CreditCardAccount) other;
        return this.accountData.equals(otherAccount.accountData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountData.getAccountID(), accountData.getDescription(), accountData.getListOfMovements(), accountData.getCurrentBalance().getValue(),
                accountData.getCurrentBalance().getCurrency(), interestDebt);
    }

    /**
     * Method to get Description of Account
     *
     * @return description
     */
    public String getDescription() {
        return this.accountData.getDescription();
    }

    /**
     * Method to check if the given int is accounts ID
     *
     * @param accountID ID to check
     * @return true if is ID of this Account
     * false if is not ID of this Account
     */
    public boolean isIDOfThisAccount(int accountID) {
        return this.accountData.isIDOfThisAccount(accountID);
    }

    /**
     * Method to check if this Account has enough money to do a given transaction
     *
     * @param transferenceAmount MoneyValeu to check
     * @return true if a a given MoneyVale plus current balance not exceeds withdrawal limit, else return false
     */
    public boolean hasEnoughMoneyForTransaction(MoneyValue transferenceAmount) {
        return transferenceAmount.getValue() + this.accountData.getMoneyValue().getValue() <= withdrawalLimit.getValue();
    }

    /**
     * Method to check AccountType
     *
     * @param accountType AccountType to compare
     * @return true if are equals, else return false
     */
    public boolean checkAccountType(AccountType accountType) {
        return this.accountType.equals(accountType);
    }

    /**
     * Method to get Balance
     *
     * @return return MoneyBalance
     */
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

    /**
     * Methdo to get a AccountIDAndDescriptionDTO of this Account
     *
     * @return AccountIDAndDescriptionDTO
     */
    public AccountIDAndDescriptionDTO getAccountIDAndDescriptionDTO() {
        return new AccountIDAndDescriptionDTO(this.accountData.getAccountID(), accountData.getDescription());
    }

    /**
     * Method to check if a given Currency
     *
     * @param currency Currency to compare
     * @return true if are equals, else return false
     */
    public boolean checkCurrency(CurrencyEnum currency) {
        return accountData.checkCurrency(currency);
    }

}
