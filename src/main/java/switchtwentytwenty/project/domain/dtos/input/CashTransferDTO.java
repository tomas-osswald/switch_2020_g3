package switchtwentytwenty.project.domain.dtos.input;

import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.Date;

public class CashTransferDTO {

    private final String originFamilyMemberCC;
    private final String destinationFamilyMemberCC;
    private final int familyID;
    private final int originAccountID;
    private final int destinationAccountID;
    private final double transferAmount;
    private final CurrencyEnum currency;
    private final int categoryID;
    private final String transactionDesignation;
    private final Date transactionDate;


    public CashTransferDTO(int familyID, String originFamilyMemberCC, int originAccountID, String destinationFamilyMemberCC, int destinationAccountID, double transferAmount, CurrencyEnum currency, int categoryID, String transactionDesignation, Date transactionDate) {
        this.familyID = familyID;
        this.originFamilyMemberCC = originFamilyMemberCC;
        this.originAccountID = originAccountID;
        this.destinationFamilyMemberCC = destinationFamilyMemberCC;
        this.destinationAccountID = destinationAccountID;
        this.transferAmount = transferAmount;
        this.currency = currency;
        this.categoryID = categoryID;
        this.transactionDesignation = transactionDesignation;
        if (transactionDate == null) {
            this.transactionDate = new Date();
        } else {
            this.transactionDate = (Date) transactionDate.clone();
        }
    }


    public String getOriginFamilyMemberCC() {
        return originFamilyMemberCC;
    }

    public String getTransactionDesignation() {
        return transactionDesignation;
    }

    public int getOriginAccountID() {
        return originAccountID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public int getFamilyID() {
        return familyID;
    }

    public String getDestinationFamilyMemberCC() {
        return destinationFamilyMemberCC;
    }

    public int getDestinationAccountID() {
        return destinationAccountID;
    }


    public CurrencyEnum getCurrency() {
        return currency;
    }

    public Date getTransactionDate() {
        return (Date) transactionDate.clone();
    }

    public double getTransferAmount() {
        return transferAmount;
    }
}



