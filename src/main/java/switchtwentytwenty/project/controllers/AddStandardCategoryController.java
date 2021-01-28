package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.services.CategoryService;

public class AddStandardCategoryController {

    private final Application ffmApplication;

    public  AddStandardCategoryController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    public boolean addStandardCategory(String categoryName, int parentID) { //int parentID used as parameter, zero if base category
        CategoryService categoryService = this.ffmApplication.getCategoryService();
        return categoryService.addStandardCategory(categoryName, parentID);
    }

}