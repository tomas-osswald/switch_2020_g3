package java.switch2020.project.model;


public class FamilyMember {
    private int familyMemberID;
    private Relation relation;
    private boolean administrator;

    public FamilyMember() {

    }

    public boolean isAdmin() {
        return this.administrator;
    }

    public int getFamilyMemberID() {
        return this.familyMemberID;
    }

    public void addRelation(Relation relation) {
        this.relation = relation;
    }
}
