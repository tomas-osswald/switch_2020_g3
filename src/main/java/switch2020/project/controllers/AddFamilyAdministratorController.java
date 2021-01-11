package switch2020.project.controllers;

import switch2020.project.model.Application;
import switch2020.project.services.FamilyService;
import switch2020.project.utils.FamilyWithoutAdministratorDTO;

import java.util.ArrayList;
import java.util.List;

public class AddFamilyAdministratorController {
    private Application application;

    public AddFamilyAdministratorController(Application application) {
        this.application = application;
    }

    public List<FamilyWithoutAdministratorDTO> familiesWithoutAdministrator() {
        FamilyService familyService = application.getFamilyService();

        return familyService.familiesWithoutAdministrator();
    }
}
