package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.services.CategoryService;
import switchtwentytwenty.project.domain.services.FamilyService;

public class AddCategoryToFamilyTreeController {
    private final Application ffmApplication;


    public AddCategoryToFamilyTreeController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    /**
     * Controller method to add a new Custom category to a specific family
     *
     * @param adminCC             ID number of the family admin
     * @param familyID            ID of the target family
     * @param categoryDesignation Label/Description to assign to the category
     * @param parentID            ID of the Standard or Custom category to be the parent. 0 for root
     * @return True if the category successfully added to the family's category tree.
     */
    public boolean addCategoryToFamilyTree(String adminCC, int familyID, String categoryDesignation, int parentID) {
        CategoryService categoryService = this.ffmApplication.getCategoryService();
        FamilyService familyService = this.ffmApplication.getFamilyService();
        try {
            if (familyService.verifyAdministratorPermission(familyID, adminCC)) {
                Family targetFamily = familyService.getFamily(familyID);
                categoryService.addCategoryToFamilyTree(targetFamily, categoryDesignation, parentID);
                return true;
            }

        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
