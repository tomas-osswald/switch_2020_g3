package switchtwentytwenty.project.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.DTOs.MoneyValue;
import switchtwentytwenty.project.domain.DTOs.input.AddCashAccountDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.accounts.Account;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.FamilyService;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class GetAccountBalanceControllerTest {

    Application ffmApp = new Application();
    AddFamilyController addFamilyController = new AddFamilyController(ffmApp);
    AddFamilyAdministratorController addFamilyAdministratorController = new AddFamilyAdministratorController(ffmApp);
    AddBankAccountController addBankAccountController = new AddBankAccountController(ffmApp);
    GetAccountBalanceController getAccountBalanceController = new GetAccountBalanceController(ffmApp);

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


    double balanceAmount = 0.6;
    double negativeBalance = -2;
    String accountName = "Current";
    MoneyValue accountBalance = new MoneyValue(balanceAmount, CurrencyEnum.EURO);

    @BeforeEach
    void setUp() {

        addFamilyController.addFamily("Ribeiro");
        addFamilyAdministratorController.addFamilyAdministrator(cc, name, date, numero, email, nif, rua, codPostal, local, city, 1);
        addBankAccountController.addBankAccount(accountName, 1, cc, balanceAmount);
    }

    @Test
    void getAccountBalanceTest1_Success() {
        double expected = 0.6;

        double result = getAccountBalanceController.getAccountBalance(1, cc, 1);

        Assertions.assertEquals(expected, result, 0.01);
    }
    @Test
    void getAccountBalanceTest2_NotEquals() {

        //expected value is purposefully incorrect
        double expected = 0.9;

        double result = getAccountBalanceController.getAccountBalance(1, cc, 1);

        Assertions.assertNotEquals(expected, result, 0.01);
    }

    //adicionar testes para todos os tipos de contas
    //adicionar testes para moneyvalue quando estiver tudo adicionado

}