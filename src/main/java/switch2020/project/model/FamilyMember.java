package switch2020.project.model;


import java.util.ArrayList;

public class FamilyMember {

    private int familyMemberID;
    private ArrayList<EmailAddress> emails = new ArrayList();

    public FamilyMember(int iD) {
        this.familyMemberID = iD;
    }

    public int getID() {
        return this.familyMemberID;
    }

    public boolean addEmail(String emailToAdd) {
        if (!isEmailAlreadyPresent(emailToAdd)) {
            EmailAddress newEmail = new EmailAddress(emailToAdd);
            emails.add(newEmail);
            return true;
        }
        return false;
    }

    private boolean isEmailAlreadyPresent(String emailToCheck) {
        for (EmailAddress email : emails) {
            if (email.getEmail().equalsIgnoreCase(emailToCheck)) {
                return true;
            }
        }
        return false;
    }
}
