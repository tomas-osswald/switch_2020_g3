package switch2020.project.model;


import java.util.ArrayList;

public class Family {

    private int ID;
    private ArrayList<FamilyMember> members;

    public Family() {

    }

    public Family (int familyID, ArrayList<FamilyMember> members){
        if(members == null) {
            throw new IllegalArgumentException("Family can't be null");
        }
        if(familyID < 0) {
            throw new IllegalArgumentException("ID can't be a negative number");
        }
        this.ID = familyID;
        this.members = members;
    }

    public void addFamilyMember(int familyMemberId){
    }

    public ArrayList<FamilyMember> getMembers(){
        return members;
    }

    public int getID() {
        return this.ID;
    }

}
