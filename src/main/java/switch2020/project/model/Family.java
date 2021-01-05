package switch2020.project.model;


import java.util.ArrayList;

public class Family {
    private int familyID;
    private ArrayList<FamilyMember> familyMembers = new ArrayList<>();
    private ArrayList<String> relationDesignations = new ArrayList<>();

    protected Family(int familyID) {
        this.familyID = familyID;
    }

    /**
     * Method to return family ID
     * @return family ID
     */

    protected int getFamilyID() {
        return familyID;
    }

    /**
     * Method to verify if a given Family Member is Administrator
     *
     * @param familyMemberID Family Member ID to verify
     * @return boolean
     */

    protected boolean isAdmin(int familyMemberID) {
        for (FamilyMember familyMember : familyMembers) {
            if (familyMember.getFamilyMemberID() == familyMemberID)
                return familyMember.isAdmin();
        }
        return false;
    }

    /**
     * Method to verify if a given relation designation has been already added to a list os given relation designations
     *
     * @param relationDesignation String with the designation of the relation
     * @return boolean
     */

    protected boolean hasDesignation(String relationDesignation) {
        for (String relationDesigantion : relationDesignations) {
            if (relationDesigantion.toLowerCase().equals(relationDesignation.toLowerCase()))
                return true;
        }
        return false;
    }

    /**
     * Method to add a relation designation to list of relation designations
     *
     * @param relation String relation designation
     * @return boolean
     */

    protected boolean addToRelationDesignationList(String relation) {
        return relationDesignations.add(relation);
    }

    /**
     * Method to add a Relation to A family Member
     *
     * @param familyMemberID FamilyMemberID of the member to be added a Relation
     * @param relation Relation to be added
     * @return boolean
     */

    protected boolean addRelationToFamilyMember(int familyMemberID, Relation relation) {
        FamilyMember familyMember = getFamilyMember(familyMemberID);

        familyMember.addRelation(relation);

        return true;
    }

    /**
     * Method to get a Famaly Member by ID
     *
     * @param familyMemberID FamilyMemberID to search
     * @return FamilyMember with given ID
     */

    private FamilyMember getFamilyMember(int familyMemberID) {
        for (FamilyMember familyMember : familyMembers) {
            if (familyMember.getFamilyMemberID() == familyMemberID)
                return familyMember;
        }
        // If given ID is not present, a expection is throw
        throw new IllegalArgumentException("No family member with such ID");
    }

    /**
     * Method to add a Family Member to list of FamilyMembers
     *
     * @param familyMember FamilyMember to add to list
     */

    protected void addFamilyMember(FamilyMember familyMember) {
        this.familyMembers.add(familyMember);
    }

    /**
     * Method to add a Family Member Array to list of FamilyMembers
     *
     * @param familyMembers FamilyMember arry to add to list
     */

    protected void addFamilyMemberArray(ArrayList<FamilyMember> familyMembers) {
        this.familyMembers.addAll(familyMembers);
    }

    /**
     * Method return the number of Family Members in List -> familyMembers
     *
     * @return number of Family Members
     */

    protected int numberOfFamilyMembers() {
        return this.familyMembers.size();
    }

    /**
     * Method return the number of Family Members in List -> relationsDesignations
     *
     * @return number of relation designations
     */

    protected int numberOfRelationDesignations() {
        return this.relationDesignations.size();
    }
}
