package switchtwentytwenty.project.domain.model.accounts;

import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.dtos.input.AddCashAccountDTO;
import switchtwentytwenty.project.domain.dtos.input.CashTransferDTO;
import switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO;
import switchtwentytwenty.project.domain.dtos.output.AccountIDAndDescriptionDTO;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.model.transactions.Transaction;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;
import switchtwentytwenty.project.domain.utils.exceptions.InvalidAccountDesignationException;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof CashAccount)) return false;
        CashAccount otherAccount = (CashAccount) other;
        return (this.accountData.equals(otherAccount.accountData));
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountData.getAccountID(), accountData.getDescription(), accountData.getListOfMovements(), accountData.getCurrentBalance().getValue(),
                accountData.getCurrentBalance().getCurrency());
    }

    public AccountIDAndDescriptionDTO getAccountIDAndDescriptionDTO(){
        return new AccountIDAndDescriptionDTO(this.accountData.getAccountID(), accountData.getDescription());
    }

    public boolean isIDOfThisAccount(int accountID) {
        return this.accountData.isIDOfThisAccount(accountID);
    }

    /**
     * Method to determine if an account has enough moeny for a transaction
     * @param value monetary value - ammount and currency type
     * @return true if account has enough money, false otherwise
     */
    public boolean hasEnoughMoneyForTransaction(MoneyValue value) {
        if (value.getValue() < 0){
            throw new IllegalArgumentException("The transaction ammount needs to be a positive value");
        }
        return this.accountData.getMoneyValue().debit(value).getValue() >= 0;
    }

    /**
<<<<<<< HEAD
     * Method that registers a transaction in an account
     * @param targetAccount the otherAccount related to this transaction if it involves two accounts
     * @param category the category of the Transaction
     * @param credit boolean that determines if the transfer is a credit transfer (when true) or a debit transfer (when false
     * @param remainingbalance the balance remaining in the account after the transaction
     * @param familyCashTransferDTO
     * @return
     */
    public boolean registerTransaction(CashAccount targetAccount, Category category,boolean credit, MoneyValue remainingbalance, FamilyCashTransferDTO familyCashTransferDTO) {
        accountData.registerCashTransaction(targetAccount, category,remainingbalance, familyCashTransferDTO, credit);
        return true;
    }

    public boolean registerTransaction(CashAccount targetAccount, Category category,boolean credit, MoneyValue remainingbalance, CashTransferDTO cashTransferDTO) {
        accountData.registerCashTransaction(targetAccount, category,remainingbalance, cashTransferDTO, credit);
        return true;
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

    public void debit(MoneyValue value) {
        if (accountData.getMoneyValue().getValue() - value.getValue() < 0) throw new IllegalStateException("Balance can't be less than 0");

        accountData.debit(value);
    }

    public void credit(MoneyValue value) {
        accountData.credit(value);
    }


    /**
     * Method to determine if the account is in a given currency type.
     * @param currency the currency type to compare
     * @return true if the same currency otherwise false
     */
    public boolean checkCurrency(CurrencyEnum currency){
        return accountData.checkCurrency(currency);
    }
}
