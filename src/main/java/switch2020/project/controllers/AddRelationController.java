package switch2020.project.controllers;

import switch2020.project.model.Application;

public class AddRelationController {
    private Application app;

    public AddRelationController(Application app) {
        this.app = app;
    }

    public boolean createRelation(int selfID, int otherID, String relationDesignation, int familyID) {
        try {
            this.app.createRelation(selfID, otherID, relationDesignation, familyID);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return false;
        }

        return true;
    }
}
