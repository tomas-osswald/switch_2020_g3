package switchtwentytwenty.project.shared;

import switchtwentytwenty.project.ValueObject;
import java.util.Objects;

public class FamilyName implements ValueObject {

    private String familyName;

    public FamilyName(String familyName){
        this.familyName = familyName;
        validateName();
    }

    private void validateName(){
        checkNull();
        checkEmpty();
        checkBlank();
    }

    private void checkNull(){
        if (this.familyName==null){
            throw new IllegalArgumentException("Name is Null");
        }
    }

    private void checkEmpty(){
        if (this.familyName.isEmpty()){
            throw new IllegalArgumentException("Name is Empty");
        }
    }

    private void checkBlank(){
        if (this.familyName.trim().length()==0){
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