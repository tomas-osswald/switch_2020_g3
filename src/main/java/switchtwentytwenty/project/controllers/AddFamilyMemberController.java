package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.services.FamilyService;

import java.util.Date;

public class AddFamilyMemberController {

    private Application ffmApplication;

    public AddFamilyMemberController(Application ffmApplication){
        this.ffmApplication = ffmApplication;
    }

    public boolean addFamilyMember(String selfCCNumber,String cc, String name, Date birthDate, Integer phone, String email, Integer vat, String street, String codPostal, String local, String city, int familyID){
        try {
            FamilyService familyService = this.ffmApplication.getFamilyService();
            familyService.addFamilyMember(selfCCNumber,cc,name, birthDate, phone, email, vat, street, codPostal, local, city, familyID);
            return true;
        } catch(IllegalArgumentException e) {
            return false;
        }
    }
}
