package switch2020.project.controllers;

import switch2020.project.domain.model.Application;
import switch2020.project.domain.services.CategoryService;

public class AddStandardCategoryController {

    private Application ffmApplication;

    public  AddStandardCategoryController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    public boolean addStandardCategory(String categoryName, int parentID) { //int parentID used as parameter, zero if base category
        CategoryService categoryService = this.ffmApplication.getCategoryService();
        return categoryService.addStandardCategory(categoryName, parentID);
    }

}