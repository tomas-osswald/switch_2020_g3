package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.dtos.input.AddFamilyMemberDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.services.FamilyService;
import switchtwentytwenty.project.domain.dtos.output.FamilyWithoutAdministratorDTO;

import java.util.List;

public class AddFamilyAdministratorController {
    private final Application ffmApplication;

    public AddFamilyAdministratorController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    /** Isto e para a UI | Penso que nao seja necessario para ja **/
    public List<FamilyWithoutAdministratorDTO> familiesWithoutAdministrator() {
        FamilyService familyService = ffmApplication.getFamilyService();

        return familyService.familiesWithoutAdministrator();
    }

    public boolean addFamilyAdministrator(AddFamilyMemberDTO familyMemberDTO){
        try {
            FamilyService familyService = this.ffmApplication.getFamilyService();
            familyService.addFamilyAdministrator(familyMemberDTO);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}