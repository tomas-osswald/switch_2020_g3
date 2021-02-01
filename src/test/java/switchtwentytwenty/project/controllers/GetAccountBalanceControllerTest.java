package switchtwentytwenty.project.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.dtos.input.AddCashAccountDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.Date;

class GetAccountBalanceControllerTest {

    Application ffmApp = new Application();
    AddFamilyController addFamilyController = new AddFamilyController(ffmApp);
    AddFamilyAdministratorController addFamilyAdministratorController = new AddFamilyAdministratorController(ffmApp);
    AddBankAccountController addBankAccountController = new AddBankAccountController(ffmApp);
    AddBankSavingsAccountController addBankSavingsAccountController = new AddBankSavingsAccountController(ffmApp);
    AddCreditCardAccountController addCreditCardAccountController = new AddCreditCardAccountController(ffmApp);
    CreatePersonalCashAccountController createPersonalCashAccountController = new CreatePersonalCashAccountController(ffmApp);
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


    double bankAccBalance = 0.6;
    double savingsAccBalance = 15;
    double cashAccBalance = 5;
    double negativeBalance = -2;
    double interestRate = 5;
    String currentAccName = "Current";
    String savingsAccName = "Savings";
    String cashAccName = "Cash";
    String creditCardAccName = "Credit Card";
    MoneyValue accountBalance = new MoneyValue(bankAccBalance, CurrencyEnum.EURO);

    @BeforeEach
    void setUp() {

        addFamilyController.addFamily("Ribeiro");
        addFamilyAdministratorController.addFamilyAdministrator(cc, name, date, numero, email, nif, rua, codPostal, local, city, 1);
        addBankAccountController.addBankAccount(currentAccName, 1, cc, bankAccBalance);
        addBankSavingsAccountController.addBankSavingsAccount(1, cc, savingsAccName, savingsAccBalance, interestRate);
        AddCashAccountDTO addCashAccountDTO = new AddCashAccountDTO(cashAccBalance, cashAccName, cc, 1, CurrencyEnum.EURO);
        createPersonalCashAccountController.createPersonalCashAccount(addCashAccountDTO);
        //AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(cc, 1, creditCardAccName, 5000.00);
        //addCreditCardAccountController.addCreditCardAccountToFamilyMember(addCreditCardAccountDTO);
    }

    @Test
    void getBankAccountBalanceTest1_Success() {
        double expected = 0.6;

        double result = getAccountBalanceController.getAccountBalance(1, cc, 1);

        Assertions.assertEquals(expected, result, 0.01);
    }
    @Test
    void getBankAccountBalanceTest2_NotEquals() {

        //expected value is purposefully incorrect
        double expected = 0.9;

        double result = getAccountBalanceController.getAccountBalance(1, cc, 1);

        Assertions.assertNotEquals(expected, result, 0.01);
    }
    @Test
    void getSavingsAccountBalanceTest1_Success() {
        double expected = 15;

        double result = getAccountBalanceController.getAccountBalance(1, cc, 2);

        Assertions.assertEquals(expected, result, 0.01);
    }
    @Test
    void getSavingsAccountBalanceTest2_NotEquals() {

        //expected value is purposefully incorrect
        double expected = 0.9;

        double result = getAccountBalanceController.getAccountBalance(1, cc, 2);

        Assertions.assertNotEquals(expected, result, 0.01);
    }
    /*
    @Test
    void getCreditCardAccountBalanceTest1_Success() {
        double expected = 5000;

        double result = getAccountBalanceController.getAccountBalance(1, cc, 3);

        Assertions.assertEquals(expected, result, 0.01);
    }
    @Test
    void getCreditCardAccountBalanceTest2_NotEquals() {

        //expected value is purposefully incorrect
        double expected = 0.9;

        double result = getAccountBalanceController.getAccountBalance(1, cc, 3);

        Assertions.assertNotEquals(expected, result, 0.01);
    }
     */
    @Test
    void getCashAccountBalanceTest1_Success() {
        double expected = 5;

        double result = getAccountBalanceController.getAccountBalance(1, cc, 3);

        Assertions.assertEquals(expected, result, 0.01);
    }
    @Test
    void getCashAccountBalanceTest2_NotEquals() {

        //expected value is purposefully incorrect
        double expected = 0.9;

        double result = getAccountBalanceController.getAccountBalance(1, cc, 3);

        Assertions.assertNotEquals(expected, result, 0.01);
    }

    //adicionar testes para todos os tipos de contas
    //adicionar testes para moneyvalue quando estiver tudo adicionado

}