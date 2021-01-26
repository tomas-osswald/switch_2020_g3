package switch2020.project.domain.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import switch2020.project.domain.model.FamilyMember;
import switch2020.project.domain.model.Relation;
import java.util.Date;
import switch2020.project.controllers.AddFamilyAdministratorController;
import switch2020.project.controllers.AddFamilyController;
import switch2020.project.domain.model.Application;
import switch2020.project.domain.model.FamilyMember;
import switch2020.project.domain.model.Relation;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountServiceTest {


    String id = "000000000ZZ4";
    String name = "Diogo";
    Date date = new Date(1990,8,12);
    int numero = 919999999;
    String emailTwo = "abc@gmail.com";

    Application ffmApp = new Application();
    AddFamilyController addFamilyController = new AddFamilyController(ffmApp);
    AddFamilyAdministratorController addFamilyAdministratorController = new AddFamilyAdministratorController(ffmApp);
    AccountService accountService = new AccountService();

    String cc = "000000000ZZ4";
    String nameTwo = "Diogo";
    Date dateTwo = new Date(1990, 8, 26);
    Integer numeroTwo = 919999999;
    String email = "josediogoccbr@gmail.com";

    int nif = 212122233;
    String rua = "Rua Nossa";
    String codPostal = "4444-555";
    String local = "Zinde";
    String city = "Porto";
    String relacao = "filho";
    Relation relation = new Relation(relacao);

    boolean admin = false;

    //Added 2nd FamilyMember to test
    String id2 = "137843828ZX3";
    String name2 = "Tony";
    Date date2 = new Date(1954,8, 12);
    int numero2 = 919999998;
    String email2 = "tony@gmail.com";
    int nif2 = 212122000;
    String rua2 = "Rua";
    String codPostal2 = "4444-556";
    String local2 = "Gaia";
    String city2 = "Porto";
    String relacao2 = "primo";
    Relation relation2 = new Relation(relacao2);
    boolean admin2 = false;

    //Added 3rd FamilyMember to test
    String id3 = "137476450ZX0";
    String name3 = "TonyZe";
    Date date3 = new Date(1955,8,1);
    int numero3 = 919939998;
    String email3 = "tonyze@gmail.com";
    int nif3 = 212122000;
    String rua3 = "Rua";
    String codPostal3 = "4444-556";
    String local3 = "Gaia";
    String city3 = "Porto";
    String relacao3 = "primo";
    Relation relation3 = new Relation(relacao3);
    boolean admin3 = true;

    //DTO Test Setup
    FamilyMember diogo = new FamilyMember(id, name, date, numero, email, nif, rua, codPostal, local, city, admin);
    FamilyMember jorge = new FamilyMember(id2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, admin2);
    FamilyMember manuelAdminMasterInTheHousesOfTheNightOfTheBicepsWithMyFamily = new FamilyMember(id3, name3, date3, numero3, email3, nif3, rua3, codPostal3, local3, city3, admin3);

    double balance = 0.6;
    double negativeBalance = -2;
    String accountName = "Current Account";
    String accountName2 = "Other Current Account";

    @BeforeEach
    void setup() {

        addFamilyController.addFamily("Ribeiro");
    }

    @Test
    void addBankSavingsAccountAddedSuccessfullyWithNullInput() {
        String accountName = "Savings Account";
        Double balance = null;
        Double interestRate = null;

        assertTrue(accountService.addBankSavingsAccount(diogo, accountName, balance, interestRate));
    }

    @Test
    void addBankSavingsAccountAddedSuccessfullyWithRegularInput() {
        String accountName = "Savings Account";
        Double balance = 1.01;
        Double interestRate = -4.21;

        assertTrue(accountService.addBankSavingsAccount(diogo, accountName, balance, interestRate));
    }


    @Test
    void addBankAccountTest1_Success() {
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        assertTrue(accountService.addBankAccount(diogo, accountName, balance));
    }
    @Test
    void addBankAccountTest2_Failure() {
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        Assertions.assertFalse(accountService.addBankAccount(diogo, accountName, null));
    }
    @Test
    void addBankAccountTest3_AddTwoBankAccountsSuccess() {
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        accountService.addBankAccount(diogo, accountName, balance);
        assertTrue(accountService.addBankAccount(diogo, accountName, negativeBalance));
    }

    @Test
    void createPersonalCreditCardAccountTrue() {
    }

    @Test
    void createPersonalCreditCardAccountAssertThrowInvalidWithrawalLimit() {
    }
}