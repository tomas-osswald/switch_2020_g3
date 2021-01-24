package switch2020.project.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import switch2020.project.domain.model.Account;
import switch2020.project.domain.model.Application;
import switch2020.project.domain.model.FamilyMember;
import switch2020.project.domain.services.AccountService;
import switch2020.project.domain.services.FamilyService;

public class AddCreditCardAccountController {
    private Application app;

    public AddCreditCardAccountController(Application app) {
        this.app = app;
    }

    public boolean addCreditCardAccountToFamilyMember(int familyID, String familyMemberID){

        FamilyService familyService = this.app.getFamilyService();
        FamilyMember member = familyService.getFamily(familyID).getFamilyMember(familyMemberID);
        AccountService accountService = this.app.getAccountService();
        return accountService.createPersonalCreditCardAccount(member,"0",0,0);
        }
}
