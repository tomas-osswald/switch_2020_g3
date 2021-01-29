package switchtwentytwenty.project.domain.DTOs.input;

import switchtwentytwenty.project.domain.DTOs.MoneyValue;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

public class AddCreditCardAccountDTO {

    private String familyMemberID;
    private int familyID;
    private String cardDescription;
    private Double withdrwaLimit;
    private Double totalDebt;
    private Double interestDebt;
    private CurrencyEnum currency;

    public AddCreditCardAccountDTO(String familyMemberID, int familyID, String cardDescription, Double withdrwaLimit, Double totalDebt, Double interestDebt, CurrencyEnum currency) {
        this.familyMemberID = familyMemberID;
        this.familyID = familyID;
        this.cardDescription = cardDescription;
        this.withdrwaLimit = withdrwaLimit;
        this.totalDebt = totalDebt;
        this.interestDebt = interestDebt;
        this.currency = currency;
    }

    public String getFamilyMemberID() {
        return familyMemberID;
    }

    public int getFamilyID() {
        return familyID;
    }

    public String getCardDescription() {
        return cardDescription;
    }

    public Double getWithdrwaLimit() {
        return withdrwaLimit;
    }

    public Double getInterestDebt(){return interestDebt;}

    public Double getTotalDebt() {return totalDebt;}

    public CurrencyEnum getCurrency() {return currency;}
}
