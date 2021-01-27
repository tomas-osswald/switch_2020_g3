package switch2020.project.controllers;

import switch2020.project.domain.model.*;

import switch2020.project.domain.model.categories.StandardCategory;
import switch2020.project.domain.services.AccountService;
import switch2020.project.domain.services.CategoryService;
import switch2020.project.domain.services.FamilyService;
import switch2020.project.domain.utils.TransferenceDTO;

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
