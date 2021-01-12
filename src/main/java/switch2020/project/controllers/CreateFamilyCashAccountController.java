package switch2020.project.controllers;

import switch2020.project.model.Application;
import switch2020.project.services.FamilyService;

public class CreateFamilyCashAccountController {
    private Application ffmApp;

    public CreateFamilyCashAccountController(Application app) {
        this.ffmApp = app;
    }

    /**
     * Method to create a family cash account for  family object that will ask the application for the service to conclude this task
     * @param familyID given family object ID
     * @return returns true if the task was successful
     */
    public boolean createFamilyCashAccount(int familyID, double balance, int selfID) {
        try{
            FamilyService familyService = this.ffmApp.getFamilyService();
            return familyService.createFamilyCashAccount(familyID, balance, selfID);
        } catch (IllegalArgumentException exception) {
            return false;
        }

    }
}