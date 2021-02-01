package switchtwentytwenty.project.domain.sandbox;

import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.model.categories.Category;

import java.util.Date;

public class TransactionData {
    private Date transactionDate;
    private Date registrationDate;
    // private Account destinationAccount;
    private MoneyValue ammount; //Currency?
    private Category category;
    private String designation;
    private MoneyValue remainingBalance = new MoneyValue(0.0, null);

    public TransactionData(String designation, MoneyValue ammount, Date transactionDate, Category category) {
        this.transactionDate = (Date) transactionDate.clone();
        this.registrationDate = new Date();
        this.ammount = ammount;
        this.category = category;
        this.designation = designation;
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
}
