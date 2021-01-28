package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.accounts.Account;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.CategoryService;
import switchtwentytwenty.project.domain.services.FamilyService;
import switchtwentytwenty.project.domain.utils.TransferenceDTO;

public class TransferCashFromFamilyAccountToPersonalAccountController {

    private Application ffmApplication;

    public TransferCashFromFamilyAccountToPersonalAccountController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    public boolean transferCashFromFamilyToFamilyMember(TransferenceDTO transferCashDTO){
        FamilyService familyService = this.ffmApplication.getFamilyService();
        CategoryService categoryService = this.ffmApplication.getCategoryService();
        int familyID = transferCashDTO.getFamilyID();
        String familyMemberCC = transferCashDTO.getFamilyMemberCC();
        int accountID = transferCashDTO.getAccountID();
        int categoryID = transferCashDTO.getCategoryID();

        Account familyAccount = familyService.getFamily(familyID).getFamilyCashAccount();
        Account targetAccount = familyService.getFamily(familyID).getFamilyMember(familyMemberCC).getAccount(accountID);
        StandardCategory category = categoryService.getStandardCategoryByID(categoryID);

        AccountService accountService = new AccountService();
        return accountService.transferCashFromFamilyToFamilyMember(familyAccount, targetAccount, category, transferCashDTO);

    }




}
