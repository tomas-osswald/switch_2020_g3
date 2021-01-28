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
        /*int originAccountID = cashTransferDTO.
        int categoryID = transferCashDTO.getCategoryID();

        Account originAccount = familyService.getFamily(familyID).getFamilyMember(familyMemberCC).getAccount(accountID);
        Account destinationAccount = familyService.getFamily(familyID).getFamilyMember(familyMemberCC).getAccount(accountID);
        StandardCategory category = categoryService.getStandardCategoryByID(categoryID);

        AccountService accountService = new AccountService();
        return accountService.transferCashBetweenFamilyMembersCashAccounts(originAccount, destinationAccount, category, transferCashDTO);*/
        return true;
    }
}
