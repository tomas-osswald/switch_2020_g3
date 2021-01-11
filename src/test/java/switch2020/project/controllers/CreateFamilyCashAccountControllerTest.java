package switch2020.project.controllers;

import org.junit.jupiter.api.Test;
import switch2020.project.model.Application;
import switch2020.project.model.Family;

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
        Application app = new Application();
        CreateFamilyCashAccountController controller = new CreateFamilyCashAccountController(app);
        int familyID = 1;
        String familyName = "Moura";
        boolean expected = true;
        Family aFamily = new Family(familyName, familyID);
        app.getFamilyService().addFamily(aFamily);

        boolean result = controller.createFamilyCashAccount(familyID);

        assertEquals(expected, result);
    }

    @Test
    void createFamilyCashAccountFailureAlreadyExistingAccount() {
        Application app = new Application();
        CreateFamilyCashAccountController controller = new CreateFamilyCashAccountController(app);
        int familyID = 1;
        String familyName = "Moura";
        boolean expected = false;
        Family aFamily = new Family(familyName, familyID);
        app.getFamilyService().addFamily(aFamily);
        controller.createFamilyCashAccount(familyID);

        boolean result = controller.createFamilyCashAccount(familyID);

        assertEquals(expected, result);
    }
}