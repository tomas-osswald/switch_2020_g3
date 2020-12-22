package switch2020.project.controllers;


import switch2020.project.model.Application;

public class AddEmailController {
    private Application FFMapp;

    public AddEmailController(Application app) {
        this.FFMapp = app;
    }

    public boolean addEmail(String emailToAdd, int familyMemberID) {
        return this.FFMapp.addEmail(emailToAdd, familyMemberID);
    }


}
