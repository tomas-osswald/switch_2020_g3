package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.accounts.Account;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.CategoryService;
import switchtwentytwenty.project.domain.services.FamilyService;
import switchtwentytwenty.project.domain.utils.CashTransferDTO;
import switchtwentytwenty.project.domain.utils.TransferenceDTO;

public class TransferCashBetweenFamilyMembersCashAccountsController {

    private Application app;

    public TransferCashBetweenFamilyMembersCashAccountsController(Application app) {
        this.app = app;
    }

    public boolean TransferCashBetweenFamilyMembersCashAccounts(CashTransferDTO cashTransferDTO){
        FamilyService familyService = this.app.getFamilyService();
        CategoryService categoryService = this.app.getCategoryService();

        String originFamilyMemberCC = cashTransferDTO.getOriginFamilyMemberCC();
        String destinationFamilyMemberCC = cashTransferDTO.getDestinationFamilyMemberCC();
        int categoryID = cashTransferDTO.getCategoryID();
        int familyID = cashTransferDTO.getFamilyID();
        int originAccount = cashTransferDTO.getOriginAccountID();
        int destinationAccount = cashTransferDTO.getDestinationAccountID();
        Account originAccountID = familyService.getFamily(familyID).getFamilyMember(originFamilyMemberCC).getAccount(originAccount);
        Account destinationAccountID = familyService.getFamily(familyID).getFamilyMember(destinationFamilyMemberCC).getAccount(destinationAccount);
        StandardCategory category = categoryService.getStandardCategoryByID(categoryID);

        AccountService accountService = new AccountService();
        return accountService.transferCashBetweenFamilyMembersCashAccounts(originAccountID, destinationAccountID, category, cashTransferDTO);

    }
}
