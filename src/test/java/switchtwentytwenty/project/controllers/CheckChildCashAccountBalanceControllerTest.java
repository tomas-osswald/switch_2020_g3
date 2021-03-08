package switchtwentytwenty.project.controllers;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.dtos.input.AddBankSavingsAccountDTO;
import switchtwentytwenty.project.domain.dtos.input.AddCashAccountDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.Relation;
import switchtwentytwenty.project.domain.model.accounts.BankSavingsAccount;
import switchtwentytwenty.project.domain.model.accounts.CashAccount;
import switchtwentytwenty.project.domain.model.user_data.CCNumber;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.FamilyService;
import switchtwentytwenty.project.domain.services.RelationService;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CheckChildCashAccountBalanceControllerTest {

    Application application = new Application();
    FamilyService familyService = application.getFamilyService();
    RelationService relationService = new RelationService();
    AccountService accountService = application.getAccountService();
    CheckChildCashAccountBalanceController childCashController = new CheckChildCashAccountBalanceController(application);


    //Setup - Family Members

    String cc = "000000000ZZ4";
    CCNumber ccNumber = new CCNumber(cc);
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
    String relacao2 = "primo";

    boolean admin = false;

    FamilyMember diogo = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, admin);
    FamilyMember jorge = new FamilyMember(id2, name2, date2, numero2, email2, nif2, rua2, codPostal2, local2, city2, admin);

    //Setup - Family

    int familyOneID = 123;
    String familyOneName = "Simpson";
    Family family = new Family(familyOneName, familyOneID);

    //Setup - Accounts

    //Cash Account one

    Double valueOne = 10.00;
    String accountDescriptionOne = "Cash Account";
    int accountIDOne = 1;

    AddCashAccountDTO accountDTO = new AddCashAccountDTO(valueOne, accountDescriptionOne, cc, family.getFamilyID(), CurrencyEnum.EURO);
    CashAccount cashAccount = new CashAccount(accountDTO, accountIDOne);

    // Different Account - not Cash
    AddBankSavingsAccountDTO addBankSavingsAccountDTO = new AddBankSavingsAccountDTO(100.00, 1.00,"savings",cc,family.getFamilyID(), CurrencyEnum.EURO);
    BankSavingsAccount savingsAccount = new BankSavingsAccount(accountIDOne, addBankSavingsAccountDTO);


    @Test
    void checkChildCashAccountBalance_PositiveMoneyValue() {
        int familyID = family.getFamilyID();
        family.addFamilyMember(diogo);
        family.addFamilyMember(jorge);
        jorge.addAccount(cashAccount);
        int cashAccountID = cashAccount.getAccountID();
        Relation parent = new Relation("Pai", diogo, jorge, true);
        familyService.addFamily(family);
        relationService.addRelation(family, diogo, jorge, "Pai", true);
        accountService.createPersonalCashAccount(jorge, accountDTO);
        String parentID = diogo.getID();
        String childID = jorge.getID();


        double expected = cashAccount.getMoneyBalance().getValue();


        Double result = childCashController.checkChildCashAccountBalance(familyID, parentID, childID, cashAccountID);

        assertEquals(expected, result, 0.001);

    }

    @Test
    void checkChildCashAccountBalance_ZeroMoneyValue() {
        int familyID = family.getFamilyID();
        family.addFamilyMember(diogo);
        family.addFamilyMember(jorge);
        jorge.addAccount(cashAccount);
        int cashAccountID = cashAccount.getAccountID();
        familyService.addFamily(family);
        relationService.addRelation(family, diogo, jorge, "Pai", true);
        accountService.createPersonalCashAccount(jorge, accountDTO);
        String parentID = diogo.getID();
        String childID = jorge.getID();


        cashAccount.debit(new MoneyValue(10.0, CurrencyEnum.EURO));
        double expected = 0.00;

        Double result = childCashController.checkChildCashAccountBalance(familyID, parentID, childID, cashAccountID);

        assertEquals(expected, result, 0.001);
    }

    @Test
    void checkChildCashAccountBalance_ExpectingNegativeBalance_WrongFamily() {
        family.addFamilyMember(diogo);
        family.addFamilyMember(jorge);
        jorge.addAccount(cashAccount);
        int cashAccountID = cashAccount.getAccountID();
        familyService.addFamily(family);
        relationService.addRelation(family, diogo, jorge, "Pai", false);
        accountService.createPersonalCashAccount(jorge, accountDTO);
        String parentID = diogo.getID();
        String childID = jorge.getID();


        Double expected = -1.00;

        Double result = childCashController.checkChildCashAccountBalance(-90, parentID, childID, cashAccountID);

        assertEquals(expected, result, 0.001);
    }

    @Test
    void checkChildCashAccountBalance_ExpectingNegativeBalance_WrongFamilyMember() {
        int familyID = family.getFamilyID();
        family.addFamilyMember(diogo);
        family.addFamilyMember(jorge);
        jorge.addAccount(cashAccount);
        int cashAccountID = cashAccount.getAccountID();
        familyService.addFamily(family);
        relationService.addRelation(family, diogo, jorge, "Pai", false);
        accountService.createPersonalCashAccount(jorge, accountDTO);
        String parentID = diogo.getID();
        String childID = jorge.getID();


        Double expected = -1.00;

        Double result = childCashController.checkChildCashAccountBalance(familyID, "000000000000", childID, cashAccountID);

        assertEquals(expected, result, 0.001);
    }


    @Test
    void checkChildCashAccountBalance_ExpectingNegativeBalance_NotParent() {
        int familyID = family.getFamilyID();
        family.addFamilyMember(diogo);
        family.addFamilyMember(jorge);
        jorge.addAccount(cashAccount);
        int cashAccountID = cashAccount.getAccountID();
        familyService.addFamily(family);
        relationService.addRelation(family, diogo, jorge, "Pai", false);
        accountService.createPersonalCashAccount(jorge, accountDTO);
        String parentID = diogo.getID();
        String childID = jorge.getID();


        Double expected = -1.00;

        Double result = childCashController.checkChildCashAccountBalance(familyID, parentID, childID, cashAccountID);

        assertEquals(expected, result, 0.001);
    }

    @Test
    void checkChildCashAccountBalance_NoCashAccount() {
        int familyID = family.getFamilyID();
        family.addFamilyMember(diogo);
        family.addFamilyMember(jorge);
        jorge.addAccount(savingsAccount);
        int savingsAccountID = savingsAccount.getAccountID();
        familyService.addFamily(family);
        relationService.addRelation(family, diogo, jorge, "Pai", false);
        accountService.addBankSavingsAccount(jorge, addBankSavingsAccountDTO);
        String parentID = diogo.getID();
        String childID = jorge.getID();


        Double expected = -1.00;

        Double result = childCashController.checkChildCashAccountBalance(familyID, parentID, childID, savingsAccountID);

        assertEquals(expected, result, 0.001);
    }

}