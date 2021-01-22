package switch2020.project.controllers;

import switch2020.project.domain.model.Application;
import switch2020.project.domain.model.Family;
import switch2020.project.domain.services.AccountService;
import switch2020.project.domain.services.FamilyService;

public class CreateFamilyCashAccountController {
    private Application ffmApplication;

    public CreateFamilyCashAccountController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    /**
     * Method to create a family cash account for  family object that will ask the application for the service to conclude this task
     * @param ccNumber given family object ID
     * @return returns true if the task was successful
     */
    public boolean createFamilyCashAccount(int familyID, double balance, String ccNumber) {
        try{
            FamilyService familyService = this.ffmApplication.getFamilyService();
            AccountService accountService = this.ffmApplication.getAccountService();
            Family targetFamily= familyService.getFamily(familyID);
            if(targetFamily.verifyAdministrator(ccNumber)){
                return accountService.createFamilyCashAccount(targetFamily,balance);
            }else{
                throw new IllegalArgumentException("This user does not have admin permissions");
            }


        } catch (IllegalArgumentException exception) {
            return false;
        }

    }
}