package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.accounts.Account;
import switchtwentytwenty.project.domain.model.accounts.AccountTypeEnum;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.CategoryService;
import switchtwentytwenty.project.domain.services.FamilyService;
import switchtwentytwenty.project.domain.services.TransactionService;
import switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO;

public class RegisterPaymentMyCashAccountController {

    private final Application ffmApplication;

    public RegisterPaymentMyCashAccountController(Application ffmApplication){
        this.ffmApplication = ffmApplication;
    }

    public boolean registerPaymentMyCashAccount(FamilyCashTransferDTO familyCashTransferDTO) {
        // FamilyService
        FamilyService famService = this.ffmApplication.getFamilyService();
        FamilyMember myself = famService.getFamily(familyCashTransferDTO.getFamilyID()).getFamilyMember(familyCashTransferDTO.getFamilyMemberCC());
        Account cashAccount = myself.getAccount(familyCashTransferDTO.getAccountID());

        // Category Service
        CategoryService categoryService = this.ffmApplication.getCategoryService();
        Category category;
        if (familyCashTransferDTO.getCategoryID() > 0) {
            category = categoryService.getStandardCategoryByID(familyCashTransferDTO.getCategoryID());
        } else {
            category = famService.getFamily(familyCashTransferDTO.getFamilyID()).getCustomCategoryByID(familyCashTransferDTO.getCategoryID());
        }

        // AccountService
        AccountService accountService = this.ffmApplication.getAccountService();
        accountService.verifyAccountType(cashAccount, AccountTypeEnum.CASHACCOUNT);

        // TransactionService
        TransactionService transactionService = this.ffmApplication.getTransactionService();

        try {
            return transactionService.registerPaymentMyCashAccount(cashAccount,category, familyCashTransferDTO);
        }  catch (Exception e) {
            return false;
        }
    }

}
