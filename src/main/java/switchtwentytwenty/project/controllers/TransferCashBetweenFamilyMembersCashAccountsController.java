package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.CategoryService;
import switchtwentytwenty.project.domain.services.FamilyService;
import switchtwentytwenty.project.domain.DTOs.input.CashTransferDTO;

public class TransferCashBetweenFamilyMembersCashAccountsController {

    private final Application app;

    public TransferCashBetweenFamilyMembersCashAccountsController(Application app) {
        this.app = app;
    }

    public boolean transferCashBetweenFamilyMembersCashAccounts(CashTransferDTO cashTransferDTO){
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
            return accountService.transferCashBetweenFamilyMembersCashAccounts(family, originFamilyMember, destinationFamilyMember, category, cashTransferDTO);
            //TODO corrigir esta falha de cobertura
        } catch ( NullPointerException exception) {
            return false;
        }
    }
}
