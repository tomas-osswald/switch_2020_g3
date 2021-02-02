package switchtwentytwenty.project.domain.model.accounts;

import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.sandbox.CashTransaction;
import switchtwentytwenty.project.domain.sandbox.Transaction;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;
import switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO;
import switchtwentytwenty.project.domain.utils.exceptions.InvalidAccountDesignationException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class AccountData {

    private String description;
    private int accountID;
    private List<Transaction> transactions;
    private SimpleDateFormat creationDate;
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

        if(currencyEnum != null)
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

    public void credit(MoneyValue moneyValue){
        this.currentBalance=this.currentBalance.credit(moneyValue);
    }
    public void debit(MoneyValue moneyValue){
        this.currentBalance=this.currentBalance.debit(moneyValue);
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
        return currentBalance.equals(other.currentBalance) &&
                accountID == other.accountID &&
                description.equals(other.description);
    }

    /*public boolean hasEnoughMoneyForTransaction(MoneyValue moneyValue) { // TODO: Alterar "transferenceAmount" para formato MoneyValue
        if (moneyValue.getValue() < 0) {
            throw new IllegalArgumentException("The transaction ammount needs to be a positive value");
        }
        return ((this.currentBalance.getValue() - moneyValue.getValue()) >= 0);
    }*/

    public boolean registerCashTransaction(CashAccount targetAccount, Category category, FamilyCashTransferDTO familyCashTransferDTO) {
        CashTransaction cashTransaction = new CashTransaction(targetAccount, category, familyCashTransferDTO);
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

    public boolean checkCurrency(CurrencyEnum currency){
        return this.currentBalance.getCurrencyType().equals(currency);
    }
}
