package switch2020.project.controllers;

import switch2020.project.model.Application;

public class CreateFamilyCashAccountController {
    private Application FFMapp;

    public CreateFamilyCashAccountController(Application app) {
        this.FFMapp = app;
    }

    /**
     * Method to create a CashAccount object for the Family with the passed ID
     *
     * @param familyID integer identifier of family for which account will be created
     * @return True if cash account succesfully created for the family with the given ID
     */
    public boolean createFamilyCashAccount(int familyID) {
        return this.FFMapp.createFamilyCashAccount(familyID);
    }


}