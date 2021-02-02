package switchtwentytwenty.project.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.input.AddCreditCardAccountDTO;
import switchtwentytwenty.project.domain.dtos.input.AddFamilyMemberDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.services.FamilyService;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AddCreditCardAccountControllerTest {

    Application app = new Application();
    FamilyService familyService = app.getFamilyService();

    AddCreditCardAccountController addCreditCardAccountController = new AddCreditCardAccountController(app);


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

    String id2 = "166699209ZY8";
    String name2 = "Tony";
    Date date2 = new Date(1954, 8, 26);
    int numero2 = 919999998;
    String email2 = "tony@gmail.com";
    int nif2 = 212122000;
    String rua2 = "Rua";
    String codPostal2 = "4444-556";
    String local2 = "Gaia";
    String city2 = "Porto";

    int family1ID = 1;

    AddFamilyMemberDTO familyMemberDTO = new AddFamilyMemberDTO(cc,id2,name2,date2,numero2,email2,nif2,rua2,codPostal2,local2,city2,family1ID);

    @BeforeEach
    void setup() {
        familyService.addFamily("Silva");
        familyService.addFamilyAdministrator(cc, name, date, numero, email, nif, rua, codPostal, local, city, family1ID);
        familyService.addFamilyMember(familyMemberDTO);
    }

    @Test
    void addCreditCardAccountToFamilyMemberTrue() {
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(id2, family1ID, "Visa do Diogo", 5000.00, 100.00, 50.00, CurrencyEnum.EURO);
        assertTrue(addCreditCardAccountController.addCreditCardAccountToFamilyMember(addCreditCardAccountDTO));
    }

    @Test
    void addCreditCardAccountToFamilyMemberTrueWithCardDescriptionNull() {
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(id2, family1ID, null, 5000.00, 100.00, 50.00, CurrencyEnum.EURO);
        assertTrue(addCreditCardAccountController.addCreditCardAccountToFamilyMember(addCreditCardAccountDTO));
    }

    @Test
    void addCreditCardAccountToFamilyMemberFalseFamilyDoesNotExist() {
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(id2, 2, "MasterCard do Diogo", 5000.00, 100.00, 50.00, CurrencyEnum.EURO);
        assertFalse(addCreditCardAccountController.addCreditCardAccountToFamilyMember(addCreditCardAccountDTO));
    }

    @Test
    void addCreditCardAccountToFamilyMemberFalseFamilyMemberDoesNotExist() {
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO("3", family1ID, "MasterCard do Diogo", 5000.00, 100.00, 50.00, CurrencyEnum.EURO);
        assertFalse(addCreditCardAccountController.addCreditCardAccountToFamilyMember(addCreditCardAccountDTO));
    }
}