package switchtwentytwenty.project.domain.model.accounts;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BankSavingsAccountTest {

    //Accounts with positive balance and positive interestRate
    int accountID = 1;
    String name = "Savings Account";
    Double balance = 1.23;
    Double interestRate = 3.00;
    BankSavingsAccount accountPositive = new BankSavingsAccount(accountID, name, balance, interestRate);
    BankSavingsAccount accountPositiveTwo = new BankSavingsAccount(accountID, name, balance, interestRate);

    //Accounts with negative balance and negative interestRate
    int accountIDTwo = 2;
    String nameTwo = "Savings Account";
    Double balanceTwo = -1.23;
    Double interestRateTwo = -3.00;
    BankSavingsAccount accountNegative = new BankSavingsAccount(accountIDTwo, nameTwo, balanceTwo, interestRateTwo);
    BankSavingsAccount accountNegativeTwo = new BankSavingsAccount(accountIDTwo, nameTwo, balanceTwo, interestRateTwo);

    //Generic name 1 and 2
    String generic = "Bank Savings Account with ID 1";
    String genericTwo = "Bank Savings Account with ID 2";

    //Invalid input parameters
    String invalidName = null;
    Double invalidInterestRate = null;
    Double invalidBalance = null;
    BankSavingsAccount invalidNameAccount = new BankSavingsAccount(accountID, invalidName, balance, interestRate);
    BankSavingsAccount invalidNameAccountTwo = new BankSavingsAccount(accountIDTwo, invalidName, balanceTwo, interestRateTwo);
    BankSavingsAccount invalidInterestRateAccount = new BankSavingsAccount(accountIDTwo, invalidName, balanceTwo, invalidInterestRate);
    BankSavingsAccount invalidBalanceAccount = new BankSavingsAccount(accountIDTwo, invalidName, invalidBalance, invalidInterestRate);
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
        BankSavingsAccount expected = new BankSavingsAccount(1,
                generic, 1.23, 3.00);

        BankSavingsAccount result = invalidNameAccount;

        assertNotSame(expected, result);
        assertEquals(expected, result);
    }

    @Test
    void ConstructorInvalidInterestRateChangedToDefault() {
        BankSavingsAccount expected = new BankSavingsAccount(1,
                generic, 1.23, 0.00);

        BankSavingsAccount result = new BankSavingsAccount(accountID, generic, balance, invalidInterestRate);

        assertEquals(expected.getInterestRate(), result.getInterestRate());
        assertNotSame(expected, result);
    }

    @Test
    void ConstructorInvalidBalanceChangedToDefault() {
        BankSavingsAccount expected = new BankSavingsAccount(1,
                "Bank Savings Account with ID 1", 0.00, 3.00);
        Double NullInterestRate = null;

        BankSavingsAccount result = new BankSavingsAccount(accountID, generic, invalidBalance, interestRate);

        assertEquals(expected.getInterestRate(), result.getInterestRate());
        assertNotSame(expected, result);
    }


    @Test
    void getInterestRatePositiveInterestRate() {
        int accountID = 1;
        String name = "Savings Account";
        Double balance = 1.23;
        Double interestRate = 3.00;
        BankSavingsAccount account = new BankSavingsAccount(accountID, name, balance, interestRate);
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
        BankSavingsAccount expectedAccount = new BankSavingsAccount(accountID, name, balance, expected);

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
    }

    @Test
    void equalsFalseNotSameInstance() {
        AccountService expected = new AccountService();
        BankSavingsAccount result = accountPositiveTwo;
        assertNotSame(expected, result);
        assertNotEquals(expected, result);
    }

    @Test
    void equalsFalseNullObject() {
        BankSavingsAccount expected = null;
        BankSavingsAccount result = accountPositiveTwo;
        assertNotEquals(expected, result);
    }

    @Test
    void equalsFalseDifferentAccount() {
        BankSavingsAccount expected = accountPositive;
        BankSavingsAccount result = accountNegativeTwo;
        assertNotEquals(expected, result);
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
        BankSavingsAccount expected = new BankSavingsAccount(accountID, name, balance, interestRate);
        BankSavingsAccount result = new BankSavingsAccount(accountID, name, balance, interestRate);
        assertEquals(expected.hashCode(), result.hashCode());
    }


}