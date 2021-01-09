package switch2020.project.controllers;

import switch2020.project.model.Application;
import switch2020.project.model.Category;
import switch2020.project.services.CategoryService;
import switch2020.project.utils.StandardCategoryDTO;

import java.util.List;

public class GetStandardCategoriesTreeController {
    private Application app;


    public GetStandardCategoriesTreeController(Application app) {
        this.app = app;
    }

    public List<StandardCategoryDTO> getStandardCategories(){
        CategoryService categoryService = this.app.getCategoryService();
        return categoryService.
    }
}
