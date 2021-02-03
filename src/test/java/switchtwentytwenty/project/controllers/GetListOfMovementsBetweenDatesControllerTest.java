package switchtwentytwenty.project.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.dtos.input.AddBankAccountDTO;
import switchtwentytwenty.project.domain.dtos.input.AddCashAccountDTO;
import switchtwentytwenty.project.domain.dtos.input.AddCreditCardAccountDTO;
import switchtwentytwenty.project.domain.dtos.input.FamilyCashTransferDTO;
import switchtwentytwenty.project.domain.dtos.output.TransactionDataDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.model.accounts.BankAccount;
import switchtwentytwenty.project.domain.model.accounts.BankSavingsAccount;
import switchtwentytwenty.project.domain.model.accounts.CashAccount;
import switchtwentytwenty.project.domain.model.accounts.CreditCardAccount;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GetListOfMovementsBetweenDatesControllerTest {

    String cc = "110142608ZZ0";
    String name = "Diogo";
    Date date = new Date(1990, 8, 26);
    int numero = 919999999;
    String email = "diogo@gmail.com";
    int nif = 212122230;
    String rua = "Rua Nossa";
    String codPostal = "4444-555";
    String local = "Zinde";
    String city = "Porto";
    boolean admin = false;

    FamilyMember familyMember1 = new FamilyMember(cc, name, date, numero, email, nif, rua, codPostal, local, city, admin);

    String testFamilyName = "Moura";
    int testFamilyID = 10;
    Family testFamily = new Family(testFamilyName, testFamilyID);
    Application app = new Application(testFamily);
    GetListOfMovementsBetweenDatesController controller = new GetListOfMovementsBetweenDatesController(app);

    double balance = 0.6;
    String accountName = "Savings";
    int cashAccountID = 1;
    int bankAccountID = 2;
    int bankSavingsAccountID = 3;
    int creditCardAccountID = 4;
    AddCashAccountDTO addCashAccountDTO = new AddCashAccountDTO(balance, accountName, cc, 1, CurrencyEnum.EURO);
    AddCreditCardAccountDTO addCreditCardAccountDTO = new AddCreditCardAccountDTO(cc, testFamilyID, "Credit Card", 200.00, 1.00, 0.50, CurrencyEnum.EURO);
    AddBankAccountDTO addBankAccountDTO = new AddBankAccountDTO(balance, "bank", cc, testFamilyID, CurrencyEnum.EURO);

    CashAccount cashAccount = new CashAccount(addCashAccountDTO, cashAccountID);
    BankAccount bankAccount = new BankAccount(addBankAccountDTO, bankAccountID);
    BankSavingsAccount bankSavingsAccount = new BankSavingsAccount(bankSavingsAccountID, "savings", 20.00, 0.01);
    CreditCardAccount creditCardAccount = new CreditCardAccount(addCreditCardAccountDTO, creditCardAccountID);

    Date startDateOne = new Date(2021, 0, 19);
    Date endDateThree = new Date(2021, 0, 31);

    double transferAmount = 200.0;
    CurrencyEnum currency = CurrencyEnum.EURO;
    MoneyValue remainingBalance = new MoneyValue(100.0,currency);
    int categoryID = 2;
    String transactionDesignation = "Luz Novembro";
    Date transactionDateOne = new Date(2021, 0, 21);
    FamilyCashTransferDTO transacaoDTO1 = new FamilyCashTransferDTO(testFamilyID, cc, cashAccountID, transferAmount, currency, categoryID, transactionDesignation, transactionDateOne);
    StandardCategory parentStandard = new StandardCategory("root", null, 1);
    StandardCategory categoria1 = new StandardCategory("Serviços", parentStandard, 2);

    @BeforeEach
    void setup() {
        testFamily.addFamilyMember(familyMember1);
        familyMember1.addAccount(cashAccount);
        familyMember1.addAccount(bankAccount);
        familyMember1.addAccount(bankSavingsAccount);
        familyMember1.addAccount(creditCardAccount);
    }

    @Test
    void checkIfEmptyListObtainedFromCashAccount() {
        int expected = 0;

        List<TransactionDataDTO> result = controller.getListOfMovementsBetweenDates(testFamilyID, cc, cashAccountID, startDateOne, endDateThree);

        assertNotNull(result);
        assertEquals(expected, result.size());
    }

    @Test
    void checkIfListObtainedFromCashAccount() {
        cashAccount.registerTransaction(cashAccount, categoria1,true,remainingBalance, transacaoDTO1);
        int expected = 1;

        List<TransactionDataDTO> result = controller.getListOfMovementsBetweenDates(testFamilyID, cc, cashAccountID, startDateOne, endDateThree);

        assertNotNull(result);
        assertEquals(expected, result.size());
    }

    @Test
    void checkIfEmptyListObtainedFromBankAccount() {
        int expected = 0;

        List<TransactionDataDTO> result = controller.getListOfMovementsBetweenDates(testFamilyID, cc, bankAccountID, startDateOne, endDateThree);

        assertNotNull(result);
        assertEquals(expected, result.size());
    }

    @Test
    void checkIfEmptyListObtainedFromSavingsAccount() {
        int expected = 0;

        List<TransactionDataDTO> result = controller.getListOfMovementsBetweenDates(testFamilyID, cc, bankSavingsAccountID, startDateOne, endDateThree);

        assertNotNull(result);
        assertEquals(expected, result.size());
    }

    @Test
    void checkIfEmptyListObtainedFromCreditCardAccount() {
        int expected = 0;

        List<TransactionDataDTO> result = controller.getListOfMovementsBetweenDates(testFamilyID, cc, creditCardAccountID, startDateOne, endDateThree);

        assertNotNull(result);
        assertEquals(expected, result.size());
    }

    @Test
    void checkIfNullWhenNoSuchMemberID() {
        assertNull(controller.getListOfMovementsBetweenDates(testFamilyID, "110142608ZZ1", cashAccountID, startDateOne, endDateThree));
    }

    @Test
    void checkIfNullWhenNoSuchFamilyID() {
        assertNull(controller.getListOfMovementsBetweenDates(11, cc, cashAccountID, startDateOne, endDateThree));
    }

    @Test
    void checkIfNullWhenNoSuchAccountID() {
        assertNull(controller.getListOfMovementsBetweenDates(testFamilyID, cc, 5, startDateOne, endDateThree));
    }

}