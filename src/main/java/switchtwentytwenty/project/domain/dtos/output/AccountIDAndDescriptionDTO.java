package switchtwentytwenty.project.domain.dtos.output;

public class AccountIDAndDescriptionDTO {

    final private int accountID;
    final private String description;

    public AccountIDAndDescriptionDTO(int accountID, String description){
        this.accountID = accountID;
        this.description = description;
    }

    public boolean equals(Object o){
        if(this == o) return true;

        if(!(o instanceof AccountIDAndDescriptionDTO)) return false;

        AccountIDAndDescriptionDTO otherDTO = (AccountIDAndDescriptionDTO) o;

        return this.accountID == otherDTO.accountID && this.description.equals(otherDTO.description);
    }
}
