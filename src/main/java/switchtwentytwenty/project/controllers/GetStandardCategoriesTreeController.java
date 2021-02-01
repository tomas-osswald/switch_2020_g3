package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.services.CategoryService;
import switchtwentytwenty.project.domain.dtos.output.CategoryTreeDTO;

public class GetStandardCategoriesTreeController {
    private final Application ffmApplication;


    public GetStandardCategoriesTreeController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    public boolean getStandardCategoriesTree() {
        CategoryService categoryService = this.ffmApplication.getCategoryService();

            CategoryTreeDTO standardCategoryTree = categoryService.getStandardCategoryTree();
            return true;

    }
}
