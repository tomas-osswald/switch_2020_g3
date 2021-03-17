package switchtwentytwenty.project.domain.model.transactions;

import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.model.categories.Category;

import java.util.Date;

public class TransactionData {
    private final Date transactionDate;
    private final Date registrationDate;
    private final MoneyValue ammount;
    private final Category category;
    private final String designation;
    private final MoneyValue remainingBalance;
    private final boolean credit;

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

    /**
     * A method that returns true if a given transaction occurred between two given dates.
     * If the dates are switched, the method will switch them back around.
     * @param startDate    first date
     * @param endDate      last date
     * @return true if between given dates, else false
     */
    public boolean checkIfMovementBetweenDates(Date startDate, Date endDate) {

        // Switch dates if endDate is earlier than startDate
        if (startDate.after(endDate)) {
            Date temp = (Date) startDate.clone();
            startDate = endDate;
            endDate = temp;
        }

        boolean isBetweenDates = false;
        if (transactionDate.after(startDate) && transactionDate.before(endDate)) {
            isBetweenDates = true;
        }
        return isBetweenDates;
    }
}
