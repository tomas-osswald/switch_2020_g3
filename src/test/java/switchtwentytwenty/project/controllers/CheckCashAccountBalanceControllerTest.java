package switchtwentytwenty.project.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.DTOs.MoneyValue;
import switchtwentytwenty.project.domain.DTOs.input.AddCashAccountDTO;
import switchtwentytwenty.project.domain.DTOs.input.AddCreditCardAccountDTO;
import switchtwentytwenty.project.domain.DTOs.output.AccountIDAndDescriptionDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.services.FamilyService;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CheckCashAccountBalanceControllerTest {

    Application application = new Application();
    FamilyService familyService = application.getFamilyService();
    CheckCashAccountBalanceController checkCashAccountBalanceController = new CheckCashAccountBalanceController(application);

    // Family Administrator

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

    // Family Member

    String id2 = "166699209ZY8";
    String name2 = "Tony";
    Date date2 = new Date(1954, 8, 26);
    int numero2 = 919999998;
    String email2 = "tony@gmail.com";
    int nif2 = 212122000;
    String rua2 = "Rua";
    String codPostal2 = "4444-556";
    String local2 = "Gaia";
    String city2 = "Porto";

    String familyName = "Simpsons";
    int familyOneID = 1;

    // CashAccount Data One

    Double valueOne = 10.00;
    String accountDescriptionOne = "Cash Account";
    int accountIDOne = 1;

    // CashAccount Data Two

    Double valueTwo = 50.00;
    String accountDescriptionTwo = "Cash Account";
    int accountIDTwo = 2;

    // Credit Card Account Data One

    String familyMemberID = "166699209ZY8";
    String creditCardDescription = "Credit Card";
    Double withdrawalLimit = 100.00;


    @BeforeEach
    void setup() {
        familyService.addFamily(familyName);
        familyService.addFamilyAdministrator(cc, name, date, numero, email, nif, rua, codPostal, local, city, familyOneID);
        familyService.addFamilyMember(cc, id2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, familyOneID);
    }

    @Test
    void getListOfCashAccountsOfAFamilyMemberListWithOneCashAccount() {
        CreatePersonalCashAccountController createPersonalCashAccountController = new CreatePersonalCashAccountController(application);
        AddCashAccountDTO addCashAccountDTO = new AddCashAccountDTO(valueOne, accountDescriptionOne, id2, familyOneID);
        createPersonalCashAccountController.createPersonalCashAccount(addCashAccountDTO);

        List<AccountIDAndDescriptionDTO> expectedList = new ArrayList<>();
        AccountIDAndDescriptionDTO expectedDTO = new AccountIDAndDescriptionDTO(accountIDOne, accountDescriptionOne);
        expectedList.add(expectedDTO);

        List<AccountIDAndDescriptionDTO> result = checkCashAccountBalanceController.getListOfCashAccountsOfAFamilyMember(cc, id2, familyOneID);

        assertEquals(expectedList, result);
    }

    @Test
    void getListOfCashAccountsOfAFamilyMemberListWithTwoCashAccount() {
        CreatePersonalCashAccountController createPersonalCashAccountController = new CreatePersonalCashAccountController(application);
        AddCashAccountDTO addCashAccountDTOOne = new AddCashAccountDTO(valueOne, accountDescriptionOne, id2, familyOneID);
        AddCashAccountDTO addCashAccountDTOTwo = new AddCashAccountDTO(valueTwo, accountDescriptionTwo, id2, familyOneID);
        createPersonalCashAccountController.createPersonalCashAccount(addCashAccountDTOOne);
        createPersonalCashAccountController.createPersonalCashAccount(addCashAccountDTOTwo);

        List<AccountIDAndDescriptionDTO> expectedList = new ArrayList<>();
        AccountIDAndDescriptionDTO expectedDTOOne = new AccountIDAndDescriptionDTO(accountIDOne, accountDescriptionOne);
        AccountIDAndDescriptionDTO expectedDTOTwo = new AccountIDAndDescriptionDTO(accountIDTwo, accountDescriptionTwo);
        expectedList.add(expectedDTOOne);
        expectedList.add(expectedDTOTwo);

        List<AccountIDAndDescriptionDTO> result = checkCashAccountBalanceController.getListOfCashAccountsOfAFamilyMember(cc, id2, familyOneID);

        assertEquals(expectedList, result);
    }

    @Test
    void getListOfCashAccountsOfAFamilyMemberListWithZeroCashAccount() {
        List<AccountIDAndDescriptionDTO> expected = new ArrayList<>(); // empty List

        List<AccountIDAndDescriptionDTO> result = checkCashAccountBalanceController.getListOfCashAccountsOfAFamilyMember(cc, id2, familyOneID);

        assertEquals(expected, result);
    }

    @Test
    void getListOfCashAccountsOfAFamilyMemberListWithTwoAccountTypes() {
        CreatePersonalCashAccountController createPersonalCashAccountController = new CreatePersonalCashAccountController(application);
        AddCashAccountDTO addCashAccountDTOOne = new AddCashAccountDTO(valueOne, accountDescriptionOne, id2, familyOneID);
        AddCashAccountDTO addCashAccountDTOTwo = new AddCashAccountDTO(valueTwo, accountDescriptionTwo, id2, familyOneID);
        createPersonalCashAccountController.createPersonalCashAccount(addCashAccountDTOOne);
        createPersonalCashAccountController.createPersonalCashAccount(addCashAccountDTOTwo);

        AddCreditCardAccountController addCreditCardAccountController = new AddCreditCardAccountController(application);
        AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(familyMemberID, familyOneID, creditCardDescription, withdrawalLimit);
        addCreditCardAccountController.addCreditCardAccountToFamilyMember(addCreditCardAccountDTO);


        List<AccountIDAndDescriptionDTO> expectedList = new ArrayList<>();
        AccountIDAndDescriptionDTO expectedDTOOne = new AccountIDAndDescriptionDTO(accountIDOne, accountDescriptionOne);
        AccountIDAndDescriptionDTO expectedDTOTwo = new AccountIDAndDescriptionDTO(accountIDTwo, accountDescriptionTwo);
        expectedList.add(expectedDTOOne);
        expectedList.add(expectedDTOTwo);

        List<AccountIDAndDescriptionDTO> result = checkCashAccountBalanceController.getListOfCashAccountsOfAFamilyMember(cc, id2, familyOneID);

        assertEquals(expectedList, result);
    }

    @Test
    void getListOfCashAccountsOfAFamilyMemberListWithZeroCashAccountNoAdministrator() {
        List<AccountIDAndDescriptionDTO> expected = new ArrayList<>(); // empty List

        List<AccountIDAndDescriptionDTO> result = checkCashAccountBalanceController.getListOfCashAccountsOfAFamilyMember(id2, cc, familyOneID);

        assertEquals(expected, result);
    }

    @Test
    void checkFamilyCashAccountBalanceFamilyWithCashAccount() {
        CreateFamilyCashAccountController createFamilyCashAccountController = new CreateFamilyCashAccountController(application);
        createFamilyCashAccountController.createFamilyCashAccount(familyOneID, accountDescriptionOne, valueOne, cc);

        MoneyValue expected = new MoneyValue(valueOne, CurrencyEnum.EURO);

        MoneyValue result = checkCashAccountBalanceController.checkFamilyCashAccountBalance(cc, familyOneID);

        assertEquals(expected, result);
    }

    @Test
    void checkFamilyCashAccountBalanceFamilyWithOutCashAccount() {
    }

    @Test
    void checkFamilyCashAccountBalanceFamilyWithCashAccountNoAdministrator() {
    }

    @Test
    void checkFamilyCashAccountBalanceFamilyWithCashAccountFamilyDoesNotExist() {
    }
}