package switchtwentytwenty.project.domain.DTOs.output;

public class AccountIDAndDescriptionDTO {

    private int accountID;
    private String description;

    public AccountIDAndDescriptionDTO(int accountID, String description){
        this.accountID = accountID;
        this.description = description;
    }
}
