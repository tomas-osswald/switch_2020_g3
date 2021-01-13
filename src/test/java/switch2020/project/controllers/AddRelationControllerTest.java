package switch2020.project.controllers;

import org.junit.jupiter.api.Test;

import switch2020.project.controllers.AddRelationController;
import switch2020.project.model.Application;
import switch2020.project.model.Family;
import switch2020.project.model.FamilyMember;
import switch2020.project.services.FamilyService;

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
    String relacao = "filho";
    boolean admin = false;

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
    String relacao2 = "primo";
    boolean admin2 = false;

    @Test
    void InstantiationOfAddRelationController() {
        Application application = new Application();

        AddRelationController addRelationController = new AddRelationController(application);

        assertNotNull(addRelationController);
    }

    @Test
    void AddRelationTrue() {
        String selfID = "110142608ZZ0";
        String otherID = "137843828ZX3";

        String relationDesignation = "Father";
        int familyID = 1;
        String familyName = "Moura";

        FamilyMember familyMember1 = new FamilyMember(cc,name,date,numero,email,nif,rua,codPostal,local, city, admin);
        FamilyMember familyMember2 = new FamilyMember(cc2,name2,date2,numero2,email2,nif2,rua2,codPostal2,local2, city2, admin2);
        familyMember1.makeAdmin();

        Family family = new Family(familyName, familyID);
        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);

        Application application = new Application();
        application.getFamilyService().addFamily(family);

        AddRelationController addRelationController = new AddRelationController(application);

        assertTrue(addRelationController.createRelation(selfID, otherID, relationDesignation, familyID));
    }

    @Test
    void AddRelationFalseNoAdmin() {
        String selfID = "110142608ZZ0";
        String otherID = "137843828ZX3";

        String relationDesignation = "Father";
        int familyID = 1;
        String familyName = "Moura";

        FamilyMember familyMember1 = new FamilyMember(cc,name,date,numero,email,nif,rua,codPostal,local, city, admin);
        FamilyMember familyMember2 = new FamilyMember(cc2,name2,date2,numero2,email2,nif2,rua2,codPostal2,local2, city2, admin2);

        Family family = new Family(familyName, familyID);
        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);

        Application application = new Application();
        application.getFamilyService().addFamily(family);

        AddRelationController addRelationController = new AddRelationController(application);

        assertFalse(addRelationController.createRelation(selfID, otherID, relationDesignation, familyID));
    }

    @Test
    void AddRelationFalseCatchEmptyRelationDesignationThrow() {
        String selfID = "110142608ZZ0";
        String otherID = "137843828ZX3";

        String relationDesignation = "";
        int familyID = 1;
        String familyName = "Moura";

        FamilyMember familyMember1 = new FamilyMember(cc,name,date,numero,email,nif,rua,codPostal,local, city, admin);
        FamilyMember familyMember2 = new FamilyMember(cc2,name2,date2,numero2,email2,nif2,rua2,codPostal2,local2, city2, admin2);

        familyMember1.makeAdmin();

        Family family = new Family(familyName, familyID);
        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);

        Application application = new Application();
        application.getFamilyService().addFamily(family);

        AddRelationController addRelationController = new AddRelationController(application);

        assertFalse(addRelationController.createRelation(selfID, otherID, relationDesignation, familyID));
    }
}