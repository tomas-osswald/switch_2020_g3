package switchtwentytwenty.project.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.input.AddCashAccountDTO;
import switchtwentytwenty.project.domain.dtos.input.AddFamilyMemberDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.Date;

class CreatePersonalCashAccountControllerTest {

    Application ffmApp = new Application();
    AddFamilyController addFamilyController = new AddFamilyController(ffmApp);
    AddFamilyAdministratorController addFamilyAdministratorController = new AddFamilyAdministratorController(ffmApp);
    CreatePersonalCashAccountController createPersonalCashAccountController = new CreatePersonalCashAccountController(ffmApp);

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
    String relacao = "filho";


    double balance = 0.6;
    double negativeBalance = -2;
    String accountName = "Savings";
    AddCashAccountDTO addCashAccountDTO = new AddCashAccountDTO(balance, accountName, cc, 1, CurrencyEnum.EURO);
    AddCashAccountDTO addCashAccountDTOnegativeBalance = new AddCashAccountDTO(negativeBalance, accountName, cc, 1, CurrencyEnum.EURO);
    AddCashAccountDTO addCashAccountDTOBlankName = new AddCashAccountDTO(balance, "   ", cc, 1, CurrencyEnum.EURO);
    AddCashAccountDTO addCashAccountDTOEmptyName = new AddCashAccountDTO(balance, "", cc, 1, CurrencyEnum.EURO);

    AddFamilyMemberDTO familyMemberDTO = new AddFamilyMemberDTO(cc,cc, name, date, numero, email, nif, rua, codPostal, local, city, 1);

    @BeforeEach
    void setup() {

        addFamilyController.addFamily("Ribeiro");
        addFamilyAdministratorController.addFamilyAdministrator(familyMemberDTO);

    }

    @Test
    void createPersonalCashAccount() {
        Assertions.assertTrue(createPersonalCashAccountController.createPersonalCashAccount(addCashAccountDTO));

    }

    @Test
    void createTwoPersonalCashAccounts() {
        createPersonalCashAccountController.createPersonalCashAccount(addCashAccountDTO);
        Assertions.assertTrue(createPersonalCashAccountController.createPersonalCashAccount(addCashAccountDTO));

    }

    @Test
    void createPersonalCashAccountNegativeBalance() {
        Assertions.assertFalse(createPersonalCashAccountController.createPersonalCashAccount(addCashAccountDTOnegativeBalance));

    }

    @Test
    void createPersonalCashAccountBlankName() {
        Assertions.assertTrue(createPersonalCashAccountController.createPersonalCashAccount(addCashAccountDTOBlankName));

    }

    @Test
    void createPersonalCashAccountEmptyName() {
        Assertions.assertTrue(createPersonalCashAccountController.createPersonalCashAccount(addCashAccountDTOEmptyName));

    }

    @Test
    void createPersonalCashInvalidFamily() {
        int familyID = 100;
        AddCashAccountDTO addCashAccountDTOInvalidFamily = new AddCashAccountDTO(negativeBalance, accountName, cc, familyID, CurrencyEnum.EURO);


        Assertions.assertFalse(createPersonalCashAccountController.createPersonalCashAccount(addCashAccountDTOInvalidFamily));
    }

/*
    @Test
    void createPersonalCashAccountNullName() {
        Assertions.assertFalse(createPersonalCashAccountController.createPersonalCashAccount(1, cc, null, balance));

    }

    @Test
    void createPersonalCashAccountLongName() {
        Assertions.assertFalse(createPersonalCashAccountController.createPersonalCashAccount(1, cc, "iamaverylongaccountname", balance));

    }

 */
}