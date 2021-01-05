package switch2020.project.controllers;

import switch2020.project.model.CategoryService;

import java.util.ArrayList;
import java.util.List;

public class CategoriesController {
    //attributes
    //private ArrayList<Category> categories = new ArrayList();
    private CategoryService categoryService;


    //constructors
    public CategoriesController() {
        this.categoryService = new CategoryService();
    }

    public CategoryService getCategoryService() {
        return this.categoryService;
    }

}
