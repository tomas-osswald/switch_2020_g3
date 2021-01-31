package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.CategoryService;
import switchtwentytwenty.project.domain.services.FamilyService;
import switchtwentytwenty.project.domain.DTOs.input.FamilyCashTransferDTO;

public class TransferCashFromFamilyAccountToPersonalAccountController {

    private final Application ffmApplication;

    public TransferCashFromFamilyAccountToPersonalAccountController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    public boolean transferCashFromFamilyToFamilyMember(FamilyCashTransferDTO familyCashTransferDTO) {
        FamilyService familyService = this.ffmApplication.getFamilyService();
        CategoryService categoryService = this.ffmApplication.getCategoryService();
        int familyID = familyCashTransferDTO.getFamilyID();
        String familyMemberCC = familyCashTransferDTO.getFamilyMemberCC();
        int categoryID = familyCashTransferDTO.getCategoryID();
        Category category;

        try {
            Family family = familyService.getFamily(familyID);
            FamilyMember familyMember = familyService.getFamily(familyID).getFamilyMember(familyMemberCC);

            if (categoryID>=0) category = categoryService.getStandardCategoryByID(categoryID);
            else category = family.getCustomCategoryByID(categoryID);

            AccountService accountService = new AccountService();
            return accountService.transferCashFromFamilyToFamilyMember(family, familyMember, category, familyCashTransferDTO);
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }


}
