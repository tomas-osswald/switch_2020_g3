package switchtwentytwenty.project.controllers;

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

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TransferCashBetweenFamilyMembersCashAccountsControllerTest {

    //Family Data
    String familyName = "Silva";

    //Family Member
    String ccNumber = "000000000ZZ4";
    String name = "Ze";
    Date birthDate = new Date(1990, 8, 26);
    int phone = 919999999;
    String email = "zen@gmail.com";
    int vat = 212122233;
    String street = "Rua Nossa";
    String postalCode = "4444-555";
    String local = "Zinde";
    String city = "Porto";

    String cc = "135149126ZW9";
    String name1 = "Diogo";
    Date date1 = new Date(1990, 8, 26);
    int numero1 = 919999999;
    String email1 = "diogo@gmail.com";
    int nif1 = 212122230;
    String rua1 = "Rua Nossa";
    String codPostal1 = "4444-555";
    String local1 = "Zinde";
    String city1 = "Porto";
    String relacao1 = "filho";
    boolean admin1 = false;

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

    double balance1 = 16.80;
    String accountName1 = "Trocos";
    AddCashAccountDTO firstCashAccountDTO = new AddCashAccountDTO(balance1, accountName1, cc, 1);
    double balance2 = 16.80;
    String accountName2 = "Trocos";
    AddCashAccountDTO secondCashAccountDTO = new AddCashAccountDTO(balance2, accountName2, cc, 1);

    //Cash Transfer Data
    int familyID = 1;
    String originFamilyMemberCC = ccNumber;
    int originAccountID = 11;
    String destinationFamilyMemberCC = cc2;
    int destinationAccountID = 12;
    double transferedValue = 1.35;
    int categoryID = 1;
    String transactionDesignation = "just 6 bijoux";
    Date transactionDate = new Date();
    CashTransferDTO cashTransferDTO;

    Application ffmApplication = new Application();

    @BeforeEach
    void setup(){
        FamilyService familyService = ffmApplication.getFamilyService();
        CategoryService categoryService = ffmApplication.getCategoryService();

        familyService.addFamily(familyName);

        familyService.addFamilyAdministrator(ccNumber, name, birthDate, phone, email, vat, street, postalCode, local, city, familyID);
        familyService.addFamilyMember(ccNumber,cc2,name2,date2,numero2,email2,nif2,rua2,codPostal2, local2, city2,familyID);
        categoryService.addStandardCategory("Compras",0);

        Family silva = familyService.getFamily(1);
        FamilyMember ze = silva.getFamilyMember(originFamilyMemberCC);
        FamilyMember tony = silva.getFamilyMember(destinationFamilyMemberCC);
        categoryService.addCategoryToFamilyTree(silva,"Donuts",1);

        AddCashAccountDTO firstCashAccountDTO = new AddCashAccountDTO(16.80, "Trocos pao", originFamilyMemberCC, 1);
        AddCashAccountDTO secondCashAccountDTO = new AddCashAccountDTO(2.45, "Padaria", destinationFamilyMemberCC, 1);
        AccountService accountService = new AccountService();

        accountService.createPersonalCashAccount(ze,firstCashAccountDTO);
        accountService.createPersonalCashAccount(tony,secondCashAccountDTO);
    }

    @Test
    void transferCashBetweenFamilyMembersCashAccountsTrueWithSufficientfunds() {

        cashTransferDTO = new CashTransferDTO(familyID,originFamilyMemberCC,originAccountID,destinationFamilyMemberCC,destinationAccountID,transferedValue,categoryID,transactionDesignation,transactionDate);
        TransferCashBetweenFamilyMembersCashAccountsController controller = new TransferCashBetweenFamilyMembersCashAccountsController(ffmApplication);
        boolean result = controller.TransferCashBetweenFamilyMembersCashAccounts(cashTransferDTO);
        assertTrue(result);
    }
}