package switch2020.project.controllers;

import switch2020.project.model.Application;
import switch2020.project.model.CategoryTree;
import switch2020.project.services.CategoryService;
import switch2020.project.services.FamilyService;

public class GetCategoryTreeController {

    private Application ffmApp;

    public GetCategoryTreeController(Application app) {
        this.ffmApp = app;
    }

    public boolean getCategoryTree(int familyID) {
        FamilyService familyService = this.ffmApp.getFamilyService();
        CategoryService categoryService = this.ffmApp.getCategoryService();
        CategoryTree categoryTree = categoryService.getCategoryTree(familyID, familyService);
        categoryTree.printTree();
        return true;
    }

}
