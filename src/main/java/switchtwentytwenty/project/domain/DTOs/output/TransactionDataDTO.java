package switchtwentytwenty.project.domain.DTOs.output;

import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.sandbox.TransactionData;

import java.util.Date;

public class TransactionDataDTO {

    private Date transactionDate;
    private double ammount; //Currency?
    private StandardCategory category;
    private String designation;
    private double remainingBalance;

    public TransactionDataDTO(TransactionData transactionData) {
        this.transactionDate = transactionData.getTransactionDate();
        this.ammount = transactionData.getAmmount();
        this.category = transactionData.getCategory();
        this.designation = transactionData.getDesignation();
        this.remainingBalance = transactionData.getRemainingBalance();
    }
}
