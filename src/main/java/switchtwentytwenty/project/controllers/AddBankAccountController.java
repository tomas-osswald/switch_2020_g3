package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.dtos.input.AddBankAccountDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.FamilyService;

public class AddBankAccountController {

    private final Application ffmApplication;

    public AddBankAccountController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    public boolean addBankAccount(AddBankAccountDTO addBankAccountDTO) {
        AccountService accountService = new AccountService();
        try {
            FamilyService familyService = this.ffmApplication.getFamilyService();
            FamilyMember targetMember = familyService.getFamily(addBankAccountDTO.getFamilyID()).getFamilyMember(addBankAccountDTO.getFamilyMemberID());
            accountService.addBankAccount(addBankAccountDTO, targetMember);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
