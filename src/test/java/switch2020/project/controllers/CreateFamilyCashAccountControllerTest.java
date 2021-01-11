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
        boolean expected = true;
        Family aFamily = new Family(familyID);
        app.getFamilyService().addFamily(aFamily);
        double balance = 0;

        boolean result = controller.createFamilyCashAccount(familyID, balance);

        assertEquals(expected, result);
    }

    @Test
    void createFamilyCashAccountFailureAlreadyExistingAccount() {
        Application app = new Application();
        CreateFamilyCashAccountController controller = new CreateFamilyCashAccountController(app);
        int familyID = 1;
        boolean expected = false;
        Family aFamily = new Family(familyID);
        app.getFamilyService().addFamily(aFamily);
        double balance = 0;
        controller.createFamilyCashAccount(familyID, balance);

        boolean result = controller.createFamilyCashAccount(familyID, balance);

        assertEquals(expected, result);
    }
}