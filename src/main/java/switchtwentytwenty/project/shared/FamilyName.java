package switchtwentytwenty.project.shared;

import switchtwentytwenty.project.ValueObject;

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

}