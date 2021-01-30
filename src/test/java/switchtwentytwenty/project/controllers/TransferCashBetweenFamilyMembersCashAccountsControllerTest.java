package switchtwentytwenty.project.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.DTOs.input.AddCashAccountDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.accounts.CashAccount;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.CategoryService;
import switchtwentytwenty.project.domain.services.FamilyService;
import switchtwentytwenty.project.domain.utils.CashTransferDTO;
import switchtwentytwenty.project.domain.utils.TransferenceDTO;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TransferCashBetweenFamilyMembersCashAccountsControllerTest {

    //Family Data
    String familyName = "Simpson";

    //Family Member
    String ccNumber = "000000000ZZ4";
    String name = "Homer";
    Date birthDate = new Date(1990, 8, 26);
    int phone = 919999999;
    String email = "homerSimpson@gmail.com";
    int vat = 212122233;
    String street = "Rua Nossa";
    String postalCode = "4444-555";
    String local = "Zinde";
    String city = "Porto";

    //Family Member 1
    String cc1 = "175345988ZX8";
    String name1 = "Mary";
    Date date1 = new Date(1997, 3, 15);
    int numero1 = 937123123;
    String email1 = "mary@gmail.com";
    int nif1 = 293938903;
    String rua1 = "Rua";
    String codPostal1 = "4384-556";
    String local1 = "Porto";
    String city1 = "Porto";
    String relacao1 = "tia";

    //Family Member 2
    String cc2 = "166699209ZY8";
    String name2 = "Tony";
    Date date2 = new Date(1954, 8, 26);
    int numero2 = 919999998;
    String email2 = "tony@gmail.com";
    int nif2 = 212122000;
    String rua2 = "Rua";
    String codPostal2 = "4444-556";
    String local2 = "Gaia";
    String city2 = "Porto";
    String relacao2 = "primo";

    //Standard Transaction data
    int familyID = 1;
    String originFamilyMemberCC = "175345988ZX8";
    int originAccountID = 1;
    String destinationFamilyMemberCC = "166699209ZY8";
    int destinationAccountID = 2;
    String falseFamilyMemberCC = "150149271ZZ6";
    String falseFamilyMemberNIf = "219483345";
    double transferedValue = 2.00;
    int categoryID = 1;
    String transactionDesignation = "Not for donuts";
    Date transactionDate = new Date();
    CashTransferDTO transferenceDTO;

    Application ffmApplication = new Application();


    @BeforeEach
    void setUp() {

        FamilyService familyService = ffmApplication.getFamilyService();
        CategoryService categoryService = ffmApplication.getCategoryService();

        familyService.addFamily(familyName);

        familyService.addFamilyAdministrator(ccNumber, name, birthDate, phone, email, vat, street, postalCode, local, city, familyID);
        categoryService.addStandardCategory("Compras", 0);

        Family simpsonFamily = familyService.getFamily(1);
        familyService.addFamilyMember(ccNumber, originFamilyMemberCC, name1, date1, numero1, email1, nif1, rua1, codPostal1, local1, city1, familyID);
        FamilyMember mary = simpsonFamily.getFamilyMember(originFamilyMemberCC);
        familyService.addFamilyMember(ccNumber, destinationFamilyMemberCC, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, familyID);
        FamilyMember tony = simpsonFamily.getFamilyMember(destinationFamilyMemberCC);

        categoryService.addCategoryToFamilyTree(simpsonFamily, "Donuts", 1);

        AddCashAccountDTO mCashAccountDTO = new AddCashAccountDTO(14.50, "Mary's Wallet", originFamilyMemberCC, 1);
        AddCashAccountDTO tCashAccountDTO = new AddCashAccountDTO(3.80, "Tony's Wallet", destinationFamilyMemberCC, 1);
        AccountService accountService = new AccountService();

        accountService.createPersonalCashAccount(mary, mCashAccountDTO);
        accountService.createPersonalCashAccount(tony, tCashAccountDTO);
        accountService.getAccount(mary, originAccountID);
        accountService.getAccount(tony, destinationAccountID);
    }

    @Test
    void transferCashBetweenFamilyMembersCashAccountsTrueWithSufficientfunds() {
        transferenceDTO = new CashTransferDTO(familyID, originFamilyMemberCC, originAccountID, destinationFamilyMemberCC, destinationAccountID, transferedValue, categoryID, transactionDesignation, transactionDate);
        TransferCashBetweenFamilyMembersCashAccountsController controller = new TransferCashBetweenFamilyMembersCashAccountsController(ffmApplication);

        boolean result = controller.TransferCashBetweenFamilyMembersCashAccounts(transferenceDTO);

        Assertions.assertTrue(result);
    }

    @Test
    void transferCashBetweenFamilyMembersCashAccountsTrueWithInsufficientFund() {
        transferenceDTO = new CashTransferDTO(familyID, originFamilyMemberCC, originAccountID, destinationFamilyMemberCC, destinationAccountID, transferedValue, categoryID, transactionDesignation, transactionDate);
        TransferCashBetweenFamilyMembersCashAccountsController controller = new TransferCashBetweenFamilyMembersCashAccountsController(ffmApplication);

        boolean result = controller.TransferCashBetweenFamilyMembersCashAccounts(transferenceDTO);

        Assertions.assertTrue(result);
    }

    @Test
    void transferCashBetweenFamilyMembersCashAccountsFromFamilyMemberToAntoherFamilyMemberWithNoCashAccount() {
        transferenceDTO = new CashTransferDTO(familyID, originFamilyMemberCC, originAccountID, falseFamilyMemberCC, 3, 2, 1, "Beer", date1);
        TransferCashBetweenFamilyMembersCashAccountsController controller = new TransferCashBetweenFamilyMembersCashAccountsController(ffmApplication);
        assertFalse(controller.TransferCashBetweenFamilyMembersCashAccounts(transferenceDTO));
    }




}