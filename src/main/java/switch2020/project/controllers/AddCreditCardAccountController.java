package switch2020.project.controllers;

import switch2020.project.domain.DTOs.input.AddCreditCardAccountDTO;
import switch2020.project.domain.model.Application;
import switch2020.project.domain.model.FamilyMember;
import switch2020.project.domain.services.AccountService;
import switch2020.project.domain.services.FamilyService;

public class AddCreditCardAccountController {
    private Application app;

    public AddCreditCardAccountController(Application app) {
        this.app = app;
    }

    public boolean addCreditCardAccountToFamilyMember(AddCreditCardAccountDTO addCreditCardAccountDTO) {
        try {
            FamilyService familyService = this.app.getFamilyService();
            FamilyMember targetMember = familyService.getFamily(addCreditCardAccountDTO.getFamilyID()).getFamilyMember(addCreditCardAccountDTO.getFamilyMemberID());
            AccountService accountService = this.app.getAccountService();
            return accountService.createPersonalCreditCardAccount(addCreditCardAccountDTO, targetMember);
        } catch (Exception exception) {
            return false;
        }

    }
}
