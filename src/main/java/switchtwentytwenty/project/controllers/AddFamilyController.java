package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.services.FamilyService;

public class AddFamilyController {

    private final Application ffmApplication;

    public AddFamilyController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    public boolean addFamily(String familyName) {
        FamilyService familyService = ffmApplication.getFamilyService();
        return familyService.addFamily(familyName);
    }

}
