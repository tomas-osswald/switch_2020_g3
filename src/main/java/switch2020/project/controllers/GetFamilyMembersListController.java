package switch2020.project.controllers;

import switch2020.project.model.Application;
import switch2020.project.utils.FamilyMemberRelationshipDTO;

import java.util.ArrayList;


public class GetFamilyMembersListController {
    private Application FFMapp;

    public GetFamilyMembersListController(Application app) {
        this.FFMapp = app;
    }

    public ArrayList<FamilyMemberRelationshipDTO> getFamilyMemberAndRelationship(int familyId){
        return this.FFMapp.getDTOList(familyId);
    }



}
