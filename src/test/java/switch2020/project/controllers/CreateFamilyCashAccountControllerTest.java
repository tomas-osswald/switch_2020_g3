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
        String ccNumber = "000000000ZZ4";
        FamilyMember admin = new FamilyMember(ccNumber);
        admin.makeAdmin();

        Application app = new Application();
        CreateFamilyCashAccountController controller = new CreateFamilyCashAccountController(app);

        int familyID = 1;
        String familyName = "Moura";
        Family aFamily = new Family(familyName, familyID);
        app.getFamilyService().addFamily(aFamily);
        aFamily.addFamilyMember(admin);

        double balance = 0;
        boolean expected = true;

        boolean result = controller.createFamilyCashAccount(familyID, balance, ccNumber);

        assertEquals(expected, result);
    }

    @Test
    void createFamilyCashAccountFailureAlreadyExistingAccount() {
        String ccNumber = "000000000ZZ4";
        FamilyMember admin = new FamilyMember(ccNumber);
        admin.makeAdmin();

        Application app = new Application();
        CreateFamilyCashAccountController controller = new CreateFamilyCashAccountController(app);

        int familyID = 1;
        String familyName = "Moura";
        Family aFamily = new Family(familyName, familyID);
        app.getFamilyService().addFamily(aFamily);
        aFamily.addFamilyMember(admin);

        double balance = 0;
        boolean expected = false;

        controller.createFamilyCashAccount(familyID, balance, ccNumber);

        boolean result = controller.createFamilyCashAccount(familyID, balance, ccNumber);

        assertEquals(expected, result);
    }

    @Test
    void createFamilyCashAccountFailureTryCatchNegativeBalance() {
        String ccNumber = "000000000ZZ4";
        FamilyMember admin = new FamilyMember(ccNumber);
        admin.makeAdmin();

        Application app = new Application();
        CreateFamilyCashAccountController controller = new CreateFamilyCashAccountController(app);

        int familyID = 1;
        String familyName = "Moura";
        Family aFamily = new Family(familyName, familyID);
        app.getFamilyService().addFamily(aFamily);
        aFamily.addFamilyMember(admin);

        double balance = -10;
        boolean expected = false;

        boolean result = controller.createFamilyCashAccount(familyID, balance, ccNumber);

        assertEquals(expected, result);
    }
}