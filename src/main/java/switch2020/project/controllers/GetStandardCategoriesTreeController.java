package switch2020.project.controllers;

import switch2020.project.domain.model.Application;
import switch2020.project.domain.services.CategoryService;
import switch2020.project.domain.utils.CategoryTreeDTO;

public class GetStandardCategoriesTreeController {
    private Application app;


    public GetStandardCategoriesTreeController(Application app) {
        this.app = app;
    }

    public boolean getStandardCategoriesTree() {
        CategoryService categoryService = this.app.getCategoryService();
        try {
            CategoryTreeDTO standardCategoryTree = categoryService.getStandardCategoryTree();
            return true;


        } catch (Exception exception) {

            return false;
        }
    }
}
