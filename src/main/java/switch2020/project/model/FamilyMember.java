package switch2020.project.model;


import java.util.ArrayList;

public class FamilyMember {

    private int familyMemberID;
    private ArrayList<EmailAddress> emails = new ArrayList();

    public FamilyMember(int iD) {
        this.familyMemberID = iD;
    }

    public ArrayList<EmailAddress> getEmails() {
        return emails;
    }

    /**
     * @return Int representing the FamilyMember's ID.
     */
    public int getID() {
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

}



