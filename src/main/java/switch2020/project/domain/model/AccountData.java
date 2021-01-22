package switch2020.project.domain.model;

import switch2020.project.domain.sandbox.Transaction;
import switch2020.project.domain.utils.exceptions.InvalidAccountDesignationException;

import java.util.ArrayList;
import java.util.List;

public class AccountData {

    private double balance = 0;
    private String description;
    private int accountID;
    private List<Transaction> transactions;


    public AccountData(double balance, String designation, int accountID) {
        validateDesignation(designation);
        this.balance = balance;
        this.description = designation;
        this.accountID = accountID;
        this.transactions = new ArrayList<>();

    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    private void validateDesignation(String designation) {
        if (designation == null || designation.isEmpty() || designation.isBlank()) {
            throw new InvalidAccountDesignationException("Invalid account designation");
        } else if (designation.length() >= 20) {
            throw new IllegalArgumentException("Account name can't have more than 20 characters");
        }
    }
}
