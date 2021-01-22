package switch2020.project.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import switch2020.project.domain.model.Application;
import switch2020.project.domain.model.Relation;

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
    Relation relation = new Relation(relacao);

    double balance = 0.6;
    double negativeBalance = -2;
    String accountName = "Savings";

    @BeforeEach
    void setup() {

        addFamilyController.addFamily("Ribeiro");
        addFamilyAdministratorController.addFamilyAdministrator(cc, name, date, numero, email, nif, rua, codPostal, local, city, 1);
    }

    @Test
    void createPersonalCashAccount() {
        Assertions.assertTrue(createPersonalCashAccountController.createPersonalCashAccount(accountName, 1, cc, balance));

    }

    @Test
    void createTwoPersonalCashAccounts() {
        createPersonalCashAccountController.createPersonalCashAccount(accountName, 1, cc, balance);
        Assertions.assertTrue(createPersonalCashAccountController.createPersonalCashAccount(accountName, 1, cc, balance));

    }

    @Test
    void createPersonalCashAccountNegativeBalance() {
        Assertions.assertFalse(createPersonalCashAccountController.createPersonalCashAccount(accountName, 1, cc, negativeBalance));

    }

    @Test
    void createPersonalCashAccountBlankName() {
        Assertions.assertFalse(createPersonalCashAccountController.createPersonalCashAccount(" ", 1, cc, negativeBalance));

    }

    @Test
    void createPersonalCashAccountEmptyName() {
        Assertions.assertFalse(createPersonalCashAccountController.createPersonalCashAccount("", 1, cc, negativeBalance));

    }

    @Test
    void createPersonalCashAccountNullName() {
        Assertions.assertFalse(createPersonalCashAccountController.createPersonalCashAccount(null, 1, cc, negativeBalance));

    }

    @Test
    void createPersonalCashAccountLongName() {
        Assertions.assertFalse(createPersonalCashAccountController.createPersonalCashAccount("iamaverylongaccountname", 1, cc, negativeBalance));

    }
}