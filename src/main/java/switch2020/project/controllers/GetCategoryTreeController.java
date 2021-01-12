package switch2020.project.controllers;

import switch2020.project.model.Application;
import switch2020.project.services.CategoryService;
import switch2020.project.services.FamilyService;
import switch2020.project.utils.CategoryTreeDTO;

public class GetCategoryTreeController {

    private Application ffmApp;

    public GetCategoryTreeController(Application app) {
        this.ffmApp = app;
    }

    public boolean getCategoryTree(int familyID, String adminCCNumber) {
        FamilyService familyService = this.ffmApp.getFamilyService();
        CategoryService categoryService = this.ffmApp.getCategoryService();
        try {
            if (familyService.verifyAdministratorPermission(familyID, adminCCNumber)) {
                CategoryTreeDTO categoryTree = categoryService.getCategoryTree(familyID, familyService);
                categoryTree.printTree();
                return true;
            } else {
                return false;
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }


}


