package switchtwentytwenty.project.domain.shared;

import switchtwentytwenty.project.ID;

public class FamilyID implements ID {

    private final int familyID;

    public FamilyID(int familyID){
        this.familyID=familyID;
        validateID();
    }

    private void validateID(){
        if(this.familyID<=0){
            throw new IllegalArgumentException("Invalid ID");
        }
    }

}