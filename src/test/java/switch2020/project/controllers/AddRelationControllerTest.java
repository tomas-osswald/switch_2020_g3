package switch2020.project.controllers;

import org.junit.jupiter.api.Test;

import switch2020.project.controllers.AddRelationController;
import switch2020.project.model.Application;
import switch2020.project.model.Family;
import switch2020.project.model.FamilyMember;
import switch2020.project.services.FamilyService;

import static org.junit.jupiter.api.Assertions.*;

class AddRelationControllerTest {

    @Test
    void InstantiationOfAddRelationController() {
        Application application = new Application();

        AddRelationController addRelationController = new AddRelationController(application);

        assertNotNull(addRelationController);
    }

    @Test
    void AddRelationTrue() {
        int selfID = 1;
        int otherID = 2;
        String relationDesignation = "Father";
        int familyID = 1;

        FamilyMember familyMember1 = new FamilyMember(selfID);
        FamilyMember familyMember2 = new FamilyMember(otherID);
        familyMember1.makeAdmin();

        Family family = new Family(familyID);
        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);

        Application application = new Application();
        application.getFamilyService().addFamily(family);

        AddRelationController addRelationController = new AddRelationController(application);

        assertTrue(addRelationController.createRelation(selfID, otherID, relationDesignation, familyID));
    }

    @Test
    void AddRelationFalseNoAdmin() {
        int selfID = 1;
        int otherID = 2;
        String relationDesignation = "Father";
        int familyID = 1;

        FamilyMember familyMember1 = new FamilyMember(selfID);
        FamilyMember familyMember2 = new FamilyMember(otherID);

        Family family = new Family(familyID);
        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);

        Application application = new Application();
        application.getFamilyService().addFamily(family);

        AddRelationController addRelationController = new AddRelationController(application);

        assertFalse(addRelationController.createRelation(selfID, otherID, relationDesignation, familyID));
    }

    @Test
    void AddRelationFalseCatchEmptyRelationDesignationThrow() {
        int selfID = 1;
        int otherID = 2;
        String relationDesignation = "";
        int familyID = 1;

        FamilyMember familyMember1 = new FamilyMember(selfID);
        FamilyMember familyMember2 = new FamilyMember(otherID);
        familyMember1.makeAdmin();

        Family family = new Family(familyID);
        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);

        Application application = new Application();
        application.getFamilyService().addFamily(family);

        AddRelationController addRelationController = new AddRelationController(application);

        assertFalse(addRelationController.createRelation(selfID, otherID, relationDesignation, familyID));
    }
}