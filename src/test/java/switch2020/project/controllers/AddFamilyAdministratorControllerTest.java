package switch2020.project.controllers;

import org.junit.jupiter.api.Test;
import switch2020.project.model.Application;
import switch2020.project.model.Family;
import switch2020.project.model.Relation;
import switch2020.project.services.FamilyService;
import switch2020.project.utils.FamilyWithoutAdministratorDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddFamilyAdministratorControllerTest {

    String ccNumber = "000000000ZZ4";
    String name = "Diogo";
    Date date = new Date(1990, 8, 26);
    int numero = 919999999;
    String email = "abc@gmail.com";
    int nif = 212122233;
    String rua = "Rua Nossa";
    String codPostal = "4444-555";
    String local = "Zinde";
    String city = "Porto";

    /*@Test
    void familiesWithoutAdministratorList() {
        Application application = new Application();

        AddFamilyController controller = new AddFamilyController(application);
        controller.addFamily(); // id1
        controller.addFamily(); // id2

        AddFamilyAdministratorController addFamilyAdministratorController = new AddFamilyAdministratorController(application);
        addFamilyAdministratorController.addFamilyAdministrator(); // to family 1

        List<FamilyWithoutAdministratorDTO> expected = new ArrayList<>();
        FamilyWithoutAdministratorDTO dto1 = new FamilyWithoutAdministratorDTO();
        expected.add(dto1);

        List<FamilyWithoutAdministratorDTO> result = addFamilyAdministratorController.familiesWithoutAdministrator();

        assertEquals(result, expected);
    }

    @Test
    void familiesWithoutAdministratorEmptyList() {
        Application application = new Application();

        AddFamilyController controller = new AddFamilyController(application);
        controller.addFamily(); // id1
        controller.addFamily(); // id2

        AddFamilyAdministratorController addFamilyAdministratorController = new AddFamilyAdministratorController(application);
        addFamilyAdministratorController.addFamilyAdministrator(); // to family 1
        addFamilyAdministratorController.addFamilyAdministrator(); // to family 2

        List<FamilyWithoutAdministratorDTO> expected = new ArrayList<>();

        List<FamilyWithoutAdministratorDTO> result = addFamilyAdministratorController.familiesWithoutAdministrator();

        assertEquals(result, expected);

    }*/

    @Test
    void addFamilyAdministrator() {
        Family ribeiro = new Family("Ribeiro",1);
        Application ffmApp = new Application(ribeiro);
        AddFamilyAdministratorController controller = new AddFamilyAdministratorController(ffmApp);
        assertTrue(controller.addFamilyAdministrator(ccNumber,name,date,numero,email,nif,rua,codPostal,local,city,1));
    }

    @Test
    void NotAddFamilyAdministrator() {
        Family ribeiro = new Family("Ribeiro",1);
        Application ffmApp = new Application(ribeiro);
        AddFamilyAdministratorController controller = new AddFamilyAdministratorController(ffmApp);
        assertFalse(controller.addFamilyAdministrator(ccNumber,name,date,numero,email,nif,rua,codPostal,local,city,2));
    }
}