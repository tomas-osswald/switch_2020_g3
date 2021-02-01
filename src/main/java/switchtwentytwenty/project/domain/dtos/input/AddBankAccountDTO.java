package switchtwentytwenty.project.domain.dtos.input;

public class AddBankAccountDTO {

    private Double balance;
    private String description;
    private String familyMemberID;
    private int familyID;

    public AddBankAccountDTO (Double balance, String description, String familyMemberID, int familyID){
        this.balance = balance;
        this.description = description;
        this.familyMemberID = familyMemberID;
        this.familyID = familyID;
    }

    public Double getBalance() {return balance;}

    public String getDescription(){return description;}

    public String getFamilyMemberID(){return familyMemberID;}

    public int getFamilyID(){return familyID;}
}
