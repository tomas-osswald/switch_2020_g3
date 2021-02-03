package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.dtos.input.AddBankSavingsAccountDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.FamilyService;

public class AddBankSavingsAccountController {

    private final Application ffmApplication;

    public AddBankSavingsAccountController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    public boolean addBankSavingsAccount(AddBankSavingsAccountDTO addBankSavingsAccountDTO) {
        AccountService accountService = new AccountService();
        try {
            FamilyService familyService = this.ffmApplication.getFamilyService();
            Family targetFamily = familyService.getFamily(addBankSavingsAccountDTO.getFamilyID());
            FamilyMember targetMember = targetFamily.getFamilyMember(addBankSavingsAccountDTO.getFamilyMemberID());
            return accountService.addBankSavingsAccount(targetMember, addBankSavingsAccountDTO);
        } catch (Exception exception) {
            return false;
        }
    }
}
