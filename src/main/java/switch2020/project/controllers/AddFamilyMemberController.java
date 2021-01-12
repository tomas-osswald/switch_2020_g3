package switch2020.project.controllers;

import switch2020.project.model.Application;
import switch2020.project.model.Relation;
import switch2020.project.services.FamilyService;

import java.util.Date;

public class AddFamilyMemberController {

    private Application FFMapp;

    public AddFamilyMemberController(Application app){
        this.FFMapp = app;
    }

    public boolean addFamilyMember(String selfCCNumber,String cc, String name, Date birthDate, Integer phone, String email, Integer vat, String street, String codPostal, String local, String city, Relation relationship, int familyID){
        try {
            FamilyService familyService = this.FFMapp.getFamilyService();
            familyService.addFamilyMember(selfCCNumber,cc,name, birthDate, phone, email, vat, street, codPostal, local, city, relationship, familyID);
            return true;
        } catch(IllegalArgumentException e) {
            return false;
        }
    }
}
