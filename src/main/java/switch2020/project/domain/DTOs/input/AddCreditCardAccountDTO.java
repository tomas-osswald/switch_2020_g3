package switch2020.project.domain.DTOs.input;

public class AddCreditCardAccountDTO {

    private String familyMemberID;
    private int familyID;
    private String cardDescription;
    private Double withdrwaLimit;

    public AddCreditCardAccountDTO(String familyMemberID, int familyID, String cardDescription, Double withdrwaLimit) {
        this.familyMemberID = familyMemberID;
        this.familyID = familyID;
        this.cardDescription = cardDescription;
        this.withdrwaLimit = withdrwaLimit;
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
}
