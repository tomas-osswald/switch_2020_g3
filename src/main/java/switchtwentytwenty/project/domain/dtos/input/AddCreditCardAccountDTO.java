package switchtwentytwenty.project.domain.dtos.input;

import switchtwentytwenty.project.domain.utils.CurrencyEnum;

public class AddCreditCardAccountDTO {

    private final String familyMemberID;
    private final int familyID;
    private final String cardDescription;
    private final Double withdrwaLimit;
    private final Double totalDebt;
    private final Double interestDebt;
    private final CurrencyEnum currency;

    public AddCreditCardAccountDTO(String familyMemberID, int familyID, String cardDescription, Double withdrawalLimit, Double totalDebt, Double interestDebt, CurrencyEnum currency) {
        this.familyMemberID = familyMemberID;
        this.familyID = familyID;
        this.cardDescription = cardDescription;
        this.withdrwaLimit = withdrawalLimit;
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

    public Double getWithdrawalLimit() {
        return withdrwaLimit;
    }

    public Double getInterestDebt() {
        return interestDebt;
    }

    public Double getTotalDebt() {
        return totalDebt;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }
}
