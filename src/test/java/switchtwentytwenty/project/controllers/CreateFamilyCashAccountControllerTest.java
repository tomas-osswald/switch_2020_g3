package switchtwentytwenty.project.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CreateFamilyCashAccountControllerTest {

    String cc = "135149126ZW9";
    String name = "Diogo";
    Date date = new Date(1990, 8, 26);
    int numero = 919999999;
    String email = "diogo@gmail.com";
    int nif = 212122230;
    String rua = "Rua Nossa";
    String codPostal = "4444-555";
    String local = "Zinde";
    String city = "Porto";

    @Test
    void instantiationOfCreateFamilyCashAccountController() {
        Application app = new Application();

        CreateFamilyCashAccountController controller = new CreateFamilyCashAccountController(app);

        assertNotNull(controller);
    }

    @Test
    void createFamilyCashAccountSuccessNoExistingAccount() {
        FamilyMember admin = new FamilyMember(cc,name,date,numero,email,nif,rua,codPostal,local,city);
        admin.makeAdmin();

        Application app = new Application();
        CreateFamilyCashAccountController controller = new CreateFamilyCashAccountController(app);

        int familyID = 1;
        String familyName = "Moura";
        Family aFamily = new Family(familyName, familyID);
        app.getFamilyService().addFamily(aFamily);
        aFamily.addFamilyMember(admin);

        double balance = 0;
        String accountDesignation = "Conta familia Moura";

        boolean result = controller.createFamilyCashAccount(familyID,accountDesignation, balance, cc);

        Assertions.assertTrue(result);
    }

    @Test
    void createFamilyCashAccountFailureAlreadyExistingAccount() {
        FamilyMember admin = new FamilyMember(cc,name,date,numero,email,nif,rua,codPostal,local,city);
        admin.makeAdmin();

        Application app = new Application();
        CreateFamilyCashAccountController controller = new CreateFamilyCashAccountController(app);

        int familyID = 1;
        String familyName = "Moura";
        Family aFamily = new Family(familyName, familyID);
        app.getFamilyService().addFamily(aFamily);
        aFamily.addFamilyMember(admin);

        double balance = 0;
        String accountDesignation = "Conta familia Moura";

        controller.createFamilyCashAccount(familyID,accountDesignation, balance, cc);

        boolean result = controller.createFamilyCashAccount(familyID,accountDesignation, balance, cc);

        Assertions.assertFalse(result);
    }

    @Test
    void createFamilyCashAccountFailureTryCatchNegativeBalance() {
        FamilyMember admin = new FamilyMember(cc,name,date,numero,email,nif,rua,codPostal,local,city);
        admin.makeAdmin();

        Application app = new Application();
        CreateFamilyCashAccountController controller = new CreateFamilyCashAccountController(app);

        int familyID = 1;
        String familyName = "Moura";
        Family aFamily = new Family(familyName, familyID);
        app.getFamilyService().addFamily(aFamily);
        aFamily.addFamilyMember(admin);

        double balance = -10;
        String accountDesignation = "Conta familia Moura";

        boolean result = controller.createFamilyCashAccount(familyID,accountDesignation, balance, cc);

        Assertions.assertFalse(result);
    }

    @Test
    void createFamilyCashAccountFailureNotAdmin() {
        FamilyMember admin = new FamilyMember(cc,name,date,numero,email,nif,rua,codPostal,local,city);

        Application app = new Application();
        CreateFamilyCashAccountController controller = new CreateFamilyCashAccountController(app);

        int familyID = 1;
        String familyName = "Moura";
        Family aFamily = new Family(familyName, familyID);
        app.getFamilyService().addFamily(aFamily);
        aFamily.addFamilyMember(admin);

        double balance = 0;
        String accountDesignation = "Conta familia Moura";

        boolean result = controller.createFamilyCashAccount(familyID,accountDesignation, balance, cc);

        Assertions.assertFalse(result);
    }
}