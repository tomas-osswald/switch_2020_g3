package switchtwentytwenty.project.shared;

import switchtwentytwenty.project.ID;

import java.util.Objects;


public class FamilyID implements ID {

    private final int familyID; //Passar para UUID

    public FamilyID(int familyID){
        this.familyID=familyID;
        validateID();
    }

    private void validateID(){
        if(!isIDValid()){
            throw new IllegalArgumentException("Invalid ID");
        }
    }

    private boolean isIDValid(){ //Passar para UUID //quebrar se o ID for nulo?
        return this.familyID>0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FamilyID)) return false;
        FamilyID familyID1 = (FamilyID) o;
        return familyID == familyID1.familyID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(familyID);
    }

}