package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.FamilyService;

public class CreatePersonalCashAccountController {
    private final Application ffmApplication;


    public CreatePersonalCashAccountController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    public boolean createPersonalCashAccount(int familyID, String ccNumber, String accountDesignation, double initialBalance) {
        try {
            FamilyService familyService = this.ffmApplication.getFamilyService();
            FamilyMember targetMember = familyService.getFamily(familyID).getFamilyMember(ccNumber);
            AccountService accountService = this.ffmApplication.getAccountService();
            return accountService.createPersonalCashAccount(targetMember, accountDesignation, initialBalance);
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }
}
