package switch2020.project.controllers;

import switch2020.project.model.Application;
import switch2020.project.utils.MemberProfileDTO;
import switch2020.project.services.FamilyService;

public class GetFamilyMemberProfileController {

    private Application FFMapp;

    public GetFamilyMemberProfileController(Application app){
        this.FFMapp = app;
    }

    public MemberProfileDTO getMemberProfile(int familyID, int familyMemberID) {

        FamilyService familyService = this.FFMapp.getFamilyService();
        return familyService.getFamilyMemberProfile(familyID, familyMemberID);
    }
}
