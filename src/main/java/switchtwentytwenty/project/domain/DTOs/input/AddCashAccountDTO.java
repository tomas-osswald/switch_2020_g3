package switchtwentytwenty.project.domain.DTOs.input;

public class AddCashAccountDTO {
    private Double balance = 0.00;
    private String description;
    private String familyMemberID;
    private int familyID;

    public AddCashAccountDTO(Double balance, String description,String familyMemberID,int familyID) {
        this.balance = balance;
        this.description = description;
        this.familyMemberID = familyMemberID;
        this.familyID = familyID;
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

}
