package switchtwentytwenty.project.shared;

import switchtwentytwenty.project.ValueObject;

import java.util.Objects;

public class FamilyName implements ValueObject<String> {

    private String familyName;

    public FamilyName(String familyName) {
        this.familyName = familyName;
        validateName();
        trimData();
    }

    private void trimData() {
        this.familyName = this.familyName.trim();
    }

    //TODO: verificar trimData e final
    /*
        private String trimData(String familyName) {
        try {
            return familyName.trim();
        }catch(NullPointerException e){
            return null;
        }
    }
     */

    /**
     * Method to verify if an input name is valid, verifies that it is not null, empty or blank
     */
    private void validateName() {
        checkNull();
        checkEmpty();
        checkBlank();
    }

    /**
     * Method to verify if the family name is null, throws and exception if the name is null
     */
    private void checkNull() {
        if (this.familyName == null) {
            throw new IllegalArgumentException("Name is Null");
        }
    }

    /**
     * Method to verify if the family name is empty, throws and exception if the name is empty
     */
    private void checkEmpty() {
        if (this.familyName.isEmpty()) {
            throw new IllegalArgumentException("Name is Empty");
        }
    }

    /**
     * Method to verify if the family name is blank, throws and exception if the name is blank
     */
    private void checkBlank() {
        if (this.familyName.trim().length() == 0) {
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
}