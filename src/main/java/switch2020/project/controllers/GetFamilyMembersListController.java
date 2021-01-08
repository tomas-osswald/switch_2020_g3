package switch2020.project.controllers;

import switch2020.project.model.Application;
import switch2020.project.utils.FamilyMemberRelationDTO;

import java.util.ArrayList;
import java.util.List;


public class GetFamilyMembersListController {
    private Application FFMapp;

    public GetFamilyMembersListController(Application app) {
        this.FFMapp = app;
    }

    public List<FamilyMemberRelationDTO> getFamilyMemberAndRelation(int familyID){
        return this.FFMapp.getDTOList(familyID);
    }

}
