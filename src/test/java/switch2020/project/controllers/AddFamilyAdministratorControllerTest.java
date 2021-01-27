package switch2020.project.controllers;

import org.junit.jupiter.api.Test;
import switch2020.project.domain.model.Application;
import switch2020.project.domain.model.Family;
import switch2020.project.domain.DTOs.output.FamilyWithoutAdministratorDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddFamilyAdministratorControllerTest {

    String familyOneName = "Simpson";
    String familyTwoName = "Flanders";
    int familyOneIDGenerated = 1;
    int familyTwoIDGenerated = 2;

    String cc = "143896040ZV3";
    String name = "Diogo";
    Date date = new Date(1990, 8, 26);
    int numero = 919999999;
    String email = "abc@gmail.com";
    int nif = 212122233;
    String rua = "Rua Nossa";
    String codPostal = "4444-555";
    String local = "Zinde";
    String city = "Porto";
    String relacao = "filho";


    String cc2 = "166699209ZY8";
    String name2 = "Tony";
    Date date2 = new Date(1954, 8, 26);
    int numero2 = 919999998;
    String email2 = "tony@gmail.com";
    int nif2 = 212122000;
    String rua2 = "Rua";
    String codPostal2 = "4444-556";
    String local2 = "Gaia";
    String city2 = "Porto";
    String relacao2 = "pai";


    @Test
    void familiesWithoutAdministratorList() {
        Application application = new Application();

        AddFamilyController controller = new AddFamilyController(application);
        controller.addFamily(familyOneName); // id1
        controller.addFamily(familyTwoName); // id2

        AddFamilyAdministratorController addFamilyAdministratorController = new AddFamilyAdministratorController(application);
        addFamilyAdministratorController.addFamilyAdministrator(cc,name,date, numero, email, nif, rua, codPostal, local, city, familyOneIDGenerated); // to family 1

        List<FamilyWithoutAdministratorDTO> expected = new ArrayList<>();
        FamilyWithoutAdministratorDTO dto1 = new FamilyWithoutAdministratorDTO(familyTwoName, familyTwoIDGenerated);
        expected.add(dto1);

        List<FamilyWithoutAdministratorDTO> result = addFamilyAdministratorController.familiesWithoutAdministrator();

        assertEquals(result, expected);
    }

    @Test
    void familiesWithoutAdministratorEmptyList() {
        Application application = new Application();

        AddFamilyController controller = new AddFamilyController(application);
        controller.addFamily(familyOneName); // id1
        controller.addFamily(familyTwoName); // id2

        AddFamilyAdministratorController addFamilyAdministratorController = new AddFamilyAdministratorController(application);
        addFamilyAdministratorController.addFamilyAdministrator(cc,name,date, numero, email, nif, rua, codPostal, local, city, familyOneIDGenerated); // to family 1
        addFamilyAdministratorController.addFamilyAdministrator(cc2,name2,date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, familyTwoIDGenerated); // to family 2

        List<FamilyWithoutAdministratorDTO> expected = new ArrayList<>();

        List<FamilyWithoutAdministratorDTO> result = addFamilyAdministratorController.familiesWithoutAdministrator();

        assertEquals(result, expected);
    }

    @Test
    void addFamilyAdministrator() {
        Family ribeiro = new Family("Ribeiro",1);
        Application ffmApp = new Application(ribeiro);
        AddFamilyAdministratorController controller = new AddFamilyAdministratorController(ffmApp);
        assertTrue(controller.addFamilyAdministrator(cc,name,date,numero,email,nif,rua,codPostal,local,city,1));
    }

    @Test
    void NotAddFamilyAdministrator() {
        Family ribeiro = new Family("Ribeiro",1);
        Application ffmApp = new Application(ribeiro);
        AddFamilyAdministratorController controller = new AddFamilyAdministratorController(ffmApp);
        assertFalse(controller.addFamilyAdministrator(cc,name,date,numero,email,nif,rua,codPostal,local,city,2));
    }
}