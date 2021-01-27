package switch2020.project.controllers;

import switch2020.project.domain.DTOs.input.AddCreditCardAccountDTO;
import switch2020.project.domain.model.Application;
import switch2020.project.domain.model.FamilyMember;
import switch2020.project.domain.services.AccountService;
import switch2020.project.domain.services.FamilyService;

public class AddCreditCardAccountController {
    private Application ffmApplication;

    public AddCreditCardAccountController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    public boolean addCreditCardAccountToFamilyMember(AddCreditCardAccountDTO addCreditCardAccountDTO) {
        try {
            FamilyService familyService = this.ffmApplication.getFamilyService();
            FamilyMember targetMember = familyService.getFamily(addCreditCardAccountDTO.getFamilyID()).getFamilyMember(addCreditCardAccountDTO.getFamilyMemberID());
            AccountService accountService = this.ffmApplication.getAccountService();
            return accountService.createPersonalCreditCardAccount(addCreditCardAccountDTO, targetMember);
        } catch (Exception exception) {
            return false;
        }

    }
}
