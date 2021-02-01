package switchtwentytwenty.project.domain.model.accounts;

import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.dtos.input.AddCashAccountDTO;
import switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.sandbox.Transaction;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;
import switchtwentytwenty.project.domain.utils.exceptions.InvalidAccountDesignationException;

import java.sql.SQLOutput;
import java.util.List;

public class CashAccount implements Account {


    private final AccountType accountType = new AccountType(AccountTypeEnum.CASHACCOUNT);
    // Attributes
    private AccountData accountData;

    // Constructors
    public CashAccount(AddCashAccountDTO cashAccountDTO, int cashAccountID) {
        if (!validateBalance(cashAccountDTO.getBalance())) {
            throw new IllegalArgumentException("Balance can't be negative");
        }
        try {
            this.accountData = new AccountData(cashAccountDTO.getBalance(), cashAccountDTO.getDescription(), cashAccountID, cashAccountDTO.getCurrency());
        } catch (InvalidAccountDesignationException exception) {
            String defaultDesignation = "Cash Account with ID" + " " + cashAccountID;
            this.accountData = new AccountData(cashAccountDTO.getBalance(), defaultDesignation.toUpperCase(), cashAccountID, cashAccountDTO.getCurrency());
        }

    }

    public CashAccount(String accountDesignation, double initialBalance, int accountID, CurrencyEnum currency) {
        if (!validateBalance(initialBalance)) {
            throw new IllegalArgumentException("Balance can't be less than 0");
        }
        try {
            this.accountData = new AccountData(initialBalance, accountDesignation, accountID, currency);
        } catch (InvalidAccountDesignationException exception) {
            String defaultDesignation = "Cash Account with ID" + " " + accountID;
            this.accountData = new AccountData(initialBalance, defaultDesignation.toUpperCase(), accountID, currency);
        }

    }


    // Business Methods


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

    public boolean isIDOfThisAccount(int accountID) {
        return this.accountData.isIDOfThisAccount(accountID);
    }

    public boolean hasEnoughMoneyForTransaction(MoneyValue value) {
        return accountData.hasEnoughMoneyForTransaction(value);
    }

    public boolean registerTransaction(CashAccount targetAccount, Category category, FamilyCashTransferDTO familyCashTransferDTO) {
        return accountData.registerCashTransaction(targetAccount, category, familyCashTransferDTO);
    }

    public boolean checkAccountType(AccountTypeEnum accountTypeEnum) {
        return this.accountType.getAccountType().equals(accountTypeEnum);
    }

    public String getDescription() {
        return accountData.getDescription();
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

    public void debit(MoneyValue value) { //expense

    }

    public void credit(MoneyValue value) { //expense

    }


    public boolean checkCurrency(CurrencyEnum currency){
        return accountData.checkCurrency(currency);
    }
}
