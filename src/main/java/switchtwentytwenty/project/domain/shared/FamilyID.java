package switchtwentytwenty.project.domain.shared;

import switchtwentytwenty.project.ID;

public class FamilyID implements ID {

    private final int familyID;

    public FamilyID(int familyID){
        this.familyID=familyID;
        validateID();
    }

    private void validateID(){
        if(!isIDValid()){
            throw new IllegalArgumentException("Invalid ID");
        }
    }

    private boolean isIDValid(){
        return this.familyID>0;
    }

}