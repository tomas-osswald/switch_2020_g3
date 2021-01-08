package switch2020.project.controllers;

import switch2020.project.model.Application;
import switch2020.project.model.Category;
import switch2020.project.model.CategoryTree;
import switch2020.project.services.CategoryService;
import switch2020.project.services.FamilyService;

import java.util.List;

public class GetCategoryTreeController {

    private Application ffmApp;

    public GetCategoryTreeController(Application app) {
        this.ffmApp = app;
    }

    public CategoryTree getCategoryTree(int familyID){
        FamilyService familyService = this.ffmApp.getFamilyService();
        CategoryService categoryService = this.ffmApp.getCategoryService();
        CategoryTree categoryTree = new CategoryTree(categoryService);
        List<Category> customCategories = familyService.getCustomCategories(familyID);
        categoryTree.addCustomCategories(customCategories);
        return categoryTree;
    }

}
