package switchtwentytwenty.project.domain.dtos.input;

import java.util.Date;

public class CashTransferDTO {

    private final String originFamilyMemberCC;
    private final String destinationFamilyMemberCC;
    private final int familyID;
    private int originAccountID;
    private int destinationAccountID;
    private final double transferedValue; //Currency ?
    private final int categoryID;
    private final String transactionDesignation;
    private final Date transactionDate;


    public CashTransferDTO(int familyID, String originFamilyMemberCC, int originAccountID, String destinationFamilyMemberCC, int destinationAccountID, double transferedValue, int categoryID, String transactionDesignation, Date transactionDate) {
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

    public double getTransferedValue() {
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


