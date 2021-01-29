package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.CategoryService;
import switchtwentytwenty.project.domain.services.FamilyService;
import switchtwentytwenty.project.domain.utils.TransferenceDTO;

public class TransferCashFromFamilyAccountToPersonalAccountController {

    private final Application ffmApplication;

    public TransferCashFromFamilyAccountToPersonalAccountController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    public boolean transferCashFromFamilyToFamilyMember(TransferenceDTO transferCashDTO) {
        FamilyService familyService = this.ffmApplication.getFamilyService();
        CategoryService categoryService = this.ffmApplication.getCategoryService();
        int familyID = transferCashDTO.getFamilyID();
        String familyMemberCC = transferCashDTO.getFamilyMemberCC();
        int categoryID = transferCashDTO.getCategoryID();

        try {
            Family family = familyService.getFamily(familyID);
            FamilyMember familyMember = familyService.getFamily(familyID).getFamilyMember(familyMemberCC);
            StandardCategory category = categoryService.getStandardCategoryByID(categoryID); //TODO: Mudar para category

            AccountService accountService = new AccountService();
            return accountService.transferCashFromFamilyToFamilyMember(family, familyMember, category, transferCashDTO);
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }


}
