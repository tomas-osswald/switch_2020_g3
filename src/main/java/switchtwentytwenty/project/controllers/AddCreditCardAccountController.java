package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.DTOs.input.AddCreditCardAccountDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.FamilyService;

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
