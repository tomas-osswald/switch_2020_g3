package switch2020.project.controllers;

import switch2020.project.domain.model.Application;
import switch2020.project.domain.model.CustomCategory;
import switch2020.project.domain.model.StandardCategory;
import switch2020.project.domain.services.CategoryService;
import switch2020.project.domain.services.FamilyService;

public class addCategoryToFamilyTreeController {
    private Application ffmApplication;

    public addCategoryToFamilyTreeController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    //Parent is Standard
    public boolean addCategoryToFamilyTree(String adminCC, int familyID, String designation, StandardCategory parentCategory) {
        CategoryService categoryService = this.ffmApplication.getCategoryService();
        FamilyService familyService = this.ffmApplication.getFamilyService();
        if (familyService.verifyAdministratorPermission(familyID, adminCC)) {
            return categoryService.addCategoryToFamilyTree(familyID, designation, parentCategory, familyService);
        }
        return false;
    }

    //Parent is Custom
    public boolean addCategoryToFamilyTree(String adminCC, int familyID, String designation, CustomCategory parentCategory) {
        CategoryService categoryService = this.ffmApplication.getCategoryService();
        FamilyService familyService = this.ffmApplication.getFamilyService();
        if (familyService.verifyAdministratorPermission(familyID, adminCC)) {
            return categoryService.addCategoryToFamilyTree(familyID, designation, parentCategory, familyService);
        }
        return false;
    }

    //No Parent
    public boolean addCategoryToFamilyTree(String adminCC, int familyID, String designation) {
        CategoryService categoryService = this.ffmApplication.getCategoryService();
        FamilyService familyService = this.ffmApplication.getFamilyService();
        if (familyService.verifyAdministratorPermission(familyID, adminCC)) {
            return categoryService.addCategoryToFamilyTree(familyID, designation, familyService);
        }
        return false;
    }
}
