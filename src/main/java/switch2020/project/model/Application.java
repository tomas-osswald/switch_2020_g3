package switch2020.project.model;

import switch2020.project.services.CategoryService;
import switch2020.project.services.FamilyService;

import java.util.ArrayList;

public class Application {

    // Attributes
    private ArrayList<Category> categories = new ArrayList<>();

    private CategoryService categoryService = new CategoryService();
    private FamilyService familyService = new FamilyService();


    // Constructors
    public Application() {
    }

    public Application(Family family) {
        this.familyService.addFamily(family);
    }

    // Business methods
    public CategoryService getCategoryService(){
        return this.categoryService;
    }


    /********************** GETTERS AND SETTERS **********************/

    public FamilyService getFamilyService() {
        return this.familyService;
    }


    // BATISTA METHOD
    /*
    public Family getFamily(int familyID) {
        boolean exists = false;
        Family familyToGet = new Family();
        for (Family family : families) {
            if (family.getFamilyID() == familyID) {
                exists = true;
                familyToGet = family;
            }
        }
        if (!exists) {
            throw new IllegalArgumentException("There is no family with such ID");
        }
        return familyToGet;
    }

     */

    /*************************/

}
