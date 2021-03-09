package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.dtos.input.AddCreditCardAccountDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.services.AccountService;

public class AddCreditCardAccountController {
    private final Application ffmApplication;

    public AddCreditCardAccountController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    /**
     * Method to add a Credit Card Account to a given Family Member
     *
     * @param addCreditCardAccountDTO DTO with information to create a Credit Card Account instance
     * @return true if a Credit Card Account was sucessfull created and assigne, false if an error occured during the process
     */
    public boolean addCreditCardAccountToFamilyMember(AddCreditCardAccountDTO addCreditCardAccountDTO) {
        boolean result = false;
        try {
            AccountService accountService = this.ffmApplication.getAccountService();
            result = accountService.createPersonalCreditCardAccount(addCreditCardAccountDTO);
        } catch (Exception exception) {
        }
        return result;
    }
}
