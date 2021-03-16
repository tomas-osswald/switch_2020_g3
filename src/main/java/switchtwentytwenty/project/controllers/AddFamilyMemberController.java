package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.dtos.input.AddFamilyMemberDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.services.FamilyService;

public class AddFamilyMemberController {

    private final Application ffmApplication;

    public AddFamilyMemberController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    public boolean addFamilyMember(AddFamilyMemberDTO familyMemberDTO) {
        boolean result = false;
        try {
            FamilyService familyService = this.ffmApplication.getFamilyService();
            result = familyService.addFamilyMember(familyMemberDTO);
        } catch (IllegalArgumentException e) {
        }
        return result;
    }
}
