package switch2020.project.model;


import java.util.ArrayList;

public class Family {
    private int familyID;
    private ArrayList<FamilyMember> familyMembers = new ArrayList<>();
    private ArrayList<Relation> relations = new ArrayList<>();

    protected Family(int familyID) {
        this.familyID = familyID;
    }

    protected int getFamilyID() {
        return familyID;
    }

    protected boolean isAdmin(int familyMemberID) {
        for (FamilyMember familyMember : familyMembers) {
            if (familyMember.getFamilyMemberID() == familyMemberID)
                return familyMember.isAdmin();
        }
        return false;
    }

    protected boolean hasDesignation(String relationDesignation) {
        for (Relation relation : relations) {
            if (relation.getRelationDesignation().toLowerCase().equals(relationDesignation.toLowerCase()))
                return true;
        }
        return false;
    }

    protected boolean addToRelationList(Relation relation) {
        return relations.add(relation);
    }

    protected boolean addRelationToFamilyMember(int familyMemberID, Relation relation) {
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

    protected void addFamilyMember(FamilyMember familyMember) {
        this.familyMembers.add(familyMember);
    }

    protected void addFamilyMemberArray(ArrayList<FamilyMember> familyMembers) {
        this.familyMembers.addAll(familyMembers);
    }

    protected int numberOfFamilyMembers() {
        return this.familyMembers.size();
    }

    protected int numberOfRelationDesignations() {
        return this.relations.size();
    }
}
