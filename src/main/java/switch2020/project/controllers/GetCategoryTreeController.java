package switch2020.project.controllers;

import switch2020.project.domain.model.Application;
import switch2020.project.domain.services.CategoryService;
import switch2020.project.domain.services.FamilyService;
import switch2020.project.domain.utils.CategoryTreeDTO;

public class GetCategoryTreeController {

    private Application ffmApplication;

    public GetCategoryTreeController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    /**
     * Controller method to retrieve a family's category tree
     * @param familyID id of the family of which to get the Custom Categories
     * @param adminCCNumber CC number of the admin, to check permission for this operation
     * @return True if successfully retrieved the CategoryTreeDTO object
     */
    public boolean getCategoryTree(int familyID, String adminCCNumber) {
        FamilyService familyService = this.ffmApplication.getFamilyService();
        CategoryService categoryService = this.ffmApplication.getCategoryService();
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

   /* public boolean getCategoryTree(int familyID, String adminCCNumber) {
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
    }*/


}


