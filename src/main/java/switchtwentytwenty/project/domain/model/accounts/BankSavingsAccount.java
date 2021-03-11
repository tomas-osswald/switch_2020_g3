package switchtwentytwenty.project.domain.model.accounts;

import switchtwentytwenty.project.domain.dtos.MoneyValue;

import switchtwentytwenty.project.domain.dtos.input.AddBankSavingsAccountDTO;
import switchtwentytwenty.project.domain.model.transactions.Transaction;

import switchtwentytwenty.project.domain.dtos.output.AccountIDAndDescriptionDTO;

import switchtwentytwenty.project.domain.utils.CurrencyEnum;
import switchtwentytwenty.project.domain.utils.exceptions.InvalidAccountDesignationException;

import java.util.List;
import java.util.Objects;

public class BankSavingsAccount implements Account {


    private final AccountType accountType = AccountType.BANKSAVINGSACCOUNT;
    // Attributes
    private AccountData accountData;
    private final double interestRate;


    // Constructors
    public BankSavingsAccount(int accountID, AddBankSavingsAccountDTO addBankSavingsAccountDTO) {
        CurrencyEnum currencyEnum = addBankSavingsAccountDTO.getCurrency();
        Double balance = addBankSavingsAccountDTO.getBalance();
        if (!validateBalance(balance)) {
            balance = 0.00;
        }

        try {
            String name = addBankSavingsAccountDTO.getDescription();
            this.accountData = new AccountData(balance, name, accountID);
        } catch (InvalidAccountDesignationException exception) {
            String defaultDesignation = "Bank Savings Account with ID" + " " + accountID;
            this.accountData = new AccountData(balance, defaultDesignation, accountID, currencyEnum);
        }

        Double rate = addBankSavingsAccountDTO.getInterestRate();
        if (!validateInterestRate(rate)) {
            rate = 0.00;
        }
        this.interestRate = rate;
    }


    // Business Methods

    private boolean validateBalance(Double balance) {
        boolean valid = true;
        if (balance == null) {
            valid = false;
        }
        return valid;
    }

    private boolean validateInterestRate(Double interestRate) {
        boolean valid = true;
        if (interestRate == null) {
            valid = false;
        }
        return valid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountData.getAccountID(), accountData.getDescription(), accountData.getListOfMovements(), accountData.getCurrentBalance().getValue(),
                accountData.getCurrentBalance().getCurrency(), interestRate);
    }

    /**
     * Returns the ID of this account.
     * @return account ID
     */
    public int getAccountID() {
        return this.accountData.getAccountID();
    }

    /**
     * Returns the interestRate of this account.
     * @return interestRate
     */
    public double getInterestRate() {
        return this.interestRate;
    }

    /**
     * Returns the AccountData of this account.
     * @return accountData
     */
    public AccountData getAccountData() {
        return accountData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankSavingsAccount that = (BankSavingsAccount) o;
        return Double.compare(that.interestRate, interestRate) == 0 && accountData.equals(that.accountData);
    }

    /**
     * A method that returns true if the ID of this account is equal to a given ID.
     * @param accountID given ID
     * @return true if equal, false if different.
     */
    public boolean isIDOfThisAccount(int accountID) {
        return this.accountData.isIDOfThisAccount(accountID);
    }

    /**
     * Returns this accounts description
     * @return description
     */
    public String getDescription() {
        return accountData.getDescription();
    }

    /**
     * A method that checks if this account type is the same as a given AccountTypeEnum.
     * @param accountType given AccountTypeEnum
     * @return true if equal, false if different
     */
    public boolean checkAccountType(AccountType accountType) {
        return this.accountType.equals(accountType);
    }

    /**
     * A method that returns this accounts balance in a MoneyValue object
     * @return this accounts balance
     */
    public MoneyValue getMoneyBalance() {
        return this.accountData.getCurrentBalance();
    }

    /**
     * A method that returns the list of movements stored in this account's AccountData attribute
     * @return List of movements
     */
    public List<Transaction> getListOfMovements() {
        return this.accountData.getListOfMovements();
    }

    public AccountIDAndDescriptionDTO getAccountIDAndDescriptionDTO(){
        return new AccountIDAndDescriptionDTO(this.accountData.getAccountID(), accountData.getDescription());
    }

    /**
     * A method that subtracts a given MoneyValue to this Accounts MoneyValue
     * @param value given MoneyValue
     */
    public void debit(MoneyValue value) { //expense
        accountData.debit(value);
    }

    /**
     * A method that adds a given MoneyValue to this Accounts MoneyValue
     * @param value given MoneyValue
     */
    public void credit(MoneyValue value) { //expense
        accountData.credit(value);
    }

    /**
     * A method that checks if the currency of this account is equal to a given CurrencyEnum
     * @param currency given CurrencyEnum
     * @return true if equal, false if different
     */
    public boolean checkCurrency(CurrencyEnum currency) {
        return accountData.checkCurrency(currency);
    }

    /**
     * A method that always returns true, because there has no restrictions for this account type
     * @param value
     * @return
     */
    public boolean hasEnoughMoneyForTransaction(MoneyValue value) {
        return true;
    }

}