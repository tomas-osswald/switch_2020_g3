package switch2020.project.model;


public class FamilyMember {
    private int familyMemberID;
    private Relation relation;
    private boolean administrator;

    protected FamilyMember(int familyMemberID) {
        this.familyMemberID = familyMemberID;
    }

    protected void makeAdmin() {
        this.administrator = true;
    }

    protected boolean isAdmin() {
        return this.administrator;
    }

    protected int getFamilyMemberID() {
        return this.familyMemberID;
    }

    protected void addRelation(Relation relation) {
        if (this.relation != null)
            throw new IllegalArgumentException("This family member already has an assigned relationship");

        this.relation = relation;
    }
}
