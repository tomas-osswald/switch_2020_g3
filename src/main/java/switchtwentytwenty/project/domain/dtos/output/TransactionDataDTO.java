package switchtwentytwenty.project.domain.DTOs.output;

import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.sandbox.TransactionData;

import java.util.Date;
import java.util.Objects;

public class TransactionDataDTO {

    private final Date transactionDate;
    private final MoneyValue ammount; //Currency?
    private final Category category;
    private final String designation;
    private final MoneyValue remainingBalance;

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
        return Double.compare(that.ammount.getValue(), ammount.getValue()) == 0 && Double.compare(that.remainingBalance.getValue(), remainingBalance.getValue()) == 0 && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(category, that.category) && Objects.equals(designation, that.designation);
    }

    /*
    @Override
    public int hashCode() {
        return Objects.hash(transactionDate, ammount, category, designation, remainingBalance);
    }*/
}
