package switchtwentytwenty.project.domain.model.transactions;

import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.model.categories.Category;

import java.util.Date;

public class TransactionData {
    private Date transactionDate;
    private Date registrationDate;
    private MoneyValue ammount;
    private Category category;
    private String designation;
    private MoneyValue remainingBalance;
    private boolean credit;

    public TransactionData(String designation, MoneyValue ammount, boolean credit, MoneyValue remainingbalance, Date transactionDate, Category category) {
        this.transactionDate = (Date) transactionDate.clone();
        this.registrationDate = new Date();
        this.ammount = ammount;
        this.category = category;
        this.designation = designation;
        this.credit = credit;
        this.remainingBalance = remainingbalance;
    }

    public Date getTransactionDate() {
        return (Date) this.transactionDate.clone();
    }

    public Date getRegistrationDate() {
        return (Date) this.registrationDate.clone();
    }

    public Category getCategory() {
        return this.category;
    }

    public String getDesignation() {
        return this.designation;
    }

    public MoneyValue getAmmount() {
        return this.ammount;
    }

    public MoneyValue getRemainingBalance() {
        return this.remainingBalance;
    }

    public boolean isCredit() {
        return this.credit;
    }

    public boolean isDebit() {
        return !this.credit;
    }
}
