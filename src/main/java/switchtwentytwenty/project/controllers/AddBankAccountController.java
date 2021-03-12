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

    /**
     * Method to add a Credit Card Account to a given Family Member
     *
     * @param addBankAccountDTO DTO containing the required information(e.g. description, balance...) to create a bank account
     * @return confirmation of status, true for account created and false for failure to create
     */
    public boolean addBankAccount(AddBankAccountDTO addBankAccountDTO) {
        try {
            AccountService accountService = this.ffmApplication.getAccountService();
            accountService.addBankAccount(addBankAccountDTO);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
