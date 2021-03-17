package switchtwentytwenty.project.controllers;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.input.AddFamilyMemberDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AddEmailControllerTest {
    String cc = "000000000ZZ4";
    String name = "Diogo";
    Date date = new Date(1990, 8, 26);
    Integer numero = 919999999;
    String email = "josediogoccbr@gmail.com";
    int nif = 212122233;
    String rua = "Rua Nossa";
    String codPostal = "4444-555";
    String local = "Zinde";
    String city = "Porto";

    AddFamilyMemberDTO familyMemberDTO = new AddFamilyMemberDTO(cc,cc, name, date, numero, email, nif, rua, codPostal, local, city,1);

    @Test
    void addEmailControllerSuccess() {
        Application app = new Application();
        AddFamilyController familyController = new AddFamilyController(app);
        AddFamilyAdministratorController addAdminController = new AddFamilyAdministratorController(app);
        AddEmailController controller = new AddEmailController(app);
        String newEmail = "1120717@google.com";
        //FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        familyController.addFamily("peido");
        addAdminController.addFamilyAdministrator(familyMemberDTO);
        assertTrue(controller.addEmail(newEmail, 1, cc));
    }

    @Test
    void addEmailControllerFail() {
        Application app = new Application();
        AddFamilyController familyController = new AddFamilyController(app);
        AddFamilyAdministratorController addAdminController = new AddFamilyAdministratorController(app);
        AddEmailController controller = new AddEmailController(app);
        String newEmail = "1120717@@@@@google.com";
        //FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        familyController.addFamily("peido");
        addAdminController.addFamilyAdministrator(familyMemberDTO);
        assertFalse(controller.addEmail(newEmail, 1, cc));
    }

}