package switchtwentytwenty.project.dto.accounts;

import switchtwentytwenty.project.domain.valueobject.AccountType;
import switchtwentytwenty.project.domain.valueobject.Designation;
import switchtwentytwenty.project.domain.valueobject.Movement;
import switchtwentytwenty.project.domain.valueobject.OwnerID;

import java.util.Objects;

public class InputAccountDTO {

    private OwnerID ownerID;
    private Movement movement;
    private Designation designation;
    private AccountType accountType;



    public InputAccountDTO(OwnerID ownerID, Movement movement, Designation designation, AccountType accountType) {
        this.ownerID = ownerID;
        this.movement = movement;
        this.designation = designation;
        this.accountType = accountType;
    }

    public OwnerID unpackOwnerID() {
        return this.ownerID;
    }

    public Movement unpackMovement() {
        return this.movement;
    }

    public Designation unpackDesignation() {
        return this.designation;
    }

    public AccountType unpackAccountType() {
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