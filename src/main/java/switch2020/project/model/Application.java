package switch2020.project.model;

import switch2020.project.services.CategoryService;
import switch2020.project.services.FamilyService;

import java.util.ArrayList;

public class Application {

    private ArrayList<Category> categories = new ArrayList<>();

    private CategoryService categoryService = new CategoryService();
    private FamilyService familyService = new FamilyService();

    public Application() {
    }

    public Application(Family family) {
        this.familyService.addFamily(family);
    }

    public CategoryService getCategoryService() {
        return this.categoryService;
    }

    public FamilyService getFamilyService() {
        return this.familyService;
    }


}
