package switchtwentytwenty.project.domain.dtos.output;

import java.util.Objects;

public class AccountIDAndDescriptionDTO {

    private final int accountID;
    private final String description;

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

    @Override
    public int hashCode() {
        return Objects.hash(accountID, description);
    }
}
