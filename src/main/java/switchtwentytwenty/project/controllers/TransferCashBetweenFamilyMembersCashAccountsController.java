package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.CategoryService;
import switchtwentytwenty.project.domain.services.FamilyService;
import switchtwentytwenty.project.domain.utils.CashTransferDTO;

public class TransferCashBetweenFamilyMembersCashAccountsController {

    private Application app;

    public TransferCashBetweenFamilyMembersCashAccountsController(Application app) {
        this.app = app;
    }

    public boolean TransferCashBetweenFamilyMembersCashAccounts(CashTransferDTO cashTransferDTO){
        FamilyService familyService = this.app.getFamilyService();
        CategoryService categoryService = this.app.getCategoryService();
        int familyID = cashTransferDTO.getFamilyID();

        String originFamilyMemberCC = cashTransferDTO.getOriginFamilyMemberCC();
        String destinationFamilyMemberCC = cashTransferDTO.getDestinationFamilyMemberCC();
        int categoryID = cashTransferDTO.getCategoryID();

        try {
            Family family = familyService.getFamily(familyID);
            FamilyMember originFamilyMember = familyService.getFamily(familyID).getFamilyMember(originFamilyMemberCC);
            FamilyMember destinationFamilyMember = familyService.getFamily(familyID).getFamilyMember(destinationFamilyMemberCC);
            StandardCategory category = categoryService.getStandardCategoryByID(categoryID);
            AccountService accountService = new AccountService();
            return accountService.transferCashBetweenFamilyMembersCashAccounts(originFamilyMember, destinationFamilyMember, category, cashTransferDTO);
        } catch (IllegalArgumentException exception) {
            return false;
        }

    }
}
