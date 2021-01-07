package switch2020.project.model;

import switch2020.project.services.CategoryService;
import switch2020.project.services.FamilyService;

import java.util.ArrayList;
import java.util.List;

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
    public CategoryService getCategoryService() {
        return this.categoryService;
    }


    /********************** GETTERS AND SETTERS **********************/

    public FamilyService getFamilyService() {
        return this.familyService;
    }


}
