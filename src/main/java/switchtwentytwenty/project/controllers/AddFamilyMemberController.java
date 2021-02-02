package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.dtos.input.AddFamilyMemberDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.services.FamilyService;


public class AddFamilyMemberController {

    private final Application ffmApplication;

    public AddFamilyMemberController(Application ffmApplication){
        this.ffmApplication = ffmApplication;
    }

    public boolean addFamilyMember(AddFamilyMemberDTO familyMemberDTO){
        try {
            FamilyService familyService = this.ffmApplication.getFamilyService();
            familyService.addFamilyMember(familyMemberDTO);
            return true;
        } catch(IllegalArgumentException e) {
            return false;
        }
    }
}
