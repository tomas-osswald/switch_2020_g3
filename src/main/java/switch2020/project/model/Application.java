package switch2020.project.model;

import java.util.ArrayList;

import switch2020.project.services.FamilyService;

public class Application {
    //attributes
    //private ArrayList<Category> categories = new ArrayList();
    private CategoryService categoryService;

    private ArrayList<Category> categories = new ArrayList<>();

    private FamilyService familyService;

    //constructors
    public Application() {
        this.categoryService = new CategoryService();
    }

    public CategoryService getCategoryService() {
        return this.categoryService;
    }

    public FamilyService getFamilyService() {
        return this.familyService;
    }
}
