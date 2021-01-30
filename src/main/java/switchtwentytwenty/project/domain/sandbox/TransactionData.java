package switchtwentytwenty.project.domain.sandbox;

import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;

import java.util.Date;

public class TransactionData {
    private Date transactionDate;
    private Date registrationDate;
    // private Account destinationAccount;
    private double ammount; //Currency?
    private Category category;
    private String designation;
    private double remainingBalance;

    public TransactionData(String designation, double ammount, Date transactionDate, Category category) {
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

    public double getAmmount() {
        return this.ammount;
    }

    public double getRemainingBalance() {
        return this.remainingBalance;
    }
}
