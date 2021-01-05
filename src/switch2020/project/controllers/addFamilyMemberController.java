package switch2020.project.controllers;

import switch2020.project.model.*;

public class addFamilyMemberController {

    private Application app;

    public addFamilyMemberController(Application app){
        this.app = app;
    }

    private boolean addFamilyMember(String name, String birthDate, PhoneNumber phone, EmailAddress email, VatNumber vat, Relationship relationship){

        return this.app.addFamilyMember(name, birthDate, phone, email, vat, relationship);

    }
}
