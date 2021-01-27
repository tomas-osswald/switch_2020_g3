package switch2020.project.controllers;

import switch2020.project.domain.model.Application;
import switch2020.project.domain.model.FamilyMember;
import switch2020.project.domain.services.AccountService;
import switch2020.project.domain.services.FamilyService;

public class AddBankAccountController {

    private final Application ffmApplication;

    public AddBankAccountController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    public boolean addBankAccount(String accountName, int familyID, String memberCC, Double balance) {

            FamilyService familyService = this.ffmApplication.getFamilyService();
            FamilyMember targetMember = familyService.getFamily(familyID).getFamilyMember(memberCC);
            AccountService accountService = this.ffmApplication.getAccountService();
            if (accountService.addBankAccount(targetMember, accountName, balance)) {
                return true;
            }
            return false;

    }
}
