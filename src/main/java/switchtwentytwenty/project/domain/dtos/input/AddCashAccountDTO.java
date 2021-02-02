package switchtwentytwenty.project.domain.dtos.input;

import switchtwentytwenty.project.domain.utils.CurrencyEnum;

public class AddCashAccountDTO {
    private Double balance = 0.00;
    private String description;
    private String familyMemberID;
    private int familyID;
    private final CurrencyEnum currency;

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
