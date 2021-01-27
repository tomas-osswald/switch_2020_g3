package switch2020.project.controllers;

import switch2020.project.domain.model.Application;
import switch2020.project.domain.model.Family;
import switch2020.project.domain.services.CategoryService;
import switch2020.project.domain.services.FamilyService;

public class AddCategoryToFamilyTreeController {
    private final Application ffmApplication;


    public AddCategoryToFamilyTreeController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    public boolean addCategoryToFamilyTree(String adminCC, int familyID, String categoryDesignation, int parentID) {
        CategoryService categoryService = this.ffmApplication.getCategoryService();
        FamilyService familyService = this.ffmApplication.getFamilyService();
        try {
            if (familyService.verifyAdministratorPermission(familyID, adminCC)) {
                Family targetFamily = familyService.getFamily(familyID);
                return categoryService.addCategoryToFamilyTree(targetFamily, categoryDesignation, parentID);
            }

        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
