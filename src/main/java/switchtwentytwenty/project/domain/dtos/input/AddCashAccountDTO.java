package switchtwentytwenty.project.domain.dtos.input;

import switchtwentytwenty.project.domain.utils.CurrencyEnum;

public class AddCashAccountDTO {
    private Double balance = 0.00;
    private String description;
    private String familyMemberID;
    private int familyID;
    private final CurrencyEnum currency;

    /**
     * Data Transfer Object to input the necessary data for a new cash account
     * @param balance Initial balance of the cash account
     * @param description Name of the cash account
     * @param familyMemberID ID of the family member to add the account to
     * @param familyID ID of the family of the target member
     * @param currency Currency type of the account
     */
    public AddCashAccountDTO(Double balance, String description,String familyMemberID,int familyID,CurrencyEnum currency) {
        this.balance = balance;
        this.description = description;
        this.familyMemberID = familyMemberID;
        this.familyID = familyID;
        this.currency = currency;
    }

    public String getFamilyMemberID() {
        return familyMemberID;
    }

    public int getFamilyID() {
        return familyID;
    }

    public Double getBalance() {
        return balance;
    }

    public String getDescription() {
        return description;
    }

    public CurrencyEnum getCurrency(){
        return this.currency;
    }

}
