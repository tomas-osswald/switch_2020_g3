package switch2020.project.controllers;

import switch2020.project.domain.model.Application;
import switch2020.project.domain.model.FamilyMember;
import switch2020.project.domain.services.AccountService;
import switch2020.project.domain.services.FamilyService;

public class AddCreditCardAccountController {
    private Application app;

    public AddCreditCardAccountController(Application app) {
        this.app = app;
    }

    public boolean addCreditCardAccountToFamilyMember(String familyMemberID, int familyID, String cardDescription, int withdrwaLimit) {
        try {
            FamilyService familyService = this.app.getFamilyService();
            FamilyMember targetMember = familyService.getFamily(familyID).getFamilyMember(familyMemberID);
            AccountService accountService = this.app.getAccountService();
            return accountService.createPersonalCreditCardAccount(targetMember, cardDescription, withdrwaLimit);
        } catch (Exception exception) {
            return false;
        }

    }
}
