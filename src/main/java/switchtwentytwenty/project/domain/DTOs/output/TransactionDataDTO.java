package switchtwentytwenty.project.domain.DTOs.output;

import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.sandbox.TransactionData;

import java.util.Date;
import java.util.Objects;

public class TransactionDataDTO {

    private final Date transactionDate;
    private final double ammount; //Currency?
    private final Category category;
    private final String designation;
    private final double remainingBalance;

    public TransactionDataDTO(TransactionData transactionData) {
        this.transactionDate = transactionData.getTransactionDate();
        this.ammount = transactionData.getAmmount();
        this.category = transactionData.getCategory();
        this.designation = transactionData.getDesignation();
        this.remainingBalance = transactionData.getRemainingBalance();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionDataDTO that = (TransactionDataDTO) o;
        return Double.compare(that.ammount, ammount) == 0 && Double.compare(that.remainingBalance, remainingBalance) == 0 && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(category, that.category) && Objects.equals(designation, that.designation);
    }

    /*
    @Override
    public int hashCode() {
        return Objects.hash(transactionDate, ammount, category, designation, remainingBalance);
    }*/
}
