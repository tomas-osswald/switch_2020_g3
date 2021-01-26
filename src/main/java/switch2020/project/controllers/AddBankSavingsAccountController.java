package switch2020.project.controllers;

import switch2020.project.domain.model.Application;
import switch2020.project.domain.model.Family;
import switch2020.project.domain.model.FamilyMember;
import switch2020.project.domain.services.AccountService;
import switch2020.project.domain.services.FamilyService;

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
            System.out.println(exception.getMessage());
            return false;
        }
    }
}
