package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.dtos.output.CategoryTreeDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.services.CategoryService;
import switchtwentytwenty.project.domain.services.FamilyService;

public class GetCategoryTreeController {

    private final Application ffmApplication;

    public GetCategoryTreeController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    /**
     * Controller method to retrieve a family's category tree
     *
     * @param familyID      id of the family of which to get the Custom Categories
     * @param adminCCNumber CC number of the admin, to check permission for this operation
     * @return True if successfully retrieved the CategoryTreeDTO object
     */
    public boolean getCategoryTree(int familyID, String adminCCNumber) {
        FamilyService familyService = this.ffmApplication.getFamilyService();
        CategoryService categoryService = this.ffmApplication.getCategoryService();
        if (familyService.verifyAdministratorPermission(familyID, adminCCNumber)) {
            CategoryTreeDTO categoryTree = categoryService.getCategoryTree(familyID, familyService);
            return true;
        } else {
            return false;
        }
    }


}


