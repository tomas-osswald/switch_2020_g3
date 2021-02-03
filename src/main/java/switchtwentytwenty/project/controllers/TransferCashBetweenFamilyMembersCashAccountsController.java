package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.dtos.input.CashTransferDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.accounts.Account;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.CategoryService;
import switchtwentytwenty.project.domain.services.FamilyService;
import switchtwentytwenty.project.domain.services.TransactionService;

public class TransferCashBetweenFamilyMembersCashAccountsController {

    private final Application app;

    public TransferCashBetweenFamilyMembersCashAccountsController(Application app) {
        this.app = app;
    }

    public boolean transferCashBetweenFamilyMembersCashAccounts(CashTransferDTO cashTransferDTO) {
        FamilyService familyService = this.app.getFamilyService();
        int familyID = cashTransferDTO.getFamilyID();
        int categoryID = cashTransferDTO.getCategoryID();
        String originFamilyMemberCC = cashTransferDTO.getOriginFamilyMemberCC();
        String destinationFamilyMemberCC = cashTransferDTO.getDestinationFamilyMemberCC();
        Category category;

        try {
            Family family = familyService.getFamily(familyID);
            FamilyMember originFamilyMember = familyService.getFamily(familyID).getFamilyMember(originFamilyMemberCC);
            FamilyMember destinationFamilyMember = familyService.getFamily(familyID).getFamilyMember(destinationFamilyMemberCC);
            if(categoryID>=0) {
                CategoryService categoryService = this.app.getCategoryService();
                category = categoryService.getStandardCategoryByID(categoryID);
            }
            else category = family.getCustomCategoryByID(categoryID);
            if (category==null) return false;

            TransactionService transactionService = app.getTransactionService();
            AccountService accountService = app.getAccountService();
            accountService.transferCashBetweenFamilyMembersCashAccounts(family,originFamilyMember,destinationFamilyMember,category,cashTransferDTO);
            Account originAccount = originFamilyMember.getAccount(cashTransferDTO.getOriginAccountID());
            Account destinationAccount = destinationFamilyMember.getAccount(cashTransferDTO.getDestinationAccountID());
            transactionService.registerCashTransferOther(originAccount,destinationAccount, category , cashTransferDTO);
            return true;
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }
}
