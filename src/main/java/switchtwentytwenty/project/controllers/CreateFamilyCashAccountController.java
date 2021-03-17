package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.services.AccountService;

public class CreateFamilyCashAccountController {
    private final Application ffmApplication;

    public CreateFamilyCashAccountController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    /**
     * Method to create a family cash account for  family object that will ask the application for the service to conclude this task
     *
     * @param familyID           given family object ID
     * @param accountDesignation description for the account
     * @param initialBalance     initial value for the cash account
     * @param ccNumber           ID of the current user
     * @return returns true if the task was successful
     */
    public boolean createFamilyCashAccount(int familyID, String accountDesignation, double initialBalance, String ccNumber) {
        boolean result = false;
        try {
            AccountService accountService = this.ffmApplication.getAccountService();
            accountService.createFamilyCashAccount(familyID, ccNumber, accountDesignation, initialBalance);
            result = true;
        } catch (IllegalArgumentException exception) {
        }
        return result;
    }
}