package switch2020.project.domain.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import switch2020.project.controllers.AddFamilyAdministratorController;
import switch2020.project.controllers.AddFamilyController;
import switch2020.project.domain.model.Application;
import switch2020.project.domain.model.FamilyMember;
import switch2020.project.domain.model.Relation;

import java.util.Date;

class AccountServiceTest {

    Application ffmApp = new Application();
    AddFamilyController addFamilyController = new AddFamilyController(ffmApp);
    AddFamilyAdministratorController addFamilyAdministratorController = new AddFamilyAdministratorController(ffmApp);
    AccountService accountService = new AccountService();

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
    }

    @Test
    void addBankAccountTest1_Success() {
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        Assertions.assertTrue(accountService.addBankAccount(diogo, accountName, balance));
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
        Assertions.assertTrue(accountService.addBankAccount(diogo, accountName, negativeBalance));
    }
    @Test
    void createPersonalCreditCardAccountTrue() {
    }

    @Test
    void createPersonalCreditCardAccountAssertThrowInvalidWithrawalLimit() {
    }
}