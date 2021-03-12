package switchtwentytwenty.project.domain.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.controllers.AddFamilyAdministratorController;
import switchtwentytwenty.project.controllers.AddFamilyController;
import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.dtos.input.*;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.Relation;
import switchtwentytwenty.project.domain.model.accounts.*;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;
import switchtwentytwenty.project.domain.utils.exceptions.NotSameCurrencyException;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static switchtwentytwenty.project.domain.model.accounts.AccountType.*;

class AccountServiceTest {

    String id = "000000000ZZ4";
    String name = "Diogo";
    Date date = new Date(1990, 8, 12);
    int numero = 919999999;
    String emailTwo = "abc@gmail.com";

    Application ffmApp = new Application();
    AddFamilyController addFamilyController = new AddFamilyController(ffmApp);
    AddFamilyAdministratorController addFamilyAdministratorController = new AddFamilyAdministratorController(ffmApp);
    AccountService accountService = ffmApp.getAccountService();
    FamilyService familyService = ffmApp.getFamilyService();

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
    Date date2 = new Date(1954, 8, 12);
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
    Date date3 = new Date(1955, 8, 1);
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
    Family silva2 = new Family("Silva", 6);
    Family famCashAccountTest = new Family("Test",77);
    int generatedID = 1;

    //Account Types Test setup
    AddBankAccountDTO addBankAccountDTO = new AddBankAccountDTO(balance, accountName, cc, 1, CurrencyEnum.EURO);
    AddBankAccountDTO addBankAccountDTO2 = new AddBankAccountDTO(balance, accountName2, cc, 1, CurrencyEnum.EURO);
    AddBankAccountDTO addBankAccountDTO3 = new AddBankAccountDTO(balance, accountName, cc, 2, CurrencyEnum.EURO);
    AddBankAccountDTO addBankAccountDTO4 = new AddBankAccountDTO(balance, accountName2, cc, 2, CurrencyEnum.EURO);
    BankAccount bankAccount = new BankAccount(addBankAccountDTO, 1);
    BankAccount bankAccount2 = new BankAccount(addBankAccountDTO2, 2);
    AddBankSavingsAccountDTO addBankSavingsAccountDTO = new AddBankSavingsAccountDTO(balance, interestRate, "Savings", cc, family1ID, CurrencyEnum.EURO);
    BankSavingsAccount bankSavings = new BankSavingsAccount(generatedID, addBankSavingsAccountDTO);
    AddCreditCardAccountDTO creditDTO = new AddCreditCardAccountDTO(diogo.getCCNumberString(), silva.getFamilyID(), "card", 200.00, 100.00, 50.00, CurrencyEnum.EURO);
    CreditCardAccount creditCardAccount = new CreditCardAccount(creditDTO, 12);
    CashAccount cashAccount = new CashAccount("Cash", 100.00, generatedID, CurrencyEnum.EURO);
    CashAccount zeroCashAccount = new CashAccount("Cash", 0.00, generatedID, CurrencyEnum.EURO);
    CashAccount cashAccountYen = new CashAccount("Cash", 100.00, generatedID, CurrencyEnum.YEN);

    AddFamilyMemberDTO familyMemberDTO = new AddFamilyMemberDTO(id, id, name, date, numero, email, nif, rua, codPostal, local, city, 1);

    @BeforeEach
    void setup() {
        addFamilyController.addFamily("Ribeiro");
        addFamilyController.addFamily("Sousa");
        addFamilyAdministratorController.addFamilyAdministrator(familyMemberDTO);
        famCashAccountTest.addFamilyAdministrator(familyMemberDTO);
        familyService.addFamily(famCashAccountTest);

    }

    @Test
    void addBankSavingsAccountAddedSuccessfullyWithNullInput() {
        String accountName = "Savings Account";
        Double balance = null;
        Double interestRate = null;
        AddBankSavingsAccountDTO addBankSavingsAccountDTO = new AddBankSavingsAccountDTO(balance, interestRate, accountName, cc, 6, CurrencyEnum.EURO);
        AddFamilyMemberDTO memberDTO = new AddFamilyMemberDTO(id, id, name, date, numero, email, nif, rua, codPostal, local, city, 6);
        silva2.addFamilyMember(memberDTO);
        familyService.addFamily(silva2);
        assertDoesNotThrow(() -> accountService.addBankSavingsAccount(addBankSavingsAccountDTO));
    }

    @Test
    void addBankSavingsAccountAddedSuccessfullyWithRegularInput() {
        String accountName = "Savings Account";
        Double balance = 1.01;
        Double interestRate = -4.21;
        AddBankSavingsAccountDTO addBankSavingsAccountDTO = new AddBankSavingsAccountDTO(balance, interestRate, accountName, cc, 6, CurrencyEnum.EURO);
        AddFamilyMemberDTO memberDTO = new AddFamilyMemberDTO(id, id, name, date, numero, email, nif, rua, codPostal, local, city, 6);
        silva2.addFamilyMember(memberDTO);
        familyService.addFamily(silva2);
        assertDoesNotThrow(() -> accountService.addBankSavingsAccount(addBankSavingsAccountDTO));
    }

    @Test
    void addBankAccountTest1_Success() {
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        Family myFamily = new Family("BTC", 1);
        myFamily.addFamilyMember(diogo);
        familyService.addFamily(myFamily);
        AddBankAccountDTO addBankAccountDTO = new AddBankAccountDTO(balance, accountName, cc, 1, CurrencyEnum.EURO);
        assertDoesNotThrow(() -> accountService.addBankAccount(addBankAccountDTO));
        assertNotNull(diogo.getAccount(1));
    }


    @Test
    void addBankAccountTest2_NullBalanceSuccess() {
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        AddBankAccountDTO addBankAccountDTO = new AddBankAccountDTO(null, accountName, cc, 1, CurrencyEnum.EURO);
        assertDoesNotThrow(() -> accountService.addBankAccount(addBankAccountDTO));
    }

    @Test
    void addBankAccountTest3_AddTwoBankAccountsSuccess() {
        FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        AddBankAccountDTO addBankAccountDTO = new AddBankAccountDTO(balance, accountName, cc, 1, CurrencyEnum.EURO);
        AddBankAccountDTO addBankAccountDTO2 = new AddBankAccountDTO(negativeBalance, accountName, cc, 1, CurrencyEnum.EURO);
        accountService.addBankAccount(addBankAccountDTO);
        assertDoesNotThrow(() -> accountService.addBankAccount(addBankAccountDTO2));
    }

    @Test
    void createPersonalCreditCardAccountTrue() {
        AddFamilyMemberDTO memberDTO = new AddFamilyMemberDTO(cc, cc, name, date, numero, email, nif, rua, codPostal, local, city, 2);
        Family testFamily = new Family("Silva", 2);
        testFamily.addFamilyAdministrator(memberDTO);
        familyService.addFamily(testFamily);
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(cc, 2, "Visa do Diogo", 5000.00, 100.00, 50.00, CurrencyEnum.EURO);
        assertDoesNotThrow(() -> accountService.createPersonalCreditCardAccount(addCreditCardAccountDTO));
    }

    @Test
    void createPersonalCreditCardAccountAssertThrowInvalidWithrawalLimit() {
        AddFamilyMemberDTO memberDTO = new AddFamilyMemberDTO(cc, cc, name, date, numero, email, nif, rua, codPostal, local, city, 2);
        Family testFamily = new Family("Silva", 2);
        testFamily.addFamilyAdministrator(memberDTO);
        familyService.addFamily(testFamily);
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(cc, 2, "Conta da Maria", -100.00, 100.00, 50.00, CurrencyEnum.EURO);
        assertThrows(IllegalArgumentException.class, () -> accountService.createPersonalCreditCardAccount(addCreditCardAccountDTO));
    }

    @Test
    void verifyAccountType_BankSavings_ExpectingTrue() {
        //Arrange
        AccountType expectedType = BANKSAVINGSACCOUNT;
        //Act
        boolean result = accountService.verifyAccountType(bankSavings, expectedType);
        //Assert
        assertTrue(result);
    }


    @Test
    void verifyAccountType_BankSavings_ExpectingFalse() {
        //Arrange
        AccountType expectedType = CREDITCARDACCOUNT;
        //Act
        boolean result = accountService.verifyAccountType(bankSavings, expectedType);
        //Assert
        assertFalse(result);
    }

    @Test
    void verifyAccountType_CreditCardAccount_ExpectingTrue() {
        //Arrange
        AccountType expectedType = CREDITCARDACCOUNT;
        //Act
        boolean result = accountService.verifyAccountType(creditCardAccount, expectedType);
        //Assert
        assertTrue(result);
    }

    @Test
    void verifyAccountType_CreditCardAccount_ExpectingFalse() {
        //Arrange
        AccountType expectedType = BANKSAVINGSACCOUNT;
        //Act
        boolean result = accountService.verifyAccountType(creditCardAccount, expectedType);
        //Assert
        assertFalse(result);
    }

    @Test
    void verifyAccountType_BankAccount_ExpectingTrue() {
        //Arrange
        AccountType expectedType = BANKACCOUNT;
        //Act
        boolean result = accountService.verifyAccountType(bankAccount, expectedType);
        //Assert
        assertTrue(result);
    }

    @Test
    void verifyAccountType_BankAccount_ExpectingFalse() {
        //Arrange
        AccountType expectedType = CREDITCARDACCOUNT;
        //Act
        boolean result = accountService.verifyAccountType(bankAccount, expectedType);
        //Assert
        assertFalse(result);
    }

    @Test
    void verifyAccountType_CashAccount_ExpectingTrue() {
        //Arrange
        AccountType expectedType = CASHACCOUNT;
        //Act
        boolean result = accountService.verifyAccountType(cashAccount, expectedType);
        //Assert
        assertTrue(result);
    }

    @Test
    void verifyAccountType_CashAccount_ExpectingFalse() {
        //Arrange
        AccountType expectedType = CREDITCARDACCOUNT;
        //Act
        boolean result = accountService.verifyAccountType(cashAccount, expectedType);
        //Assert
        assertFalse(result);
    }


    @Test
    void getAccountNoAccountWithGivenIDResultNull() {
        int accountID = 1;
        Account expected = null;

        assertThrows(IllegalArgumentException.class, () -> accountService.getAccount(diogo, accountID));
    }

    @Test
    void getAccountSuccessTypeBankAccount() {
        Account expected = new BankAccount(addBankAccountDTO3, 1);
        AddFamilyMemberDTO familyMemberDTO = new AddFamilyMemberDTO(id, id, "diogo", date, 222222222, "email@email.com", nif, rua, codPostal, local, city, 2);
        familyService.addFamilyAdministrator(familyMemberDTO);
        FamilyMember diogo2 = familyService.getFamily(2).getFamilyMember(id);
        accountService.addBankAccount(addBankAccountDTO3);
        Account result = accountService.getAccount(diogo2, 1);

        assertEquals(expected, result);
        assertNotSame(expected, result);
    }

    @Test
    void getAccountFailureTypeBankAccount() {
        Account expected = new BankAccount(addBankAccountDTO3, 1);
        AddFamilyMemberDTO familyMemberDTO = new AddFamilyMemberDTO(id, id, "diogo", date, 222222222, "email@email.com", nif, rua, codPostal, local, city, 2);
        familyService.addFamilyAdministrator(familyMemberDTO);
        FamilyMember diogo2 = familyService.getFamily(2).getFamilyMember(id);

        accountService.addBankAccount(addBankAccountDTO4);
        Account result = accountService.getAccount(diogo2, 1);

        assertNotEquals(expected, result);
        assertNotSame(expected, result);
    }

    @Test
    void getAccountSuccessTypeBankSavingsAccount() {
        String accountName = "Savings Account";
        Double balance = null;
        Double interestRate = null;
        int accountID = 1;
        AddBankSavingsAccountDTO addBankSavingsAccountDTO = new AddBankSavingsAccountDTO(balance, interestRate, accountName, id, 6, CurrencyEnum.EURO);
        Account expected = new BankSavingsAccount(accountID, addBankSavingsAccountDTO);
        AddFamilyMemberDTO memberDTO = new AddFamilyMemberDTO(id, id, name, date, numero, email, nif, rua, codPostal, local, city, 6);
        silva2.addFamilyMember(memberDTO);
        familyService.addFamily(silva2);
        FamilyMember diogo2 = silva2.getFamilyMember(id);
        accountService.addBankSavingsAccount(addBankSavingsAccountDTO);
        Account result = accountService.getAccount(diogo2, accountID);

        assertEquals(expected, result);
    }


    @Test
    void checkChildCashAccountBalance_ExpectingCorrectValue() {
        MoneyValue expected = new MoneyValue(100.00, CurrencyEnum.EURO);
        AddFamilyMemberDTO familyMemberDTO = new AddFamilyMemberDTO(id, id, "diogo", date, 222222222, "email@email.com", nif, rua, codPostal, local, city, 5);
        AddFamilyMemberDTO familyMemberDTOfilho = new AddFamilyMemberDTO(id, id2, "diogo", date, 222222222, "email22222@email.com", nif2, rua, codPostal, local, city, 5);
        familyService.addFamily(silva);
        familyService.addFamilyAdministrator(familyMemberDTO);
        familyService.addFamilyMember(familyMemberDTOfilho);
        FamilyMember pai = silva.getFamilyMember(id);
        FamilyMember filho = silva.getFamilyMember(id2);
        silva.addRelation(new Relation("filho", pai, filho, true));
        filho.addAccount(cashAccount);
        MoneyValue result = accountService.checkChildCashAccountBalance(generatedID, 5, id, id2);

        assertEquals(expected, result);

    }

    @Test
    void checkChildCashAccountBalance_ZeroBalance_ExpectingCorrectValue() {
        AddFamilyMemberDTO familyMemberDTO = new AddFamilyMemberDTO(id, id, "diogo", date, 222222222, "email@email.com", nif, rua, codPostal, local, city, 5);
        AddFamilyMemberDTO familyMemberDTOfilho = new AddFamilyMemberDTO(id, id2, "diogo", date, 222222222, "email22222@email.com", nif2, rua, codPostal, local, city, 5);
        familyService.addFamily(silva);
        familyService.addFamilyAdministrator(familyMemberDTO);
        familyService.addFamilyMember(familyMemberDTOfilho);
        FamilyMember pai = silva.getFamilyMember(id);
        FamilyMember filho = silva.getFamilyMember(id2);
        silva.addRelation(new Relation("filho", pai, filho, true));
        filho.addAccount(cashAccount);
        Account expectedAccount = filho.getAccount(cashAccount.getAccountID());
        MoneyValue expected = expectedAccount.getMoneyBalance();
        MoneyValue result = accountService.checkChildCashAccountBalance(generatedID, 5, id, id2);

        assertEquals(expected, result);
    }

    //TODO: Confirmar teste do Throw de saldo negativo na Cash Account


    @Test
    void checkChildCashAccountBalance_AssertThrowsNoAccountWithSuchID() {
        int invalidID = -1;

        assertThrows(IllegalArgumentException.class, () -> {
            accountService.checkChildCashAccountBalance
                    (invalidID, 5, id, id2);
        });
    }


    @Test
    void checkChildCashAccountBalance_AssertThrowsNotACashAccount() {
        diogo.addAccount(bankSavings);
        int bankSavingsID = bankSavings.getAccountID();

        assertThrows(IllegalArgumentException.class, () -> {
            accountService.checkChildCashAccountBalance(bankSavingsID, 5, id, id2);
        });
    }


    @Test
    void createPersonalCashAccount_validInputValues() {
        String cashAccount = "Wallet";
        double balance = 0.23;
        AddCashAccountDTO cashAccountDTO = new AddCashAccountDTO(balance, cashAccount, id, 77, CurrencyEnum.EURO);

        boolean result = accountService.createPersonalCashAccount(cashAccountDTO);

        Assertions.assertTrue(result);
    }

    @Test
    void createPersonalCashAccount_invalidInputValues() {
        String cashAccount = "Wallet";
        double balance = -1000;

        AddCashAccountDTO cashAccountDTO = new AddCashAccountDTO(balance, cashAccount, id, 77, CurrencyEnum.EURO);

        boolean result = accountService.createPersonalCashAccount(cashAccountDTO);

        Assertions.assertFalse(result);
    }

    @Test
    void createFamilyCashAccount_validInputValues() {
        String designation = "Mealheiro familia Silva";
        double initialBalance = 100;
        AddFamilyMemberDTO familyMemberDTO = new AddFamilyMemberDTO(id, id, "diogo", date, 222222222, "email@email.com", nif, rua, codPostal, local, city, 5);
        Family testFamily = new Family("Silva", 5);
        testFamily.addFamilyAdministrator(familyMemberDTO);
        familyService.addFamily(testFamily);
        boolean result = accountService.createFamilyCashAccount(5, id, designation, initialBalance);

        Assertions.assertTrue(result);
    }

    @Test
    void createFamilyCashAccount_invalidInputValues() {
        String designation = "Mealheiro familia Silva";
        double initialBalance = -100;
        AddFamilyMemberDTO familyMemberDTO = new AddFamilyMemberDTO(id, id, "diogo", date, 222222222, "email@email.com", nif, rua, codPostal, local, city, 5);
        Family testFamily = new Family("Silva", 5);
        testFamily.addFamilyAdministrator(familyMemberDTO);
        familyService.addFamily(testFamily);
        assertThrows(IllegalArgumentException.class, () -> {
            accountService.createFamilyCashAccount(5, id, designation, initialBalance);
        });
    }


    @Test
    void transferCashFromFamilyToFamilyMember_ValidData() {
        //Common Data
        int familyID = 1;
        int accountID = 1;
        int categoryID = 1;
        StandardCategory transactionCategory = new StandardCategory("Apostas", null, 100);
        String transactionDesignation = "Lost Bet";
        Date transactionDate = new Date();
        //Account Data
        double initialBalance = 1000.00;
        AddCashAccountDTO cashAccountDTO = new AddCashAccountDTO(initialBalance, "Diogo's Wallet", id, 1, CurrencyEnum.EURO);
        Family ribeiro = familyService.getFamily(familyID);
        FamilyMember diogo = ribeiro.getFamilyMember(id);
        accountService.createFamilyCashAccount(familyID, id, "Familia Ribeiro's Wallet", 525);
        accountService.createPersonalCashAccount(cashAccountDTO);
        //Transference Data
        double transferAmount = 200.0;
        CurrencyEnum currency = CurrencyEnum.EURO;
        FamilyCashTransferDTO familyCashTransferDTO = new FamilyCashTransferDTO(familyID, id, accountID, transferAmount, currency, categoryID, transactionDesignation, transactionDate);

        boolean result = accountService.transferCashFromFamilyToFamilyMember(ribeiro, diogo, familyCashTransferDTO);

        Assertions.assertTrue(result);
    }

    @Test
    void transferCashFromFamilyToFamilyMember_NotEnoughMoneyInvalid() {
        //Common Data
        int familyID = 1;
        int accountID = 1;
        int categoryID = 1;
        StandardCategory transactionCategory = new StandardCategory("Apostas", null, 100);
        String transactionDesignation = "Lost Bet";
        Date transactionDate = new Date();
        //Account Data
        double initialBalance = 100.0;
        AddCashAccountDTO cashAccountDTO = new AddCashAccountDTO(initialBalance, "Diogo's Wallet", id, 1, CurrencyEnum.EURO);
        Family ribeiro = familyService.getFamily(familyID);
        FamilyMember diogo = ribeiro.getFamilyMember(id);
        accountService.createFamilyCashAccount(familyID, id, "Familia Ribeiro's Wallet", 100);
        accountService.createPersonalCashAccount(cashAccountDTO);
        //Transference Data
        double transferAmount = 200.0;
        CurrencyEnum currency = CurrencyEnum.EURO;
        FamilyCashTransferDTO familyCashTransferDTO = new FamilyCashTransferDTO(familyID, id, accountID, transferAmount, currency, categoryID, transactionDesignation, transactionDate);

        boolean result = accountService.transferCashFromFamilyToFamilyMember(ribeiro, diogo, familyCashTransferDTO);

        Assertions.assertFalse(result);
    }

    @Test
    void transferCashFromFamilyToFamilyMember_FamilyDoesNotHaveCashAccount() {
        //Common Data
        int familyID = 1;
        int accountID = 1;
        int categoryID = 1;
        StandardCategory transactionCategory = new StandardCategory("Apostas", null, 100);
        String transactionDesignation = "Lost Bet";
        Date transactionDate = new Date();
        //Account Data
        double initialBalance = 100.0;
        AddCashAccountDTO cashAccountDTO = new AddCashAccountDTO(initialBalance, "Diogo's Wallet", id, 1, CurrencyEnum.EURO);
        Family ribeiro = familyService.getFamily(familyID);
        FamilyMember diogo = ribeiro.getFamilyMember(id);
        accountService.createPersonalCashAccount(cashAccountDTO);
        //Transference Data
        double transferAmount = 200.0;
        CurrencyEnum currency = CurrencyEnum.EURO;
        FamilyCashTransferDTO familyCashTransferDTO = new FamilyCashTransferDTO(familyID, id, accountID, transferAmount, currency, categoryID, transactionDesignation, transactionDate);

        assertThrows(IllegalArgumentException.class, () -> {
            accountService.transferCashFromFamilyToFamilyMember(ribeiro, diogo, familyCashTransferDTO);
        });
    }

    @Test
    void transferCashFromFamilyToFamilyMember_DifferentCurrency() {
        //Common Data
        int familyID = 1;
        int accountID = 1;
        int categoryID = 1;
        StandardCategory transactionCategory = new StandardCategory("Apostas", null, 100);
        String transactionDesignation = "Lost Bet";
        Date transactionDate = new Date();
        //Account Data
        double initialBalance = 100.0;
        AddCashAccountDTO cashAccountDTO = new AddCashAccountDTO(initialBalance, "Diogo's Wallet", id, 1, CurrencyEnum.DOLLAR);
        Family ribeiro = familyService.getFamily(familyID);
        FamilyMember diogo = ribeiro.getFamilyMember(id);
        accountService.createPersonalCashAccount(cashAccountDTO);
        //Transference Data
        double transferAmount = 200.0;
        CurrencyEnum currency = CurrencyEnum.EURO;
        FamilyCashTransferDTO familyCashTransferDTO = new FamilyCashTransferDTO(familyID, id, accountID, transferAmount, currency, categoryID, transactionDesignation, transactionDate);

        assertThrows(IllegalArgumentException.class, () -> {
            accountService.transferCashFromFamilyToFamilyMember(ribeiro, diogo, familyCashTransferDTO);
        });
    }

    @Test
    void transferCashFromFamilyToFamilyMember_ValidateDebitOnFamilyAccount() {
        //Common Data
        int familyID = 1;
        int accountID = 1;
        int categoryID = 1;
        StandardCategory transactionCategory = new StandardCategory("Apostas", null, 100);
        String transactionDesignation = "Lost Bet";
        Date transactionDate = new Date();
        //Account Data
        double initialBalance = 1000.00;
        AddCashAccountDTO cashAccountDTO = new AddCashAccountDTO(initialBalance, "Diogo's Wallet", id, 1, CurrencyEnum.EURO);
        Family ribeiro = familyService.getFamily(familyID);
        FamilyMember diogo = ribeiro.getFamilyMember(id);
        accountService.createFamilyCashAccount(familyID,id, "Familia Ribeiro's Wallet", 525.0);
        accountService.createPersonalCashAccount(cashAccountDTO);
        //Transference Data
        double transferAmount = 200.0;
        CurrencyEnum currency = CurrencyEnum.EURO;
        FamilyCashTransferDTO familyCashTransferDTO = new FamilyCashTransferDTO(familyID, id, accountID, transferAmount, currency, categoryID, transactionDesignation, transactionDate);
        //Expected
        MoneyValue expected = new MoneyValue(325.0, CurrencyEnum.EURO);

        accountService.transferCashFromFamilyToFamilyMember(ribeiro, diogo, familyCashTransferDTO);
        Account familyAccount = ribeiro.getFamilyCashAccount();
        MoneyValue result = familyAccount.getMoneyBalance();

        Assertions.assertEquals(expected, result);
    }

    @Test
    void transferCashFromFamilyToFamilyMember_ValidateCreditOnPersonalAccount() {
        //Common Data
        int familyID = 1;
        int accountID = 1;
        int categoryID = 1;
        StandardCategory transactionCategory = new StandardCategory("Apostas", null, 100);
        String transactionDesignation = "Lost Bet";
        Date transactionDate = new Date();
        //Account Data
        double initialBalance = 1000.00;
        AddCashAccountDTO cashAccountDTO = new AddCashAccountDTO(initialBalance, "Diogo's Wallet", id, 1, CurrencyEnum.EURO);
        Family ribeiro = familyService.getFamily(familyID);
        FamilyMember diogo = ribeiro.getFamilyMember(id);
        accountService.createFamilyCashAccount(familyID,id, "Familia Ribeiro's Wallet", 525.0);
        accountService.createPersonalCashAccount(cashAccountDTO);
        //Transference Data
        double transferAmount = 200.00;
        CurrencyEnum currency = CurrencyEnum.EURO;
        FamilyCashTransferDTO familyCashTransferDTO = new FamilyCashTransferDTO(familyID, id, accountID, transferAmount, currency, categoryID, transactionDesignation, transactionDate);
        //Expected
        MoneyValue expected = new MoneyValue(1200.00, CurrencyEnum.EURO);

        accountService.transferCashFromFamilyToFamilyMember(ribeiro, diogo, familyCashTransferDTO);
        Account personalAccount = diogo.getAccount(1);
        MoneyValue result = personalAccount.getMoneyBalance();

        Assertions.assertEquals(expected, result);
    }

    @Test
    void transferCashBetweenSameFamilyMembersWithCashAccountsValid() {
        //Arrange
        int familyID = 1;
        String originFamilyMemberCC = "175345988ZX8";
        int originAccountID = 1;
        String destinationFamilyMemberCC = "166699209ZY8";
        int destinationAccountID = 1;
        String falseFamilyMemberCC = "150149271ZZ6";
        String falseFamilyMemberNIf = "219483345";
        int falseDestinationAccountID = 1;
        MoneyValue transferedValue = new MoneyValue(2.0, CurrencyEnum.EURO);
        int categoryID = 1;
        String transactionDesignation = "Not for donuts";
        Date transactionDate = new Date();

        CategoryService categoryService = this.ffmApp.getCategoryService();
        AddCashAccountDTO mCashAccountDTO = new AddCashAccountDTO(14.50, "Mary's Wallet", originFamilyMemberCC, 1, CurrencyEnum.EURO);
        AddCashAccountDTO tCashAccountDTO = new AddCashAccountDTO(3.80, "Tony's Wallet", destinationFamilyMemberCC, 1, CurrencyEnum.EURO);

        AddFamilyMemberDTO familyMemberDTO2 = new AddFamilyMemberDTO(cc, originFamilyMemberCC, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, familyID);
        AddFamilyMemberDTO familyMemberDTO3 = new AddFamilyMemberDTO(cc, destinationFamilyMemberCC, name3, date3, numero3, email3, 219483345, rua3, codPostal3, local3, city3, familyID);

        Family simpsonFamily = familyService.getFamily(1);
        familyService.addFamilyMember(familyMemberDTO2);
        FamilyMember mary = simpsonFamily.getFamilyMember(originFamilyMemberCC);
        familyService.addFamilyMember(familyMemberDTO3);
        FamilyMember tony = simpsonFamily.getFamilyMember(destinationFamilyMemberCC);

        accountService.createPersonalCashAccount(mCashAccountDTO);
        accountService.createPersonalCashAccount(tCashAccountDTO);

        StandardCategory category = categoryService.getStandardCategoryByID(categoryID);

        CashTransferDTO transferDTO = new CashTransferDTO(familyID, originFamilyMemberCC, originAccountID, destinationFamilyMemberCC, destinationAccountID, transferedValue.getValue(), transferedValue.getCurrencyType(), categoryID, transactionDesignation, transactionDate);

        boolean result = accountService.transferCashBetweenFamilyMembersCashAccounts(mary, tony, transferDTO);

        assertTrue(result);
    }

    @Test
    void transferCashBetweenOneFamilyMemberWithCashAccountAndAnotherFamilyMemberWithNoCashAccount() {
        //Arrange
        int familyID = 1;
        String originFamilyMemberCC = "175345988ZX8";
        int originAccountID = 1;
        String destinationFamilyMemberCC = "166699209ZY8";
        int destinationAccountID = 1;
        String falseFamilyMemberCC = "150149271ZZ6";
        String falseFamilyMemberNIf = "219483345";
        int falseDestinationAccountID = 1;
        MoneyValue transferedValue = new MoneyValue(2.0, CurrencyEnum.EURO);
        int categoryID = 1;
        String transactionDesignation = "Not for donuts";
        Date transactionDate = new Date();

        CategoryService categoryService = this.ffmApp.getCategoryService();
        AddCashAccountDTO mCashAccountDTO = new AddCashAccountDTO(14.50, "Mary's Wallet", originFamilyMemberCC, 1, CurrencyEnum.EURO);
        AddCashAccountDTO tCashAccountDTO = new AddCashAccountDTO(3.80, "Tony's Wallet", destinationFamilyMemberCC, 1, CurrencyEnum.EURO);

        AddFamilyMemberDTO familyMemberDTO2 = new AddFamilyMemberDTO(cc, originFamilyMemberCC, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, familyID);
        AddFamilyMemberDTO familyMemberDTO3 = new AddFamilyMemberDTO(cc, destinationFamilyMemberCC, name3, date3, numero3, email3, 219483345, rua3, codPostal3, local3, city3, familyID);


        Family simpsonFamily = familyService.getFamily(1);
        familyService.addFamilyMember(familyMemberDTO2);
        FamilyMember mary = simpsonFamily.getFamilyMember(originFamilyMemberCC);
        familyService.addFamilyMember(familyMemberDTO3);
        FamilyMember tony = simpsonFamily.getFamilyMember(destinationFamilyMemberCC);

        accountService.createPersonalCashAccount(mCashAccountDTO);
        //accountService.createPersonalCashAccount(tony, tCashAccountDTO);

        StandardCategory category = categoryService.getStandardCategoryByID(categoryID);

        CashTransferDTO transferDTO = new CashTransferDTO(familyID, originFamilyMemberCC, originAccountID, destinationFamilyMemberCC, destinationAccountID, transferedValue.getValue(), transferedValue.getCurrencyType(), categoryID, transactionDesignation, transactionDate);
        assertThrows(NullPointerException.class, () -> {
            accountService.transferCashBetweenFamilyMembersCashAccounts(mary, tony, transferDTO);
        });
    }

    @Test
    void transferCashFromFamilyToFamilyMember_FamilyMemberDoesNotHaveCashAccount() {
        //Common Data
        int familyID = 1;
        int accountID = 2;
        int categoryID = 1;
        StandardCategory transactionCategory = new StandardCategory("Apostas", null, 100);
        String transactionDesignation = "Lost Bet";
        Date transactionDate = new Date();
        //Account Data
        double initialBalance = 1000.00;
        AddCashAccountDTO cashAccountDTO = new AddCashAccountDTO(initialBalance, "Diogo's Wallet", id, 1, CurrencyEnum.EURO);
        Family ribeiro = familyService.getFamily(familyID);
        FamilyMember diogo = ribeiro.getFamilyMember(id);
        accountService.createFamilyCashAccount(familyID,id, "Familia Ribeiro's Wallet", 525);
        accountService.createPersonalCashAccount(cashAccountDTO);
        //Transference Data
        double transferAmount = 200.0;
        CurrencyEnum currency = CurrencyEnum.EURO;
        FamilyCashTransferDTO familyCashTransferDTO = new FamilyCashTransferDTO(familyID, id, accountID, transferAmount, currency, categoryID, transactionDesignation, transactionDate);

        boolean result = accountService.transferCashFromFamilyToFamilyMember(ribeiro, diogo, familyCashTransferDTO);

        Assertions.assertTrue(result);
    }

    @Test
    void name() {
        FamilyMember familyMember = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city);
        AddFamilyMemberDTO memberDTO = new AddFamilyMemberDTO(cc, cc, name, date, numero, email, nif, rua, codPostal, local, city, 2);
        Family testFamily = new Family("Silva", 2);
        testFamily.addFamilyAdministrator(memberDTO);
        familyService.addFamily(testFamily);
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(cc, 2, "Visa do Diogo", 5000.00, 100.00, 50.00, CurrencyEnum.EURO);
        accountService.createPersonalCreditCardAccount(addCreditCardAccountDTO);

        assertThrows(Exception.class, () -> accountService.getFamilyMemberCashAccountBalance(familyMember, 1));
    }

    @Test
    void validateChangesInBalanceAfterTransferCashBetweenFamilyMembers() {
        AccountService accountService = ffmApp.getAccountService();
        diogo.addAccount(cashAccount);
        jorge.addAccount(zeroCashAccount);
        CashTransferDTO cashTransferDTO = new CashTransferDTO(1, cc, 1, id, generatedID, 5.00, CurrencyEnum.EURO, 0, "Divida", new Date());

        accountService.transferCashBetweenFamilyMembersCashAccounts(diogo, jorge, cashTransferDTO);

        MoneyValue expectedDebit = new MoneyValue(95.00, CurrencyEnum.EURO);
        MoneyValue expectedCredit = new MoneyValue(5.00, CurrencyEnum.EURO);

        MoneyValue resultDebit = cashAccount.getMoneyBalance();
        MoneyValue resultCredit = zeroCashAccount.getMoneyBalance();

        assertEquals(resultCredit, expectedCredit);
        assertEquals(resultDebit, expectedDebit);
    }

    @Test
    void transferCashFromFamilyMemberToFamilyMemberWrongCurrencyFamily() {
        AccountService accountService = ffmApp.getAccountService();
        diogo.addAccount(cashAccount);
        jorge.addAccount(zeroCashAccount);
        CashTransferDTO cashTransferDTO = new CashTransferDTO(1, cc, 1, id, generatedID, 5.00, CurrencyEnum.YEN, 0, "Divida", new Date());

        assertThrows(NotSameCurrencyException.class, () -> accountService.transferCashBetweenFamilyMembersCashAccounts(diogo, jorge, cashTransferDTO));
    }

    @Test
    void transferCashFromFamilyToFamilyMemberWrongCurrencyMember() {
        AccountService accountService = ffmApp.getAccountService();
        diogo.addAccount(cashAccountYen);
        FamilyCashTransferDTO dto = new FamilyCashTransferDTO(1, cc, 1, 3.0, CurrencyEnum.EURO, 0, "jj", date);
        assertThrows(IllegalArgumentException.class, () -> accountService.transferCashFromFamilyToFamilyMember(silva, jorge, dto));
    }
}
