package switchtwentytwenty.project.domain.dtos.input;

import switchtwentytwenty.project.domain.utils.CurrencyEnum;

public class AddBankSavingsAccountDTO {

    private final Double balance;
    private final Double interestRate;
    private final String description;
    private final String familyMemberID;
    private final int familyID;
    private final CurrencyEnum currency;

    public AddBankSavingsAccountDTO (Double balance, Double interestRate, String description, String familyMemberID, int familyID, CurrencyEnum currency){
        this.balance = balance;
        this.interestRate = interestRate;
        this.description = description;
        this.familyMemberID = familyMemberID;
        this.familyID = familyID;
        this.currency = currency;
    }

    public Double getBalance() {return balance;}

    public Double getInterestRate() {return interestRate;}

    public String getDescription(){return description;}

    public String getFamilyMemberID(){return familyMemberID;}

    public int getFamilyID(){return familyID;}

    public CurrencyEnum getCurrency(){
        return this.currency;
    }
}
