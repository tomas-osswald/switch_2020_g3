package switch2020.project.controllers;

import switch2020.project.model.Application;
import switch2020.project.services.FamilyService;

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
            return familyService.createFamilyCashAccount(familyID, balance, ccNumber);
        } catch (IllegalArgumentException exception) {
            return false;
        }

    }
}