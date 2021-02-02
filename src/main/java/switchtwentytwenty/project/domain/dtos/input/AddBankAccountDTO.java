package switchtwentytwenty.project.domain.dtos.input;

import switchtwentytwenty.project.domain.utils.CurrencyEnum;

public class AddBankAccountDTO {

    private final Double balance;
    private final String description;
    private final String familyMemberID;
    private final int familyID;
    private final CurrencyEnum currency;

    public AddBankAccountDTO (Double balance, String description, String familyMemberID, int familyID, CurrencyEnum currency){
        this.balance = balance;
        this.description = description;
        this.familyMemberID = familyMemberID;
        this.familyID = familyID;
        this.currency = currency;
    }

    public Double getBalance() {return balance;}

    public String getDescription(){return description;}

    public String getFamilyMemberID(){return familyMemberID;}

    public int getFamilyID(){return familyID;}

    public CurrencyEnum getCurrency(){
        return this.currency;
    }
}
