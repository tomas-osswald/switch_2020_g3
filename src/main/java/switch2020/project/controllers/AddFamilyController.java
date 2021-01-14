package switch2020.project.controllers;

import switch2020.project.model.Application;
import switch2020.project.services.FamilyService;

public class AddFamilyController {

    private Application ffmApplication;

    public AddFamilyController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    public boolean addFamily(String familyName) {
        FamilyService familyService = ffmApplication.getFamilyService();
        return familyService.addFamily(familyName);
    }

}
