package switchtwentytwenty.project.domain.model.accounts;

import switchtwentytwenty.project.domain.DTOs.MoneyValue;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.sandbox.CashTransaction;
import switchtwentytwenty.project.domain.sandbox.Transaction;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;
import switchtwentytwenty.project.domain.utils.TransferenceDTO;
import switchtwentytwenty.project.domain.utils.exceptions.InvalidAccountDesignationException;

import java.util.ArrayList;
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
        this.currentBalance = new MoneyValue(balance, currencyEnum);
    }

    public Date getCreationDate() {
        return (Date) this.creationDate.clone();
    }

    public double getBalance() {
        return balance;
    }

    public MoneyValue getCurrentBalance() {
        return this.currentBalance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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
        return (this.balance - transferenceAmount) >= 0;
    }

    public boolean registerTransaction(Account targetAccount, StandardCategory category, TransferenceDTO transferenceDTO) {
        CashTransaction cashTransaction = new CashTransaction(targetAccount, category, transferenceDTO);

        transactions.add(cashTransaction);
        return true;
    }

}
