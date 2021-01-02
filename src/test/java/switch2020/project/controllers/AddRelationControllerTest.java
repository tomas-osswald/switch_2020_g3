package switch2020.project.controllers;

import org.junit.jupiter.api.Test;

import switch2020.project.model.Application;

import static org.junit.jupiter.api.Assertions.*;

class AddRelationControllerTest {

    @Test
    void InstantiationOfAddRelationController() {
        Application application = new Application();

        AddRelationController addRelationController = new AddRelationController(application);

        assertNotNull(addRelationController);
    }
}