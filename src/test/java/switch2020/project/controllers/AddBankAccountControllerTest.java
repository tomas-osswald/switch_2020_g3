package switch2020.project.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import switch2020.project.domain.model.Application;
import switch2020.project.domain.model.Relation;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AddBankAccountControllerTest {

    Application ffmApp = new Application();
    AddFamilyController addFamilyController = new AddFamilyController(ffmApp);
    AddFamilyAdministratorController addFamilyAdministratorController = new AddFamilyAdministratorController(ffmApp);
    AddBankAccountController addBankAccountController = new AddBankAccountController(ffmApp);

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
    String accountName = "Current Account";
    String accountName2 = "Other Current Account";

    @BeforeEach
    void setup() {

        addFamilyController.addFamily("Ribeiro");
        addFamilyAdministratorController.addFamilyAdministrator(cc, name, date, numero, email, nif, rua, codPostal, local, city, 1);

    }
    @Test
    void addBankAccountTest1_Success() {
        Assertions.assertTrue(addBankAccountController.addBankAccount(accountName, 1, cc, balance));
    }
    @Test
    void addBankAccountTest2_NullNameSuccess() {
        Assertions.assertTrue(addBankAccountController.addBankAccount(null, 1, cc, balance));
    }
    @Test
    void addBankAccountTest3_BlankNameSuccess() {
        Assertions.assertTrue(addBankAccountController.addBankAccount("", 1, cc, balance));
    }
    @Test
    void addBankAccountTest4_NegativeBalanceSuccess() {
        Assertions.assertTrue(addBankAccountController.addBankAccount(accountName, 1, cc, negativeBalance));
    }
    @Test
    void addBankAccountTest5_AddTwoBankAccountsSuccess() {
        addBankAccountController.addBankAccount(accountName, 1, cc, balance);
        Assertions.assertTrue(addBankAccountController.addBankAccount(accountName2, 1, cc, balance));
    }
    @Test
    void addBankAccountTest6_NullBalanceFailure() {
        Assertions.assertFalse(addBankAccountController.addBankAccount(accountName, 1, cc, null));
    }
}