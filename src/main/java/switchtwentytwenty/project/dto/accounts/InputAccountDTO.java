package switchtwentytwenty.project.dto.accounts;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class InputAccountDTO {

    private String ownerID;
    private String movement;
    private String designation;
    private String accountType;



    public InputAccountDTO(String ownerID, String movement, String designation, String accountType) {
        this.ownerID = ownerID;
        this.movement = movement;
        this.designation = designation;
        this.accountType = accountType;
    }

    public String unpackOwnerID() {
        return this.ownerID;
    }

    public String unpackMovement() {
        return this.movement;
    }

    public String unpackDesignation() {
        return this.designation;
    }

    public String unpackAccountType() {
        return this.accountType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputAccountDTO that = (InputAccountDTO) o;
        return Objects.equals(ownerID, that.ownerID) && Objects.equals(movement, that.movement) && Objects.equals(designation, that.designation) && Objects.equals(accountType, that.accountType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerID, movement, designation, accountType);
    }
}