package switch2020.project.model;

import switch2020.project.services.CategoryService;
import switch2020.project.services.FamilyService;

public class Application {

    private CategoryService categoryService = new CategoryService();
    private FamilyService familyService = new FamilyService();

    public Application(){

    }

    public Application(Family family) {
        this.familyService.addFamily(family);
    }

    public CategoryService getCategoryService() {
        return this.categoryService;
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
        return this.familyService.addEmail(emailToAdd, familyID, familyMemberID);
    }
}
