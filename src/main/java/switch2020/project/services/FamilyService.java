package switch2020.project.services;

import switch2020.project.model.EmailAddress;
import switch2020.project.model.FamilyMember;
import switch2020.project.model.Relation;
import java.util.ArrayList;

public class FamilyService {

    // Attributes
    private ArrayList<Family> families = new ArrayList();

    // Constructors
    public FamilyService() {
    }

    public FamilyService(Family family) {
        this.families.add(family);
    }

    // Business Methods
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

    /**
     * Method to add a Family to Families List -> families
     *
     * @param family Family to add
     */

    public void addFamily(Family family) {
        this.families.add(family);
    }

    /**
     * Method to create a Relation and assign it to a Family Member
     *
     * @param selfID ID of the Family Member how wants to create a Relation
     * @param otherID ID of the Family Member to be added a Relation
     * @param relationDesignation Relation Designation
     * @param familyID FamilyID of Family Member how wants to create a Relation
     * @return boolean
     */

    public boolean createRelation(int selfID, int otherID, String relationDesignation, int familyID) {
        Relation relation;
        Family fam = getFamily(familyID);

        if (fam.isAdmin(selfID)) { // If is Administrator
            if (fam.hasDesignation(relationDesignation)) { // Verify if a given relation designation is already present in list of relations assigned
                relation = new Relation(relationDesignation);
                fam.addRelationToFamilyMember(otherID, relation); // Create a Relation instance and assign to a Family Member

            } else { // If not, add to list of relations assigned
                relation = new Relation(relationDesignation);
                fam.addToRelationDesignationList(relationDesignation);
                fam.addRelationToFamilyMember(otherID,relation); // Create a Relation instance and assign to a Family Member
            }
            return true; // Return true if is administrator and a Relation has been created and assigned to given Family Member
        }
        return false; // Return false if isn't administrator
    }

    /**
     *  Method to get a family by ID in families
     *
     * @param familyID FamilyID of required family
     * @return Family instance
     */

    public Family getFamily(int familyID) {
        for (Family family : families) {
            if (family.getFamilyID() == familyID)
                return family;
        }
        throw new IllegalArgumentException("No family with such ID");
    }
}
