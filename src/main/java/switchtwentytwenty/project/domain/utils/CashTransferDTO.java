package switchtwentytwenty.project.domain.utils;

import switchtwentytwenty.project.domain.dtos.MoneyValue;

import java.util.Date;

public class CashTransferDTO {

    private final String originFamilyMemberCC;
    private final String destinationFamilyMemberCC;
    private final int familyID;
    private final MoneyValue transferedValue; //Currency ?
    private final int categoryID;
    private final String transactionDesignation;
    private final Date transactionDate;
    private int originAccountID;
    private int destinationAccountID;


    public CashTransferDTO(int familyID, String originFamilyMemberCC, int originAccountID, String destinationFamilyMemberCC, int destinationAccountID, MoneyValue transferedValue, int categoryID, String transactionDesignation, Date transactionDate) {
        this.familyID = familyID;
        this.originFamilyMemberCC = originFamilyMemberCC;
        this.originAccountID = originAccountID;
        this.destinationFamilyMemberCC = destinationFamilyMemberCC;
        this.destinationAccountID = destinationAccountID;
        this.transferedValue = transferedValue;
        this.categoryID = categoryID;
        this.transactionDesignation = transactionDesignation;
        this.transactionDate = (Date) transactionDate.clone();
    }

    public int getFamilyID() {
        return familyID;
    }

    public String getOriginFamilyMemberCC() {
        return originFamilyMemberCC;
    }

    public int getOriginAccountID() {
        return originAccountID;
    }

    public String getDestinationFamilyMemberCC() {
        return destinationFamilyMemberCC;
    }

    public int getDestinationAccountID() {
        return destinationAccountID;
    }

    public MoneyValue getTransferedValue() {
        return transferedValue;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public String getTransactionDesignation() {
        return transactionDesignation;
    }

    public Date getTransactionDate() {
        return (Date) transactionDate.clone();
    }

}


