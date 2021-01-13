package switch2020.project.controllers;

import switch2020.project.model.Application;
import switch2020.project.services.CategoryService;

import java.util.List;


public class GetStandardCategoriesTreeController {
    private Application App;


    public GetStandardCategoriesTreeController(Application app) {
        this.App = app;
    }

    public boolean getStandardCategoriesTree() {
        CategoryService categoryService = this.App.getCategoryService();
        try {
            List standardCategory = categoryService.createStdTree(categoryService.getStandardCategories());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
