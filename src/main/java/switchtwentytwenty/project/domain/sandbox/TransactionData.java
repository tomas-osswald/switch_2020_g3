package switchtwentytwenty.project.domain.sandbox;

import switchtwentytwenty.project.domain.model.categories.StandardCategory;

import java.util.Date;

public class TransactionData {
    private Date transactionDate;
    private Date registrationDate;
    // private Account destinationAccount;
    private double ammount; //Currency?
    private StandardCategory category;
    private String designation;
    private double remainingBalance;

    public TransactionData(String designation, double ammount, Date transactionDate, StandardCategory category) {
        this.transactionDate = (Date) transactionDate.clone();
        this.registrationDate = new Date();
        this.ammount = ammount;
        this.category = category;
        this.designation = designation;
    }

    public Date getTransactionDate() {
        return this.transactionDate;
    }

    public Date getRegistrationDate() {
        return this.transactionDate;
    }

    public StandardCategory getCategory() {
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
