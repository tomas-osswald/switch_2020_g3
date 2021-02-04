package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.dtos.input.AddCashAccountDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.FamilyService;

public class CreatePersonalCashAccountController {
    private final Application ffmApplication;


    public CreatePersonalCashAccountController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    /**
     * Controller-level method to create a personal cash account
     *
     * @param addCashAccountDTO DTO that contains the necessary data for a cash account creation
     * @return True if Cash Account sucessfuly created
     */
    public boolean createPersonalCashAccount(AddCashAccountDTO addCashAccountDTO) {
        try {
            FamilyService familyService = this.ffmApplication.getFamilyService();
            FamilyMember targetMember = familyService.getFamily(addCashAccountDTO.getFamilyID()).getFamilyMember(addCashAccountDTO.getFamilyMemberID());
            AccountService accountService = this.ffmApplication.getAccountService();
            return accountService.createPersonalCashAccount(targetMember, addCashAccountDTO);
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }
}
