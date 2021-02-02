package switchtwentytwenty.project.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.dtos.input.AddCashAccountDTO;
import switchtwentytwenty.project.domain.dtos.input.AddFamilyMemberDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.CategoryService;
import switchtwentytwenty.project.domain.services.FamilyService;
import switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.Date;


class TransferCashFromFamilyAccountToPersonalAccountControllerTest {

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

    //Standard Transaction data
    int familyID = 1;
    String familyMemberCC = "000000000ZZ4";
    int accountID = 1;
    double transferAmount = 2.00;
    CurrencyEnum currency = CurrencyEnum.EURO;
    int categoryID = 1;
    String transactionDesignation = "Not for donuts";
    Date transactionDate = new Date();
    FamilyCashTransferDTO familyCashTransferDTO;

    Application ffmApplication = new Application();

    AddFamilyMemberDTO familyMemberDTO = new AddFamilyMemberDTO(ccNumber,ccNumber, name, birthDate, phone, email, vat, street, postalCode, local, city, familyID);

    @BeforeEach
    void setUp(){

        FamilyService familyService = ffmApplication.getFamilyService();
        CategoryService categoryService = ffmApplication.getCategoryService();

        familyService.addFamily(familyName);

        familyService.addFamilyAdministrator(familyMemberDTO);
        categoryService.addStandardCategory("Compras",0);

        Family simpsonFamily = familyService.getFamily(1);
        FamilyMember homer = simpsonFamily.getFamilyMember(familyMemberCC);
        categoryService.addCategoryToFamilyTree(simpsonFamily,"Donuts",1);

        AddCashAccountDTO cashAccountDTO = new AddCashAccountDTO(0.23,"Homer's Wallet",familyMemberCC,1, currency);

        AccountService accountService = new AccountService();
        accountService.createFamilyCashAccount(simpsonFamily, "Simpson's Wallet", 12.75);
        accountService.createPersonalCashAccount(homer,cashAccountDTO);


    }

    @Test
    void transferCashFromFamilyToFamilyMember_validTransference() {
        familyCashTransferDTO = new FamilyCashTransferDTO(familyID,familyMemberCC,accountID,transferAmount,currency,categoryID,transactionDesignation,transactionDate);
        TransferCashFromFamilyAccountToPersonalAccountController controller = new TransferCashFromFamilyAccountToPersonalAccountController(ffmApplication);

        boolean result = controller.transferCashFromFamilyToFamilyMember(familyCashTransferDTO);

        Assertions.assertTrue(result);
    }

    @Test
    void transferCashFromFamilyToFamilyMember_invalidTransferenceIllegalFamily() {
        int familyID = 3;
        familyCashTransferDTO = new FamilyCashTransferDTO(familyID,familyMemberCC,accountID,transferAmount,currency,categoryID,transactionDesignation,transactionDate);
        TransferCashFromFamilyAccountToPersonalAccountController controller = new TransferCashFromFamilyAccountToPersonalAccountController(ffmApplication);


        boolean result = controller.transferCashFromFamilyToFamilyMember(familyCashTransferDTO);


        Assertions.assertFalse(result);
    }


    @Test
    void transferCashFromFamilyToFamilyMember_validCustomCategory() {
        int categoryID = -1;
        familyCashTransferDTO = new FamilyCashTransferDTO(familyID,familyMemberCC,accountID,transferAmount,currency,categoryID,transactionDesignation,transactionDate);
        TransferCashFromFamilyAccountToPersonalAccountController controller = new TransferCashFromFamilyAccountToPersonalAccountController(ffmApplication);

        boolean result = controller.transferCashFromFamilyToFamilyMember(familyCashTransferDTO);

        Assertions.assertTrue(result);
    }
}