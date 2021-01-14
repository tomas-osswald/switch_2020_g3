package switch2020.project.controllers;

import org.junit.jupiter.api.Test;

import switch2020.project.domain.model.Application;
import switch2020.project.domain.services.FamilyService;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AddRelationControllerTest {

    String cc = "110142608ZZ0";
    String name = "Diogo";
    Date date = new Date(1990, 8, 26);
    int numero = 919999999;
    String email = "diogo@gmail.com";
    int nif = 212122230;
    String rua = "Rua Nossa";
    String codPostal = "4444-555";
    String local = "Zinde";
    String city = "Porto";

    String cc2 = "137843828ZX3";
    String name2 = "Tony";
    Date date2 = new Date(1954, 8, 26);
    int numero2 = 919999998;
    String email2 = "tony@gmail.com";
    int nif2 = 212122000;
    String rua2 = "Rua";
    String codPostal2 = "4444-556";
    String local2 = "Gaia";
    String city2 = "Porto";

    String cc3 = "000000000ZZ4";
    String name3 = "Tony";
    Date date3 = new Date(1994, 8, 26);
    int numero3 = 919999998;
    String email3 = "toy@gmail.com";
    int nif3 = 212122100;
    String rua3 = "Rua";
    String codPostal3 = "4124-556";
    String local3 = "Gaia";
    String city3 = "Porto";

    String familyOneName = "Simpson";
    int familyOneIDGenerated = 1;

    @Test
    void InstantiationOfAddRelationController() {
        Application application = new Application();

        AddRelationController addRelationController = new AddRelationController(application);

        assertNotNull(addRelationController);
    }

    @Test
    void AddRelationTrue() {
        String relationDesignation = "Father";

        Application application = new Application();

        FamilyService familyService = application.getFamilyService();
        familyService.addFamily(familyOneName);
        familyService.addFamilyAdministrator(cc, name, date, numero, email, nif, rua, codPostal, local, city, familyOneIDGenerated);
        familyService.addFamilyMember(cc, cc2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, familyOneIDGenerated);

        AddRelationController addRelationController = new AddRelationController(application);

        assertTrue(addRelationController.createRelation(cc, cc2, relationDesignation, familyOneIDGenerated));
    }

    @Test
    void AddRelationFalseNoAdministrator() {
        String relationDesignation = "Father";

        Application application = new Application();

        FamilyService familyService = application.getFamilyService();
        familyService.addFamily(familyOneName);

        familyService.addFamilyAdministrator(cc, name, date, numero, email, nif, rua, codPostal, local, city, familyOneIDGenerated);
        familyService.addFamilyMember(cc, cc2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, familyOneIDGenerated);
        familyService.addFamilyMember(cc, cc3, name3, date3, numero3, email3, nif3, rua3, codPostal3, local3, city3, familyOneIDGenerated);

        AddRelationController addRelationController = new AddRelationController(application);

        assertFalse(addRelationController.createRelation(cc2, cc3, relationDesignation, familyOneIDGenerated));
    }

    @Test
    void AddRelationFalseCatchEmptyRelationDesignationThrow() {
        String relationDesignation = "";

        Application application = new Application();

        FamilyService familyService = application.getFamilyService();
        familyService.addFamily(familyOneName);
        familyService.addFamilyAdministrator(cc, name, date, numero, email, nif, rua, codPostal, local, city, familyOneIDGenerated);
        familyService.addFamilyMember(cc, cc2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, familyOneIDGenerated);

        AddRelationController addRelationController = new AddRelationController(application);

        assertFalse(addRelationController.createRelation(cc, cc2, relationDesignation, familyOneIDGenerated));
    }
}