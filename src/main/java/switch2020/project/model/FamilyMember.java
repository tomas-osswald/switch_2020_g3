package switch2020.project.model;


public class FamilyMember {
    private int familyMemberID;
    private Relation relation;
    private boolean isAdministrator;

    public FamilyMember(int familyMemberID) {
        this.familyMemberID = familyMemberID;
    }

    /**
     * Method to make a familyMember Administrator
     */

    public void makeAdmin() {
        this.isAdministrator = true;
    }

    /**
     * Method to verify if a given Family Member is Administrator
     *
     * @return boolean
     */

    protected boolean isAdmin() {
        return this.isAdministrator;
    }

    /**
     * Method to get a FamilyMember his ID
     *
     * @return Family Member ID
     */

    protected int getFamilyMemberID() {
        return this.familyMemberID;
    }

    /**
     * Method to add a Relation to Family Member
     *
     * @param relation Relation to add
     */

    protected void addRelation(Relation relation) {
        if (this.relation != null)
            throw new IllegalArgumentException("This family member already has an assigned relationship");

        this.relation = relation;
    }
}
