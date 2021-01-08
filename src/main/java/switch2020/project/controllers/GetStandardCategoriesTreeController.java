package switch2020.project.controllers;

import switch2020.project.model.Application;
import switch2020.project.model.Category;

import java.util.List;

public class GetStandardCategoriesTreeController {
    private Application app;


    public GetStandardCategoriesTreeController(Application app) {
        this.app = app;
    }

    public List<Category> getStandardCategories(){
        return this.app.getCategoryService().getStandardCategories();
    }
}
