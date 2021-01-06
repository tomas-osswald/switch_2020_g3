package switch2020.project.controllers;

import org.junit.jupiter.api.Test;

import switch2020.project.controllers.AddRelationController;
import switch2020.project.model.Application;
import switch2020.project.model.Family;

import static org.junit.jupiter.api.Assertions.*;

class AddRelationControllerTest {

    @Test
    void InstantiationOfAddRelationController() {
        Application application = new Application();

        AddRelationController addRelationController = new AddRelationController(application);

        assertNotNull(addRelationController);
    }

    /*@Test
    void AddRelation() {
        int selfID = 1;
        int otherID = 2;
        String relationDesignation = "Father";
        int familyID = 1;

        Family family = new Family(familyID);
        family.
        Application application = new Application();


        AddRelationController addRelationController = new AddRelationController(application);

        addRelationController.createRelation(selfID, otherID, relationDesignation, familyID);
    }*/
}