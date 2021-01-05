package switch2020.project.model;

import java.util.ArrayList;
import java.util.List;

public class Application {
    //attributes
    //private ArrayList<Category> categories = new ArrayList();
    private CategoryService categoryService;


    //constructors
    public Application() {
        this.categoryService = new CategoryService();
    }

    public CategoryService getCategoryService() {
        return this.categoryService;
    }


}
