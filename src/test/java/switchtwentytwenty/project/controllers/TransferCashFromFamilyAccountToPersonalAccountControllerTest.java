package switchtwentytwenty.project.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.DTOs.input.AddCashAccountDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.CategoryService;
import switchtwentytwenty.project.domain.services.FamilyService;
import switchtwentytwenty.project.domain.utils.TransferenceDTO;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


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
    double transferedValue = 2.00;
    int categoryID = 1;
    String transactionDesignation = "Not for donuts";
    Date transactionDate = new Date();
    TransferenceDTO transferenceDTO;

    Application ffmApplication = new Application();



    @BeforeEach
    void setUp(){

        FamilyService familyService = ffmApplication.getFamilyService();
        CategoryService categoryService = ffmApplication.getCategoryService();

        familyService.addFamily(familyName);

        familyService.addFamilyAdministrator(ccNumber, name, birthDate, phone, email, vat, street, postalCode, local, city, familyID);
        categoryService.addStandardCategory("Compras",0);

        Family simpsonFamily = familyService.getFamily(1);
        FamilyMember homer = simpsonFamily.getFamilyMember(familyMemberCC);
        categoryService.addCategoryToFamilyTree(simpsonFamily,"Donuts",1);

        AddCashAccountDTO cashAccountDTO = new AddCashAccountDTO(0.23,"Homer's Wallet",familyMemberCC,1);

        AccountService accountService = new AccountService();
        accountService.createFamilyCashAccount(simpsonFamily, "Simpson's Wallet", 12.75);
        accountService.createPersonalCashAccount(homer,cashAccountDTO);

    }

    @Test
    void transferCashFromFamilyToFamilyMember_validTransference() {

        transferenceDTO = new TransferenceDTO(familyID,familyMemberCC,accountID,transferedValue,categoryID,transactionDesignation,transactionDate);
        TransferCashFromFamilyAccountToPersonalAccountController controller = new TransferCashFromFamilyAccountToPersonalAccountController(ffmApplication);

        boolean result = controller.transferCashFromFamilyToFamilyMember(transferenceDTO);

        Assertions.assertTrue(result);
    }

    @Test
    void transferCashFromFamilyToFamilyMember_invalidTransferenceIllegalFamily() {
        int familyID = 3;
        transferenceDTO = new TransferenceDTO(familyID,familyMemberCC,accountID,transferedValue,categoryID,transactionDesignation,transactionDate);
        TransferCashFromFamilyAccountToPersonalAccountController controller = new TransferCashFromFamilyAccountToPersonalAccountController(ffmApplication);


        boolean result = controller.transferCashFromFamilyToFamilyMember(transferenceDTO);


        Assertions.assertFalse(result);
    }




}