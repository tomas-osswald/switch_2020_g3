package switchtwentytwenty.project.domain.model.accounts;

import switchtwentytwenty.project.domain.DTOs.MoneyValue;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.sandbox.CashTransaction;
import switchtwentytwenty.project.domain.sandbox.Transaction;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;
import switchtwentytwenty.project.domain.utils.TransferenceDTO;
import switchtwentytwenty.project.domain.utils.exceptions.InvalidAccountDesignationException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class AccountData {

    private Double balance = 0.00;
    private String description;
    private int accountID;
    private List<Transaction> transactions;
    private Date creationDate;
    private MoneyValue currentBalance;

    public AccountData(Double balance, String designation, int accountID) {
        validateDesignation(designation);
        this.balance = balance;
        this.description = designation;
        this.accountID = accountID;
        this.transactions = new ArrayList<>();
        this.creationDate = new Date();
        this.currentBalance = new MoneyValue(balance, CurrencyEnum.EURO);
    }

    public AccountData(Double balance, String designation, int accountID, CurrencyEnum currencyEnum) {
        validateDesignation(designation);
        this.description = designation;
        this.accountID = accountID;
        this.transactions = new ArrayList<>();
        this.creationDate = new Date();
        this.currentBalance = new MoneyValue(balance, currencyEnum); //TODO: Se não houver currencyEnum colocar default Euro? esta a ser feito em algum outro lado?
    }


    public Date getCreationDate() {
        return (Date) this.creationDate.clone();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setBalance(MoneyValue balance) {
        this.currentBalance = balance;
    }

    public MoneyValue getCurrentBalance() {
        return this.currentBalance;
    }

    public void changeBalance(double value) {
        this.balance += value;
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
        if (otherAccountData == null || !(otherAccountData instanceof AccountData)) return false;
        AccountData other = (AccountData) otherAccountData;
        return Double.compare(other.balance, balance) == 0 &&
                accountID == other.accountID &&
                description.equals(other.description);
    }

    public boolean hasEnoughMoneyForTransaction(double transferenceAmount) {
        if (transferenceAmount < 0) {
            throw new IllegalArgumentException("The transaction ammount needs to be a positive value");
        }
        return ((this.balance - transferenceAmount) >= 0);
    }

    public boolean registerTransaction(Account targetAccount, StandardCategory category, TransferenceDTO transferenceDTO) {
        // TODO: DUVIDA - Se este metodo esta no AccountData, nao pode ter construtor de CashTransaction. Se for exclusivo da CashAccount, entao retira-se daqui (interfere na BankAccount)
        CashTransaction cashTransaction = new CashTransaction(targetAccount, category, transferenceDTO);
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
}