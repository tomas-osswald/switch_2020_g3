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
import switchtwentytwenty.project.domain.utils.CashTransferDTO;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.Date;

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
    int destinationAccountID = 1;
    String falseFamilyMemberCC = "150149271ZZ6";
    String falseFamilyMemberNIf = "219483345";
    int falseDestinationAccountID = 1;
    MoneyValue transferedValue = new MoneyValue(2.0, CurrencyEnum.EURO);
    int categoryID = 1;
    String transactionDesignation = "Not for donuts";
    Date transactionDate = new Date();
    CashTransferDTO transferenceDTO;

    AddFamilyMemberDTO familyMemberDTO1 = new AddFamilyMemberDTO(ccNumber, originFamilyMemberCC, name1, date1, numero1, email1, nif1, rua1, codPostal1, local1, city1, familyID);
    AddFamilyMemberDTO familyMemberDTO2 = new AddFamilyMemberDTO(ccNumber, destinationFamilyMemberCC, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, familyID);

    Application ffmApplication = new Application();


    @BeforeEach
    void setUp() {

        FamilyService familyService = ffmApplication.getFamilyService();
        CategoryService categoryService = ffmApplication.getCategoryService();

        familyService.addFamily(familyName);

        familyService.addFamilyAdministrator(ccNumber, name, birthDate, phone, email, vat, street, postalCode, local, city, familyID);
        categoryService.addStandardCategory("Compras", 0);

        Family simpsonFamily = familyService.getFamily(1);
        familyService.addFamilyMember(familyMemberDTO1);
        FamilyMember mary = simpsonFamily.getFamilyMember(originFamilyMemberCC);
        familyService.addFamilyMember(familyMemberDTO2);
        FamilyMember tony = simpsonFamily.getFamilyMember(destinationFamilyMemberCC);

        categoryService.addCategoryToFamilyTree(simpsonFamily, "Donuts", 1);

        AddCashAccountDTO mCashAccountDTO = new AddCashAccountDTO(14.50, "Mary's Wallet", originFamilyMemberCC, 1, CurrencyEnum.EURO);
        AddCashAccountDTO tCashAccountDTO = new AddCashAccountDTO(3.80, "Tony's Wallet", destinationFamilyMemberCC, 1, CurrencyEnum.EURO);
        AccountService accountService = new AccountService();

        accountService.createPersonalCashAccount(mary, mCashAccountDTO);
        accountService.createPersonalCashAccount(tony, tCashAccountDTO);

    }

    @Test
    void transferCashBetweenFamilyMembersCashAccountsTrueWithSufficientFunds() {
        transferenceDTO = new CashTransferDTO(familyID, originFamilyMemberCC, originAccountID, destinationFamilyMemberCC, destinationAccountID, transferedValue, categoryID, transactionDesignation, transactionDate);
        TransferCashBetweenFamilyMembersCashAccountsController controller = new TransferCashBetweenFamilyMembersCashAccountsController(ffmApplication);

        boolean result = controller.transferCashBetweenFamilyMembersCashAccounts(transferenceDTO);

        Assertions.assertTrue(result);
    }

    @Test
    void transferCashBetweenFamilyMembersCashAccountsFromFamilyMembersOfUnknownFamily() {
        transferenceDTO = new CashTransferDTO(2, originFamilyMemberCC, originAccountID, "000", 1, new MoneyValue(2.0, CurrencyEnum.EURO), 1, "Beer", date1);
        TransferCashBetweenFamilyMembersCashAccountsController controller = new TransferCashBetweenFamilyMembersCashAccountsController(ffmApplication);

        Assertions.assertThrows(Exception.class, () -> controller.transferCashBetweenFamilyMembersCashAccounts(transferenceDTO));
    }

    @Test
    void transferCashBetweenFamilyMembersCashAccountsFromFamilyMembersWithUnknowCategory() {
        transferenceDTO = new CashTransferDTO(2, originFamilyMemberCC, originAccountID, "000", 1, new MoneyValue(2.0, CurrencyEnum.EURO), 9, "Beer", date1);
        TransferCashBetweenFamilyMembersCashAccountsController controller = new TransferCashBetweenFamilyMembersCashAccountsController(ffmApplication);

        Assertions.assertThrows(Exception.class, () -> controller.transferCashBetweenFamilyMembersCashAccounts(transferenceDTO));
    }


}