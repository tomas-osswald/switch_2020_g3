package switchtwentytwenty.project.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.input.AddBankAccountDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.FamilyMember;

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
        AddBankAccountDTO addBankAccountDTO = new AddBankAccountDTO(balance, accountName, cc, 1);
        assertTrue(addBankAccountController.addBankAccount(addBankAccountDTO));
    }

    @Test
    void addBankAccountTest1_Fail() {
        AddBankAccountDTO addBankAccountDTO = new AddBankAccountDTO(balance, accountName, cc, 100);//familyID doesn't exists'
        assertFalse(addBankAccountController.addBankAccount(addBankAccountDTO));
    }

    @Test
    void addBankAccountTest2_NullNameSuccess() {
        AddBankAccountDTO addBankAccountDTO = new AddBankAccountDTO(balance, null, cc, 1);//no accountName is given
        assertTrue(addBankAccountController.addBankAccount(addBankAccountDTO));
    }
    @Test
    void addBankAccountTest3_BlankNameSuccess() {
        AddBankAccountDTO addBankAccountDTO = new AddBankAccountDTO(balance, "  ", cc, 1);//accountName is blank
        assertTrue(addBankAccountController.addBankAccount(addBankAccountDTO));
    }
    @Test
    void addBankAccountTest4_NegativeBalanceSuccess() {
        AddBankAccountDTO addBankAccountDTO = new AddBankAccountDTO(negativeBalance, accountName, cc, 1);
        assertTrue(addBankAccountController.addBankAccount(addBankAccountDTO));
    }
    @Test
    void addBankAccountTest5_AddTwoBankAccountsSuccess() {
        AddBankAccountDTO addBankAccountDTO = new AddBankAccountDTO(balance, accountName, cc, 1);
        AddBankAccountDTO addBankAccountDTO2 = new AddBankAccountDTO(balance, accountName2, cc, 1);
        addBankAccountController.addBankAccount(addBankAccountDTO);
        assertTrue(addBankAccountController.addBankAccount(addBankAccountDTO2));
    }
    //TODO test for null balance - needed changes by Diogo to transform Null into 0
    /*@Test
    void addBankAccountTest6_NullBalanceSuccess() {
        AddBankAccountDTO addBankAccountDTO = new AddBankAccountDTO(null, accountName, cc, 1);
        assertTrue(addBankAccountController.addBankAccount(addBankAccountDTO));
    }*/
}