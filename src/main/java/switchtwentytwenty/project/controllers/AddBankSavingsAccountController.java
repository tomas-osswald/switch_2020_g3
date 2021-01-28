package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.FamilyService;

public class AddBankSavingsAccountController {

    private final Application ffmApplication;

    public AddBankSavingsAccountController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    public boolean addBankSavingsAccount(int familyID, String ccNumber, String accountName, Double balance, Double interestRate) {
        AccountService accountService = new AccountService();
        try {
            FamilyService familyService = this.ffmApplication.getFamilyService();
            Family targetFamily = familyService.getFamily(familyID);
            FamilyMember targetMember = targetFamily.getFamilyMember(ccNumber);
            return accountService.addBankSavingsAccount(targetMember, accountName, balance, interestRate);
        } catch (Exception exception) {
            return false;
        }
    }
}
