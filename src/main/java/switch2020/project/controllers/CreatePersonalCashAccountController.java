package switch2020.project.controllers;

import switch2020.project.domain.model.Application;
import switch2020.project.domain.services.AccountService;
import switch2020.project.domain.services.FamilyService;

public class CreatePersonalCashAccountController {
    private Application ffmApplication;


    public CreatePersonalCashAccountController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    public boolean createPersonalCashAccount(String accountName, int familyID, String memberCC, double balance ){
        FamilyService familyService = this.ffmApplication.getFamilyService();
        AccountService accountService = this.ffmApplication.getAccountService();
        return accountService.createPersonalCashAccount(familyService,accountName,familyID,memberCC,balance);
    }
}
