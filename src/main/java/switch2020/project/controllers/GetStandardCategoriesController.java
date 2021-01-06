package switch2020.project.controllers;

import switch2020.project.model.Application;
import switch2020.project.model.CategoryService;

public class GetStandardCategoriesController {
    private Application app;

    public GetStandardCategoriesController(Application app) {
        if (app == null) {
            throw new NullPointerException("App not found");
        }
        this.app = app;
    }

    /*public GetStandardCategories(CategoryService categoryService){


    }*/
}
