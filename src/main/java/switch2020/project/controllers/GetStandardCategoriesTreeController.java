package switch2020.project.controllers;

import switch2020.project.domain.model.Application;
import switch2020.project.domain.services.CategoryService;
import switch2020.project.domain.DTOs.output.CategoryTreeDTO;

public class GetStandardCategoriesTreeController {
    private Application ffmApplication;


    public GetStandardCategoriesTreeController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    public boolean getStandardCategoriesTree() {
        CategoryService categoryService = this.ffmApplication.getCategoryService();
        try {
            CategoryTreeDTO standardCategoryTree = categoryService.getStandardCategoryTree();
            return true;


        } catch (Exception exception) {

            return false;
        }
    }
}
