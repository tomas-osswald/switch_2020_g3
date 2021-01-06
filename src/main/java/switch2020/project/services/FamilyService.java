package switch2020.project.services;

import switch2020.project.model.EmailAddress;
import switch2020.project.model.Family;
import switch2020.project.model.FamilyMember;

import java.util.ArrayList;

public class FamilyService {

    private ArrayList<Family> families = new ArrayList();

    public FamilyService() {

    }

    public FamilyService(Family family) {
        this.families.add(family);
    }

    public void addFamily(Family family) {
        this.families.add(family);
    }

    /**
     * Method to add an EmailAddress object with the passed email address string to the FamilyMember with the passed ID
     *
     * @param emailToAdd     String of the email address to add
     * @param familyID       Integer representing the family's ID
     * @param familyMemberID Integer representing the family member's ID
     * @return True if email successfully added to the Family Member with the passed ID
     */
    public boolean addEmail(String emailToAdd, int familyID, int familyMemberID) {
        if (!checkIfEmailPresent(emailToAdd)) {
            Family targetFamily = this.families.get(findFamilyIndexByID(familyID));
            return targetFamily.addEmail(emailToAdd,familyMemberID);
        }
        throw new IllegalArgumentException("This email is already present");
    }

    /**
     * Method to find the index of a family with a specific ID in the Families ArrayList
     *
     * @param familyID Integer representing the ID to find
     * @return Int corresponding to the index of the family  that has the passed ID
     * @throws IllegalArgumentException if there is no family with the passed ID
     */
    private int findFamilyIndexByID(int familyID) {
        int index = 0;
        for (Family family : this.families) {
            if (family.getFamilyID() == familyID) {
                return index;
            }
            index++;
        }
        throw new IllegalArgumentException("No family with that ID was found");
    }


    /**
     * Method to check if a given email address is already present in the ArrayList of EmailAddress objects
     *
     * @param emailToCheck String representing the email address to check if present
     * @return True if the passed email address is already present
     */
    private boolean checkIfEmailPresent(String emailToCheck) {
        ArrayList<FamilyMember> allFamilyMembers = new ArrayList();
        ArrayList<EmailAddress> allEmails = new ArrayList();
        for (Family family : this.families) {
            allFamilyMembers.addAll(family.getMembers());

        }
        for (FamilyMember familyMember : allFamilyMembers) {
            allEmails.addAll(familyMember.getEmails());
        }

        for (EmailAddress email : allEmails) {
            if (email.getEmail().equalsIgnoreCase(emailToCheck)) {
                return true;
            }
        }
        return false;

    }

}
