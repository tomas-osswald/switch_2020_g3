package switchtwentytwenty.project.domain.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.DTOs.input.AddCreditCardAccountDTO;

import java.util.Date;
import switchtwentytwenty.project.controllers.AddFamilyAdministratorController;
import switchtwentytwenty.project.controllers.AddFamilyController;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.accounts.*;

import static org.junit.jupiter.api.Assertions.*;
import static switchtwentytwenty.project.domain.model.accounts.AccountTypeEnum.*;

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
    FamilyService familyService = new FamilyService();

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
    boolean admin3 = true;

    //DTO Test Setup
    FamilyMember diogo = new FamilyMember(id, name, date, numero, email, nif, rua, codPostal, local, city, admin);
    FamilyMember jorge = new FamilyMember(id2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, admin2);
    FamilyMember manuelAdminMasterInTheHousesOfTheNightOfTheBicepsWithMyFamily = new FamilyMember(id3, name3, date3, numero3, email3, nif3, rua3, codPostal3, local3, city3, admin3);

    double balance = 0.6;
    double negativeBalance = -2;
    String accountName = "Current Account";
    String accountName2 = "Other Current Account";
    double interestRate = 2.00;

    int family1ID = 5;
    String family1Name = "Silva";
    Family silva = new Family(family1Name, family1ID);
    int generatedID = 1;

    //Account Types Test setup
    BankAccount bankAccount = new BankAccount("bank account", balance, generatedID);
    BankSavingsAccount bankSavings = new BankSavingsAccount(generatedID, "Savings", balance, interestRate);
    AddCreditCardAccountDTO creditDTO = new AddCreditCardAccountDTO(diogo.getID(), silva.getFamilyID(), "card", 200.00);
    CreditCardAccount creditCardAccount = new CreditCardAccount(creditDTO, 12);
    CashAccount cashAccount = new CashAccount("Cash", 100.00, generatedID);
    BankAccount currentAccount = new BankAccount("Current", 100.00, generatedID);


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
    void addBankAccountTest2_NullBalanceSuccess() {
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        Assertions.assertTrue(accountService.addBankAccount(diogo, accountName, null));
    }
    @Test
    void addBankAccountTest3_AddTwoBankAccountsSuccess() {
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        accountService.addBankAccount(diogo, accountName, balance);
        assertTrue(accountService.addBankAccount(diogo, accountName, negativeBalance));
    }

    @Test
    void createPersonalCreditCardAccountTrue() {
        FamilyMember familyMember = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(id2, family1ID, "Visa do Diogo", 5000.00);
        assertTrue(accountService.createPersonalCreditCardAccount(addCreditCardAccountDTO, familyMember));
        }

    @Test
    void createPersonalCreditCardAccountAssertThrowInvalidWithrawalLimit() {
        FamilyMember familyMember = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(id2, family1ID, "Conta da Maria", -100.00);
        assertThrows(IllegalArgumentException.class, () -> accountService.createPersonalCreditCardAccount(addCreditCardAccountDTO, familyMember));
    }

    @Test
    void verifyAccountType_BankSavings_ExpectingTrue() {
        //Arrange
        AccountTypeEnum expectedType = BANKSAVINGSACCOUNT;
        //Act
        boolean result = bankSavings.checkAccountType(expectedType);
        //Assert
        assertTrue(result);
    }

    @Test
    void verifyAccountType_BankSavings_ExpectingFalse() {
        //Arrange
        AccountTypeEnum expectedType = CREDITCARDACCOUNT;
        //Act
        boolean result = bankSavings.checkAccountType(expectedType);
        //Assert
        assertFalse(result);
    }

    @Test
    void verifyAccountType_CreditCardAccount_ExpectingTrue() {
        //Arrange
        AccountTypeEnum expectedType = CREDITCARDACCOUNT;
        //Act
        boolean result = creditCardAccount.checkAccountType(expectedType);
        //Assert
        assertTrue(result);
    }

    @Test
    void verifyAccountType_CreditCardAccount_ExpectingFalse() {
        //Arrange
        AccountTypeEnum expectedType = BANKSAVINGSACCOUNT;
        //Act
        boolean result = creditCardAccount.checkAccountType(expectedType);
        //Assert
        assertFalse(result);
    }

    @Test
    void verifyAccountType_BankAccount_ExpectingTrue() {
        //Arrange
        AccountTypeEnum expectedType = BANKACCOUNT;
        //Act
        boolean result = bankAccount.checkAccountType(expectedType);
        //Assert
        assertTrue(result);
    }

    @Test
    void verifyAccountType_BankAccount_ExpectingFalse() {
        //Arrange
        AccountTypeEnum expectedType = CREDITCARDACCOUNT;
        //Act
        boolean result = bankAccount.checkAccountType(expectedType);
        //Assert
        assertFalse(result);
    }

    @Test
    void verifyAccountType_CashAccount_ExpectingTrue() {
        //Arrange
        AccountTypeEnum expectedType = CASHACCOUNT;
        //Act
        boolean result = cashAccount.checkAccountType(expectedType);
        //Assert
        assertTrue(result);
    }

    @Test
    void verifyAccountType_CashAccount_ExpectingFalse() {
        //Arrange
        AccountTypeEnum expectedType = CREDITCARDACCOUNT;
        //Act
        boolean result = cashAccount.checkAccountType(expectedType);
        //Assert
        assertFalse(result);
    }


    @Test
    void getAccountNoAccountWithGivenIDResultNull() {
        int accountID = 1;
        Account expected = null;

        Account result = accountService.getAccount(diogo, accountID);

        assertEquals(result, expected);
    }

    @Test
    void getAccountSuccessTypeBankAccount() {
        String accountName = "Bank Account";
        Double balance = null;
        int accountID = 1;
        Account expected = new BankAccount(accountName, balance, accountID);

        accountService.addBankAccount(diogo, accountName, balance);
        Account result = accountService.getAccount(diogo, accountID);

        assertEquals(result, expected);
    }

    @Test
    void getAccountSuccessTypeBankSavingsAccount() {
        String accountName = "Savings Account";
        Double balance = null;
        Double interestRate = null;
        int accountID = 1;
        Account expected = new BankSavingsAccount(accountID, accountName, balance, interestRate);

        accountService.addBankSavingsAccount(diogo, accountName, balance, interestRate);
        Account result = accountService.getAccount(diogo, accountID);

        assertEquals(result, expected);
    }


}
