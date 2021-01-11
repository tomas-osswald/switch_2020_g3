package switch2020.project.controllers;

import switch2020.project.model.Application;
import switch2020.project.model.Relation;
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

    public boolean addFamilyAdministrator(int familyMemberID, String name, String birthDate, Integer phone, String email, Integer vat, String street, String codPostal, String local, String city, Relation relationship, int familyID, boolean administrator){
        FamilyService familyService = this.application.getFamilyService();
        return familyService.addFamilyAdministrator(familyMemberID, name, birthDate, phone, email, vat, street, codPostal, local, city, relationship, familyID, administrator);
    }
}