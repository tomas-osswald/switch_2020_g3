package switch2020.project.controllers;

import switch2020.project.model.Application;
import switch2020.project.model.Relation;
import switch2020.project.services.FamilyService;

public class AddFamilyMemberController {

    private Application FFMapp;

    public AddFamilyMemberController(Application app){
        this.FFMapp = app;
    }

    public boolean addFamilyMember(String name, String birthDate, Integer phone, String email, Integer vat, String street, String codPostal, String local, String city, Relation relationship, int familyID){
        FamilyService familyService = this.FFMapp.getFamilyService();
        return familyService.addFamilyMember(name, birthDate, phone, email, vat, street, codPostal, local, city, relationship, familyID);
    }
}
