package switch2020.project.controllers;

import switch2020.project.model.Application;
import switch2020.project.services.FamilyService;

public class AddFamilyController {

    private Application FFMapp;

    public AddFamilyController(Application app) {
        this.FFMapp = app;
    }

    public boolean addFamily(String familyName) {
        FamilyService familyService = FFMapp.getFamilyService();
        return familyService.addFamily(familyName);
    }

}
