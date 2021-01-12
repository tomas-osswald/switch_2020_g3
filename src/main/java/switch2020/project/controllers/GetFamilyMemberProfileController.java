package switch2020.project.controllers;

import switch2020.project.model.Application;
import switch2020.project.services.FamilyService;
import switch2020.project.utils.MemberProfileDTO;

public class GetFamilyMemberProfileController {

    private Application FFMapp;

    public GetFamilyMemberProfileController(Application app) {
        this.FFMapp = app;
    }

    public MemberProfileDTO getMemberProfile(int familyID, String ccNumber) {

        FamilyService familyService = this.FFMapp.getFamilyService();
        return familyService.getFamilyMemberProfile(familyID, ccNumber);
    }
}
