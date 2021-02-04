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

    /**
     * Returns the balance
     * @return balance
     */
    public Double getBalance() {return balance;}

    /**
     * Returns the interest rate
     * @return interest rate
     */
    public Double getInterestRate() {return interestRate;}

    /**
     * Returns the description
     * @return description
     */
    public String getDescription(){return description;}

    /**
     * Returns the familyMemberID
     * @return familyMemberID
     */
    public String getFamilyMemberID(){return familyMemberID;}

    /**
     * Returns the familyID
     * @return familyID
     */
    public int getFamilyID(){return familyID;}

    /**
     * Returns the currency
     * @return currency
     */
    public CurrencyEnum getCurrency(){
        return this.currency;
    }
}
