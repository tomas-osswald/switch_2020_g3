package switchtwentytwenty.project.domain.valueobject;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class FamilyID implements OwnerID<String>, Serializable {
    @Getter
    @Setter
    private String familyID;

    public FamilyID(String familyID) {
        validateID(familyID);
        if (isAtPresent(familyID)) {
            this.familyID = familyID.trim();
        } else {
            this.familyID = "@" + familyID.trim();
        }


    }

    private boolean isAtPresent(String familyID) {
        String firstCharacter = String.valueOf(familyID.trim().charAt(0));
        return "@".equals(firstCharacter);
    }


    @Override
    public String toString() {

        return this.familyID;
    }

    public FamilyID clone() {
        FamilyID clone = new FamilyID(this.familyID);
        return clone;
    }

    /**
     * Method that validates a familyID, throws an exception if the ID isn't valid
     *
     * @param familyID
     */
    private void validateID(String familyID) {
        if (!isIDValid(familyID)) {
            throw new IllegalArgumentException("Invalid ID");
        }
    }

    /**
     * Method to determine if an ID is valid, i.e. not null
     *
     * @param familyID
     * @return boolean, true if ID is valid, false otherwise
     */
    private boolean isIDValid(String familyID) {
        return familyID != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FamilyID)) return false;
        FamilyID familyID1 = (FamilyID) o;
        return familyID.equals(familyID1.familyID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(familyID);
    }

}