package switch2020.project.controllers;

import org.junit.jupiter.api.Test;
import switch2020.project.model.Application;
import switch2020.project.model.Family;
import switch2020.project.model.FamilyMember;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CreateFamilyCashAccountControllerTest {

    @Test
    void instantiationOfCreateFamilyCashAccountController() {
        Application app = new Application();

        CreateFamilyCashAccountController controller = new CreateFamilyCashAccountController(app);

        assertNotNull(controller);
    }

    @Test
    void createFamilyCashAccountSuccessNoExistingAccount() {
        int selfID = 1;
        FamilyMember admin = new FamilyMember(selfID);
        admin.makeAdmin();
        Application app = new Application();
        CreateFamilyCashAccountController controller = new CreateFamilyCashAccountController(app);
        int familyID = 1;
        String familyName = "Moura";
        boolean expected = true;
        Family aFamily = new Family(familyName, familyID);
        app.getFamilyService().addFamily(aFamily);
        double balance = 0;

        boolean result = controller.createFamilyCashAccount(familyID, balance, selfID);

        assertEquals(expected, result);
    }

    @Test
    void createFamilyCashAccountFailureAlreadyExistingAccount() {
        int selfID = 1;
        FamilyMember admin = new FamilyMember(selfID);
        admin.makeAdmin();
        Application app = new Application();
        CreateFamilyCashAccountController controller = new CreateFamilyCashAccountController(app);
        int familyID = 1;
        String familyName = "Moura";
        boolean expected = false;
        Family aFamily = new Family(familyName, familyID);
        app.getFamilyService().addFamily(aFamily);
        double balance = 0;
        controller.createFamilyCashAccount(familyID, balance, selfID);

        boolean result = controller.createFamilyCashAccount(familyID, balance, selfID);

        assertEquals(expected, result);
    }
}