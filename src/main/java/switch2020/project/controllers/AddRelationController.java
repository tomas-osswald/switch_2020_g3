package java.switch2020.project.controllers;

import java.switch2020.project.model.Application;

public class AddRelationController {
    private Application app;

    public AddRelationController(Application app) {
        this.app = app;
    }

    public boolean createRelation(int selfID, int otherID, String relationDesignation, int familyID) {
        return this.app.createRelation(selfID, otherID, relationDesignation, familyID);
    }
}
