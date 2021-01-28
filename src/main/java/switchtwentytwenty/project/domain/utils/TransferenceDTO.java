package switchtwentytwenty.project.domain.utils;

import java.util.Date;

public class TransferenceDTO {

    private int familyID;
    private String familyMemberCC;
    private int accountID;
    private double transferedValue; //Currency ?
    private int categoryID;
    private String transactionDesignation;
    private Date transactionDate;

    public TransferenceDTO(int familyID, String familyMemberCC, int accountID, double transferedValue, int categoryID, String transactionDesignation, Date transactionDate) {
        this.familyID = familyID;
        this.familyMemberCC = familyMemberCC;
        this.accountID = accountID;
        this.transferedValue = transferedValue;
        this.categoryID = categoryID;
        this.transactionDesignation = transactionDesignation;
        this.transactionDate = (Date) transactionDate.clone();
    }

    public int getFamilyID() {
        return familyID;
    }

    public String getFamilyMemberCC() {
        return familyMemberCC;
    }

    public int getAccountID() {
        return accountID;
    }

    public double getTransferedValue() {return transferedValue; }

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
