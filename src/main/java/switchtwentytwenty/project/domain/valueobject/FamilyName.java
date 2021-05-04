package switchtwentytwenty.project.domain.valueobject;

import java.util.Objects;

public class FamilyName implements ValueObject {

    private final String familyName;

    public FamilyName(String familyName) {
        validateName(familyName);
        this.familyName = familyName.trim();
    }

    /**
     * Method to verify if an input name is valid, verifies that it is not null, empty or blank
     */
    private void validateName(String familyName) {
        checkNull(familyName);
        checkEmpty(familyName);
        checkBlank(familyName);
    }

    /**
     * Method to verify if the family name is null, throws and exception if the name is null
     *
     * @param familyName
     */
    private void checkNull(String familyName) {
        if (familyName == null) {
            throw new IllegalArgumentException("Name is Null");
        }
    }

    /**
     * Method to verify if the family name is empty, throws and exception if the name is empty
     *
     * @param familyName
     */
    private void checkEmpty(String familyName) {
        if (familyName.isEmpty()) {
            throw new IllegalArgumentException("Name is Empty");
        }
    }

    /**
     * Method to verify if the family name is blank, throws and exception if the name is blank
     *
     * @param familyName
     */
    private void checkBlank(String familyName) {
        if (familyName.trim().length() == 0) {
            throw new IllegalArgumentException("Name is Blank");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FamilyName)) return false;
        FamilyName that = (FamilyName) o;
        return familyName.equals(that.familyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(familyName);
    }

    @Override
    public String toString() {
        return this.familyName;
    }
}