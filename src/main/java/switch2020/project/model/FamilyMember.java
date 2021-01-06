package switch2020.project.model;


import java.util.ArrayList;

public class FamilyMember {
    private int familyMemberID;
    private Relation relation;
    private boolean isAdministrator;
    private ArrayList<EmailAddress> emails = new ArrayList<>();

    public ArrayList<EmailAddress> getEmails() {
        return emails;
    }

    /**
     * @return Int representing the FamilyMember's ID.
     */
    public int getID() {
        return this.familyMemberID;
    }

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
     * Method to create an EmailAddress object and add it to the ArrayList of EmailAddress objects
     *
     * @param emailToAdd String of the email address to add
     * @return True if the EmailAddress object is successfully created and added to the EmailAddress ArrayList
     */
    public boolean addEmail(String emailToAdd) {
        EmailAddress newEmail = new EmailAddress(emailToAdd);
        emails.add(newEmail);
        return true;
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



