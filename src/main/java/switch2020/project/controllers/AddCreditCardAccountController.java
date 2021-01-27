package switch2020.project.controllers;

import switch2020.project.domain.model.Application;
import switch2020.project.domain.model.FamilyMember;
import switch2020.project.domain.services.AccountService;
import switch2020.project.domain.services.FamilyService;

public class AddCreditCardAccountController {
    private Application ffmApplication;

    public AddCreditCardAccountController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    public boolean addCreditCardAccountToFamilyMember(String familyMemberID, int familyID, String cardDescription, int withdrwaLimit) {
        try {
            FamilyService familyService = this.ffmApplication.getFamilyService();
            FamilyMember targetMember = familyService.getFamily(familyID).getFamilyMember(familyMemberID);
            AccountService accountService = this.ffmApplication.getAccountService();
            return accountService.createPersonalCreditCardAccount(targetMember, cardDescription, withdrwaLimit);
        } catch (Exception exception) {
            return false;
        }

    }
}
