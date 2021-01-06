package switch2020.project.controllers;

import switch2020.project.model.Application;
import switch2020.project.model.Relationship;

public class addFamilyMemberController {

    private Application FFMapp;

    public addFamilyMemberController(Application app){
        this.FFMapp = app;
    }

    private boolean addFamilyMember(String name, String birthDate, Integer phone, String email, Integer vat, String street, String codPostal, String local, String city, Relationship relationship, int familyID){

        return this.FFMapp.addFamilyMember(name, birthDate, phone, email, vat, street, codPostal, local, city, relationship, familyID);

    }
}
