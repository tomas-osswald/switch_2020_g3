package java.switch2020.project.model;


import java.util.ArrayList;
import java.util.List;

public class Family {
    private int familyID;
    private ArrayList<FamilyMember> familyMembers = new ArrayList<FamilyMember>();
    private ArrayList<Relation> relations = new ArrayList<Relation>();

    public Family(int familyID) {
        this.familyID = familyID;
    }

    public int getFamilyID() {
        return familyID;
    }

    public boolean isAdmin(int familyMemberID) {
        for (FamilyMember familyMember : familyMembers) {
            if (familyMember.getFamilyMemberID() == familyMemberID)
                return familyMember.isAdmin();
        }
        return false;
    }

    public boolean hasDesignation(String relationDesignation) {
        for (Relation relation: relations) {
            if (relation.getRelationDesignation().equals(relationDesignation))
                return true;
        }
        return false;
    }

    public boolean addToRelationList(Relation relation){
        return relations.add(relation);
    }

    public boolean addRelationToFamilyMember(int familyMemberID, Relation relation){
        FamilyMember familyMember = getFamilyMember(familyMemberID);

        familyMember.addRelation(relation);

        return true;
    }

    private FamilyMember getFamilyMember(int familyMemberID) {
        for (FamilyMember familyMember : familyMembers) {
            if (familyMember.getFamilyMemberID() == familyMemberID)
                return familyMember;
        }
        throw new IllegalArgumentException("No family member with such ID");
    }
}
