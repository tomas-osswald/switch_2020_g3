package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.FamilyService;

public class CreateFamilyCashAccountController {
    private Application ffmApplication;

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
        try {
            FamilyService familyService = this.ffmApplication.getFamilyService();
            AccountService accountService = this.ffmApplication.getAccountService();
            Family targetFamily = familyService.getFamily(familyID);
            if (targetFamily.verifyAdministrator(ccNumber)) {
                return accountService.createFamilyCashAccount(targetFamily, accountDesignation, initialBalance);
            } else {
                throw new IllegalArgumentException("This user does not have admin permissions");
            }


        } catch (IllegalArgumentException exception) {
            return false;
        }

    }
}