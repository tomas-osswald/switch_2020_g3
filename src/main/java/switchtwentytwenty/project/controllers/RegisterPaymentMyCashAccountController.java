package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.accounts.Account;
import switchtwentytwenty.project.domain.model.accounts.AccountTypeEnum;
import switchtwentytwenty.project.domain.model.accounts.CashAccount;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.CategoryService;
import switchtwentytwenty.project.domain.services.FamilyService;
import switchtwentytwenty.project.domain.services.TransactionService;
import switchtwentytwenty.project.domain.utils.TransferenceDTO;

import java.util.Date;

public class RegisterPaymentMyCashAccountController {

    private final Application ffmApplication;

    public RegisterPaymentMyCashAccountController(Application ffmApplication){
        this.ffmApplication = ffmApplication;
    }

    public boolean RegisterPaymentMyCashAccount(TransferenceDTO transferenceDTO) {
        // FamilyService
        FamilyService famService = this.ffmApplication.getFamilyService();
        FamilyMember myself = famService.getFamily(transferenceDTO.getFamilyID()).getFamilyMember(transferenceDTO.getFamilyMemberCC());
        Account cashAccount = myself.getAccount(transferenceDTO.getAccountID());

        // Category Service
        CategoryService categoryService = new CategoryService();
        StandardCategory category = categoryService.getStandardCategoryByID(transferenceDTO.getCategoryID()); // TODO: ALTERAR PARA GENERAL CATEGORY

        // AccountService
        AccountService accountService = new AccountService();
        accountService.verifyAccountType(cashAccount, AccountTypeEnum.CASHACCOUNT);

        // TransactionService
        TransactionService transactionService = this.ffmApplication.getTransactionService();
        return transactionService.registerPaymentMyCashAccount(cashAccount,category,transferenceDTO);
    }

}
