package switchtwentytwenty.project.domain.model.accounts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.dtos.input.AddBankAccountDTO;
import switchtwentytwenty.project.domain.dtos.input.AddBankSavingsAccountDTO;
import switchtwentytwenty.project.domain.dtos.output.AccountIDAndDescriptionDTO;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BankSavingsAccountTest {

    //Accounts with positive balance and positive interestRate
    int testFamilyID = 1;
    String cc = "110142608ZZ0";

    int accountID = 1;
    String name = "Savings Account";
    Double balance = 1.23;
    Double interestRate = 3.00;
    AddBankSavingsAccountDTO addBankSavingsAccountDTO = new AddBankSavingsAccountDTO(balance, interestRate, name, cc, testFamilyID, CurrencyEnum.EURO);
    BankSavingsAccount accountPositive = new BankSavingsAccount(accountID, addBankSavingsAccountDTO);
    BankSavingsAccount accountPositiveTwo = new BankSavingsAccount(accountID, addBankSavingsAccountDTO);

    //Accounts with negative balance and negative interestRate
    int accountIDTwo = 2;
    String nameTwo = "Savings Account";
    Double balanceTwo = -1.23;
    Double interestRateTwo = -3.00;
    AddBankSavingsAccountDTO addBankSavingsAccountDTONegative = new AddBankSavingsAccountDTO(balanceTwo, interestRateTwo, nameTwo, cc, testFamilyID, CurrencyEnum.EURO);
    BankSavingsAccount accountNegative = new BankSavingsAccount(accountIDTwo, addBankSavingsAccountDTONegative);
    BankSavingsAccount accountNegativeTwo = new BankSavingsAccount(accountIDTwo, addBankSavingsAccountDTONegative);

    //Generic name 1 and 2
    String generic = "Bank Savings Account with ID 1";
    String genericTwo = "Bank Savings Account with ID 2";

    //Invalid input parameters
    String invalidName = null;
    Double invalidInterestRate = null;
    Double invalidBalance = null;
    AddBankSavingsAccountDTO addBankSavingsAccountDTOInvalidName = new AddBankSavingsAccountDTO(balance, interestRate, invalidName, cc, testFamilyID, CurrencyEnum.EURO);
    AddBankSavingsAccountDTO addBankSavingsAccountDTOInvalidNameTwo = new AddBankSavingsAccountDTO(balanceTwo, interestRateTwo, invalidName, cc, testFamilyID, CurrencyEnum.EURO);
    AddBankSavingsAccountDTO addBankSavingsAccountDTOInvalidInterestRate = new AddBankSavingsAccountDTO(balanceTwo, invalidInterestRate, invalidName, cc, testFamilyID, CurrencyEnum.EURO);
    AddBankSavingsAccountDTO addBankSavingsAccountDTOInvalidBalance = new AddBankSavingsAccountDTO(invalidBalance, interestRate, invalidName, cc, testFamilyID, CurrencyEnum.EURO);

    BankSavingsAccount invalidNameAccount = new BankSavingsAccount(accountID, addBankSavingsAccountDTOInvalidName);
    BankSavingsAccount invalidNameAccountTwo = new BankSavingsAccount(accountIDTwo, addBankSavingsAccountDTOInvalidNameTwo);
    BankSavingsAccount invalidInterestRateAccount = new BankSavingsAccount(accountIDTwo, addBankSavingsAccountDTOInvalidInterestRate);
    BankSavingsAccount invalidBalanceAccount = new BankSavingsAccount(accountIDTwo, addBankSavingsAccountDTOInvalidInterestRate);
    MoneyValue expectedPositiveMoneyValue = new MoneyValue(1.23, CurrencyEnum.EURO);
    MoneyValue expectedNegativeMoneyValue = new MoneyValue(-1.23, CurrencyEnum.EURO);
    MoneyValue zeroMoneyValue = new MoneyValue(0.00, CurrencyEnum.EURO);


    @Test
    void ConstructorSuccessPositiveInterestRate() {
        assertNotNull(accountPositive);
        assertEquals(accountPositive, accountPositiveTwo);
        assertNotSame(accountPositive, accountPositiveTwo);
    }

    @Test
    void ConstructorSuccessNegativeInterestRate() {
        assertNotNull(accountNegative);
        assertEquals(accountNegative, accountNegativeTwo);
        assertNotSame(accountNegative, accountNegativeTwo);
    }

    @Test
    void ConstructorInvalidNameChangedToDefault_TestOnlyDesignation() {
        String expected = genericTwo;
        String result = invalidNameAccountTwo.getAccountData().getDescription();
        assertEquals(expected, result);
    }

    @Test
    void ConstructorInvalidNameChangedToDefaultTwo() {
        AddBankSavingsAccountDTO addBankSavingsAccountDTO = new AddBankSavingsAccountDTO(balance, interestRate, generic, cc, testFamilyID, CurrencyEnum.EURO);
        BankSavingsAccount expected = new BankSavingsAccount(1, addBankSavingsAccountDTO);

        BankSavingsAccount result = invalidNameAccount;

        assertNotSame(expected, result);
        assertEquals(expected, result);
    }

    @Test
    void ConstructorInvalidInterestRateChangedToDefault() {
        AddBankSavingsAccountDTO addBankSavingsAccountDTO = new AddBankSavingsAccountDTO(balance, 0.00, generic, cc, testFamilyID, CurrencyEnum.EURO);
        BankSavingsAccount expected = new BankSavingsAccount(1, addBankSavingsAccountDTO);

        BankSavingsAccount result = new BankSavingsAccount(accountID, addBankSavingsAccountDTOInvalidInterestRate);

        assertEquals(expected.getInterestRate(), result.getInterestRate());
        assertNotSame(expected, result);
    }

    @Test
    void ConstructorInvalidBalanceChangedToDefault() {
        AddBankSavingsAccountDTO addBankSavingsAccountDTO = new AddBankSavingsAccountDTO(0.00, 3.00, generic, cc, testFamilyID, CurrencyEnum.EURO);
        BankSavingsAccount expected = new BankSavingsAccount(1, addBankSavingsAccountDTO);
        Double NullInterestRate = null;

        BankSavingsAccount result = new BankSavingsAccount(accountID, addBankSavingsAccountDTOInvalidBalance);

        assertEquals(expected.getInterestRate(), result.getInterestRate());
        assertNotSame(expected, result);
    }


    @Test
    void getInterestRatePositiveInterestRate() {
        int accountID = 1;
        String name = "Savings Account";
        Double balance = 1.23;
        Double interestRate = 3.00;
        AddBankSavingsAccountDTO addBankSavingsAccountDTO = new AddBankSavingsAccountDTO(balance, interestRate, name, cc, testFamilyID, CurrencyEnum.EURO);
        BankSavingsAccount account = new BankSavingsAccount(accountID, addBankSavingsAccountDTO);
        Double expected = 3.00;

        Double result = account.getInterestRate();

        assertEquals(expected, result, 0.01);
    }

    @Test
    void getInterestRateNegativeInterestRate() {
        Double expected = -3.00;

        Double result = accountNegative.getInterestRate();

        assertEquals(expected, result, 0.001);

    }

    @Test
    void getInterestRateZeroInterestRate() {
        Double expected = 0.00;
        AddBankSavingsAccountDTO addBankSavingsAccountDTO = new AddBankSavingsAccountDTO(balance, expected, name, cc, testFamilyID, CurrencyEnum.EURO);
        BankSavingsAccount expectedAccount = new BankSavingsAccount(accountID, addBankSavingsAccountDTO);

        Double result = expectedAccount.getInterestRate();

        assertEquals(expected, result, 0.001);
    }


    @Test
    void getAccountIDTestCorrectID() {
        int expectedID = 1;

        int result = accountPositive.getAccountID();

        assertEquals(expectedID, result);
    }

    @Test
    void getAccountIDTestIncorrectID() {
        int expectedID = 4;

        int result = accountPositive.getAccountID();

        assertNotEquals(expectedID, result);
    }


    @Test
    void getBalanceExpectingEqualsTrue() {
        Double expected = balance;

        Double result = accountPositive.getMoneyBalance().getValue();

        assertEquals(expected, result);
        assertNotNull(result);
    }

    @Test
    void getBalanceExpectingNotEquals() {
        Double expected = 9.00;

        Double result = accountPositive.getMoneyBalance().getValue();

        assertNotEquals(expected, result);
        assertNotNull(result);

    }

    @Test
    void changeBalanceAddingZeroExpectingEquals() {
        MoneyValue balanceChange = new MoneyValue(0.0, CurrencyEnum.EURO);
        Double expected = 1.23;

        accountPositive.credit(balanceChange);
        Double result = accountPositive.getMoneyBalance().getValue();

        assertEquals(expected, result);
        assertNotNull(result);
    }

    @Test
    void changeBalanceAddingPositiveNumberExpectingEquals() {
        MoneyValue balanceChange = new MoneyValue(1.0, CurrencyEnum.EURO);
        Double expected = 2.23;

        accountPositive.credit(balanceChange);
        Double result = accountPositive.getMoneyBalance().getValue();

        assertEquals(expected, result, 0.001);
        assertNotNull(result);
    }

    @Test
    void changeBalanceAddingNegativeNumberExpectingEquals() {
        MoneyValue balanceChange = new MoneyValue(1.0, CurrencyEnum.EURO);
        double expected = 0.23;

        accountPositive.debit(balanceChange);
        Double result = accountPositive.getMoneyBalance().getValue();

        assertEquals(expected, result, 0.001);
        assertNotNull(result);
    }


    @Test
    void changeBalanceExpectingNotEquals() {
        MoneyValue balanceChange = new MoneyValue(4.0, CurrencyEnum.EURO);
        double expected = 14.23;

        accountPositive.credit(balanceChange);
        Double result = accountPositive.getMoneyBalance().getValue();
        assertNotEquals(expected, result, 0.001);
        assertNotNull(result);
    }


    @Test
    void equalsTrueSameAccount() {
        BankSavingsAccount expected = accountPositive;
        BankSavingsAccount result = expected;
        assertEquals(expected, result);
        assertSame(expected, result);

    }

    @Test
    void equalsTrueDifferentAccounts() {
        BankSavingsAccount expected = accountPositive;
        BankSavingsAccount result = accountPositiveTwo;
        assertEquals(expected, result);
        assertEquals(expected.getInterestRate(), result.getInterestRate());
        assertEquals(expected.getAccountData(), result.getAccountData());
    }

    @Test
    void equalsFalseNotSameInstance() {
        AccountService expected = new AccountService();
        BankSavingsAccount result = accountPositiveTwo;
        assertNotEquals(result, expected);
    }

    @Test
    void equalsFalseNullObject() {
        BankSavingsAccount expected = null;
        BankSavingsAccount result = accountPositiveTwo;
        assertNotEquals(result, expected);
    }

    @Test
    void equalsFalseDifferentAccount() {
        BankSavingsAccount expected = accountPositive;
        BankSavingsAccount result = accountNegativeTwo;
        assertNotEquals(expected, result);
        assertNotEquals(accountPositive.getInterestRate(), accountNegativeTwo.getInterestRate());
        assertNotEquals(accountPositive.getAccountData(), accountNegativeTwo.getAccountData());
    }


    @Test
    void hasEnoughMoneyForTransaction_False() {
        BankSavingsAccount account = accountPositive;
        MoneyValue valueForTransaction = new MoneyValue(5.0, CurrencyEnum.EURO);

        boolean result = account.hasEnoughMoneyForTransaction(valueForTransaction);

        assertTrue(result);
    }

    @Test
    void hasEnoughMoneyForTransaction_True() {
        BankSavingsAccount account = accountPositive;
        MoneyValue valueForTransaction = new MoneyValue(0.25, CurrencyEnum.EURO);

        boolean result = account.hasEnoughMoneyForTransaction(valueForTransaction);

        assertTrue(result);
    }


    @Test
    void testHashCode() {
        BankSavingsAccount expected = accountPositive;
        BankSavingsAccount result = expected;
        assertEquals(expected.hashCode(), result.hashCode());
    }

    @Test
    void testHashCode_DifferentObjects() {
        BankSavingsAccount expected = new BankSavingsAccount(accountID, addBankSavingsAccountDTO);
        BankSavingsAccount result = new BankSavingsAccount(accountID, addBankSavingsAccountDTO);
        assertEquals(expected.hashCode(), result.hashCode());
    }

    @Test
    void testHashCode_DifferentObjects_TestZeroAccountID() {
        int notExpected = 0;
        BankSavingsAccount resultAccount = new BankSavingsAccount(accountID, addBankSavingsAccountDTO);
        int result = resultAccount.hashCode();

        assertNotEquals(notExpected, result);
    }

    @Test
    void testHashCode1() {
        BankSavingsAccount result = new BankSavingsAccount(accountID, addBankSavingsAccountDTO);

        int expected = 0;

        assertNotEquals(expected, result.hashCode());
    }

    @Test
    void checkCurrency() {

        BankSavingsAccount account = new BankSavingsAccount(accountID, addBankSavingsAccountDTO);
        boolean result = account.checkCurrency(CurrencyEnum.EURO);

        Assertions.assertTrue(result);
    }

    @Test
    void checkCurrencyEuro() {
        BankSavingsAccount bankSavingsAccount = new BankSavingsAccount(1, addBankSavingsAccountDTO);
        assertTrue(bankSavingsAccount.checkCurrency(CurrencyEnum.EURO));
    }

    @Test
    void checkCurrencyFalse() {
        BankSavingsAccount bankSavingsAccount = new BankSavingsAccount(1, addBankSavingsAccountDTO);

        assertFalse(bankSavingsAccount.checkCurrency(CurrencyEnum.YEN));
    }


    @Test
    void getDescriptionNotNull() {
        BankSavingsAccount bankSavingsAccount = new BankSavingsAccount(1, addBankSavingsAccountDTO);
        assertNotNull(bankSavingsAccount.getDescription());
    }

    @Test
    void getDescriptionEmpty() {
        AddBankSavingsAccountDTO addBankSavingsAccountDTO = new AddBankSavingsAccountDTO(balance, interestRate, "", cc, testFamilyID, CurrencyEnum.EURO);
        BankSavingsAccount bankSavingsAccount = new BankSavingsAccount(1, addBankSavingsAccountDTO);
        String notExpected = "";

        assertNotNull(bankSavingsAccount.getDescription());
        assertNotEquals(bankSavingsAccount.getDescription(), notExpected);
    }

    @Test
    void getAccountIDAndDescriptionDTO() {
        AddBankSavingsAccountDTO addBankSavingsAccountDTO = new AddBankSavingsAccountDTO(20.00, 1.00, "Conta", cc, testFamilyID, CurrencyEnum.EURO);
        BankSavingsAccount bankSavingsAccount = new BankSavingsAccount(1, addBankSavingsAccountDTO);

        AccountIDAndDescriptionDTO expected = new AccountIDAndDescriptionDTO(1, "Conta");

        AccountIDAndDescriptionDTO result = bankSavingsAccount.getAccountIDAndDescriptionDTO();

        assertEquals(expected, result);
        assertNotNull(result);
    }

    @Test
    void getAccountIDAndDescriptionDTONotEquals() {
        AddBankSavingsAccountDTO addBankSavingsAccountDTO = new AddBankSavingsAccountDTO(20.00, 1.00, "Conta", cc, testFamilyID, CurrencyEnum.EURO);
        BankSavingsAccount bankSavingsAccount = new BankSavingsAccount(1, addBankSavingsAccountDTO);

        AccountIDAndDescriptionDTO expected = new AccountIDAndDescriptionDTO(2, "Conta");


        AccountIDAndDescriptionDTO result = bankSavingsAccount.getAccountIDAndDescriptionDTO();


        assertNotEquals(expected, result);
        assertNotNull(result);
    }
}