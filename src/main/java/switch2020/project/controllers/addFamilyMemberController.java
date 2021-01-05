package main.java.switch2020.project.controllers;

import main.java.switch2020.project.model.*;

public class addFamilyMemberController {

    private Application FFMapp;

    public addFamilyMemberController(Application app){
        this.FFMapp = app;
    }

    private boolean addFamilyMember(String name, String birthDate, PhoneNumber phone, EmailAddress email, VatNumber vat, Relationship relationship, int familyID){

        if(FFMapp.ch) // Verificar se o ID da familia se encontra presente
        return this.FFMapp.addFamilyMember(name, birthDate, phone, email, vat, relationship);

    }
}
