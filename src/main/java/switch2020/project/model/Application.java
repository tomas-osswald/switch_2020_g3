package switch2020.project.model;


import java.util.ArrayList;

public class Application {

    private ArrayList<Family> families = new ArrayList();
    private ArrayList<Category> categories = new ArrayList();

    public Application() {

    }

    public Application(Family family) {
        this.families.add(family);
    }

    /**
     * Method to add an EmailAddress object with the passed email address string to the FamilyMember with the passed ID
     * @param emailToAdd String of the email address to add
     * @param familyMemberID Integer representing the family member's ID
     * @return True if email successfully added to the Family Member with the passed ID
     */
    public boolean addEmail(String emailToAdd, int familyMemberID) {
        return this.families.get(0).addEmail(emailToAdd, familyMemberID);
    }


}
