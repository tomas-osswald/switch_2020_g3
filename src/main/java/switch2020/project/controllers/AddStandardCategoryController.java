package switch2020.project.controllers;

import switch2020.project.model.Application;
import switch2020.project.services.CategoryService;

public class AddStandardCategoryController {

    private Application FFMapp;

    public  AddStandardCategoryController(Application app) {
        this.FFMapp = app;
    }

    public boolean addStandardCategory(String categoryName) {
        CategoryService categoryService = this.FFMapp.getCategoryService();
        return categoryService.addStandardCategory(categoryName);
    }

}