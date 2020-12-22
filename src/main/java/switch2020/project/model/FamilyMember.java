package switch2020.project.model;


import java.util.ArrayList;

public class FamilyMember {

    private int familyMemberID;
    private ArrayList<EmailAddress> emails = new ArrayList();

    public FamilyMember(int iD) {
        this.familyMemberID = iD;
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
        if (!isEmailAlreadyPresent(emailToAdd)) {
            EmailAddress newEmail = new EmailAddress(emailToAdd);
            emails.add(newEmail);
            return true;
        }
        return false;
    }

    /**
     * Method to check if a given email address is already present in the ArrayList of EmailAddress objects
     *
     * @param emailToCheck String representing the email address to check if present
     * @return True if the passed email address is already present
     */
    private boolean isEmailAlreadyPresent(String emailToCheck) {
        for (EmailAddress email : emails) {
            if (email.getEmail().equalsIgnoreCase(emailToCheck)) {
                return true;
            }
        }
        return false;
    }
}
