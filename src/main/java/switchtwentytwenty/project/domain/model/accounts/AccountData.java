package switchtwentytwenty.project.domain.model.accounts;

import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.dtos.input.CashTransferDTO;
import switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.model.transactions.CashTransaction;
import switchtwentytwenty.project.domain.model.transactions.Transaction;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;
import switchtwentytwenty.project.domain.utils.exceptions.InvalidAccountDesignationException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class AccountData {

    private final int accountID;
    private final List<Transaction> transactions;
    private final SimpleDateFormat creationDate;
    private String description;
    private MoneyValue currentBalance;

    public AccountData(Double balance, String designation, int accountID) {
        validateDesignation(designation);
        this.description = designation;
        this.accountID = accountID;
        this.transactions = new ArrayList<>();
        this.creationDate = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
        this.currentBalance = new MoneyValue(balance, CurrencyEnum.EURO);
    }


    public AccountData(Double balance, String designation, int accountID, CurrencyEnum currencyEnum) {
        validateDesignation(designation);
        this.description = designation;
        this.accountID = accountID;
        this.transactions = new ArrayList<>();
        this.creationDate = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
        if (currencyEnum != null)
            this.currentBalance = new MoneyValue(balance, currencyEnum);
        else
            this.currentBalance = new MoneyValue(balance, CurrencyEnum.EURO);
    }

    public SimpleDateFormat getCreationDate() {
        return (SimpleDateFormat) this.creationDate.clone();
    }

    public void setBalance(double balance) {
        this.currentBalance = new MoneyValue(balance, this.currentBalance.getCurrencyType());
    }

    public void setBalance(MoneyValue balance) {
        this.currentBalance = balance;
    }

    public MoneyValue getCurrentBalance() {
        return this.currentBalance;
    }

    public void credit(MoneyValue moneyValue) {
        this.currentBalance = this.currentBalance.credit(moneyValue);
    }

    public void debit(MoneyValue moneyValue) {
        this.currentBalance = this.currentBalance.debit(moneyValue);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAccountID() {
        return accountID;
    }

    public boolean isIDOfThisAccount(int accountID) {
        return this.accountID == accountID;
    }

    private void validateDesignation(String designation) {
        if (designation == null || designation.isEmpty() || designation.trim().length() == 0) {
            throw new InvalidAccountDesignationException("Invalid account designation");
        }
    }

    @Override
    public boolean equals(Object otherAccountData) {
        if (this == otherAccountData) return true;
        if (!(otherAccountData instanceof AccountData)) return false;
        AccountData other = (AccountData) otherAccountData;
        return currentBalance.equals(other.currentBalance) &&
                accountID == other.accountID &&
                description.equals(other.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, accountID);
    }

    /**
     * Check if it has enough balance
     *
     * @param moneyValue
     * @return true if the account has enough balance | false if the account doesn't have enough balance
     */
    public boolean hasEnoughMoneyForTransaction(MoneyValue moneyValue) {
        if (moneyValue.getValue() < 0) {
            throw new IllegalArgumentException("The transaction ammount needs to be a positive value");
        }
        return ((this.currentBalance.getValue() - moneyValue.getValue()) >= 0);
    }

    /**
     * Register CashTransaction
     *
     * @param targetAccount
     * @param category
     * @param currentBalance
     * @param familyCashTransferDTO
     * @param credit
     * @return true if the transaction is added to the transaction List
     */

    public boolean registerCashTransaction(CashAccount targetAccount, Category category, MoneyValue currentBalance, FamilyCashTransferDTO familyCashTransferDTO, boolean credit) {
        CashTransaction cashTransaction = new CashTransaction(targetAccount, category, credit, currentBalance, familyCashTransferDTO);
        transactions.add(cashTransaction);
        return true;
    }

    public boolean registerCashTransaction(CashAccount targetAccount, Category category, MoneyValue currentBalance, CashTransferDTO cashTransferDTO, boolean credit) {
        CashTransaction cashTransaction = new CashTransaction(targetAccount, category, credit, currentBalance, cashTransferDTO);
        transactions.add(cashTransaction);
        return true;
    }

    public MoneyValue getMoneyValue() {
        return this.currentBalance;
    }

    /**
     * A method that returns this accounts list of registered transactions.
     *
     * @return List of registered transactions.
     */
    public List<Transaction> getListOfMovements() {
        return Collections.unmodifiableList(this.transactions);
    }

    public boolean checkCurrency(CurrencyEnum currency) {
        return this.currentBalance.getCurrencyType().equals(currency);
    }
}
