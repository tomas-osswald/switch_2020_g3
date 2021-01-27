package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.services.CategoryService;
import switchtwentytwenty.project.domain.DTOs.output.CategoryTreeDTO;

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
