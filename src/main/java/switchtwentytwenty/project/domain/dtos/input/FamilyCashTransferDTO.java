package switchtwentytwenty.project.domain.dtos.input;

import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.Date;

public class FamilyCashTransferDTO {

    private final int familyID;
    private final String familyMemberCC;
    private final int accountID;
    private final double transferAmount;
    private final CurrencyEnum currency;
    private final int categoryID;
    private final String transactionDesignation;
    private Date transactionDate;

    public FamilyCashTransferDTO(int familyID, String familyMemberCC, int accountID, double transferAmount, CurrencyEnum currency, int categoryID, String transactionDesignation, Date transactionDate) {
        this.familyID = familyID;
        this.familyMemberCC = familyMemberCC;
        this.accountID = accountID;
        this.transferAmount = transferAmount;
        this.currency = currency;
        this.categoryID = categoryID;
        this.transactionDesignation = transactionDesignation;
        if (transactionDate ==null) {
            this.transactionDate = new Date();
        } else {
            this.transactionDate = (Date) transactionDate.clone();
        }
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

    public double getTransferAmount() {
        return transferAmount;
    }

    public CurrencyEnum getCurrency(){
        return currency;
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
