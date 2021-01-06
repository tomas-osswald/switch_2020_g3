package switch2020.project.model;



public class Application {

    private CategoryService categoryService;
    private FamilyService familyService;

    public Application() {
        this.categoryService = new CategoryService();
        this.familyService = new FamilyService();
    }

    public CategoryService getCategoryService() {
        return this.categoryService;
    }

    public FamilyService getFamilyService() {
        return this.familyService;
    }


}
