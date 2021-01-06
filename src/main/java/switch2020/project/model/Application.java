package switch2020.project.model;


import java.util.ArrayList;

public class Application {

    private ArrayList<Family> families = new ArrayList();
    private CategoryService categoryService;

    public Application() {
        this.categoryService = new CategoryService();
    }

    public Application(Family family) {
        this.families.add(family);
    }

    /**
     * Method to add an EmailAddress object with the passed email address string to the FamilyMember with the passed ID
     *
     * @param emailToAdd     String of the email address to add
     * @param familyMemberID Integer representing the family member's ID
     * @return True if email successfully added to the Family Member with the passed ID
     */
    public boolean addEmail(String emailToAdd, int familyMemberID) {
        if (!checkIfEmailPresent(emailToAdd)) {
            return this.families.get(0).addEmail(emailToAdd, familyMemberID);
        }
        throw new IllegalArgumentException("This email is already present");
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
            allFamilyMembers.addAll(family.getFamily());

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






    public CategoryService getCategoryService(){
        return this.categoryService;
    }
    
}
