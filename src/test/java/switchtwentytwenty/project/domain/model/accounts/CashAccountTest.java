package switchtwentytwenty.project.domain.model.accounts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.services.FamilyService;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import static org.junit.jupiter.api.Assertions.*;
import static switchtwentytwenty.project.domain.model.accounts.AccountTypeEnum.CASHACCOUNT;
import static switchtwentytwenty.project.domain.model.accounts.AccountTypeEnum.CREDITCARDACCOUNT;

class CashAccountTest {

    CurrencyEnum currency = CurrencyEnum.EURO;

    @Test
    void constructorValidBalanceOne() {
        double balance = 1.00;
        String designation = "My Cash Account";
        int cashAccountID = 1001;
        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID,currency);

        Assertions.assertNotNull(cashAccountOne);
    }

    @Test
    void constructorValidBalanceSevenPointTwoFive() {
        double balance = 7.25;
        String designation = "Second Cash Account";
        int cashAccountID = 1011;

        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID,currency);

        Assertions.assertNotNull(cashAccountOne);
    }

    @Test
    void constructorValidBalanceOneMillionPointSevenOne() {
        double balance = 1000000.71;
        String designation = "My Cash Account";
        int cashAccountID = 1001;

        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID,currency);

        Assertions.assertNotNull(cashAccountOne);
    }

    @Test
    void constructorInvalidBalanceMinusOne() {
        double balance = -1.00;
        String designation = "My Cash Account";
        int cashAccountID = 1001;

        assertThrows(IllegalArgumentException.class, () -> {
            CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID,currency);
        });
    }

    @Test
    void constructorInvalidBalanceMinusTwoHundredPointThree() {
        double balance = -200.03;
        String designation = "My Cash Account";
        int cashAccountID = 1001;

        assertThrows(IllegalArgumentException.class, () -> {
            CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID,currency);
        });
    }

    @Test
    void constructorDesignationNull() {
        double balance = 12.5;
        String designation = null;
        int cashAccountID = 1001;

        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID,currency);

        Assertions.assertNotNull(cashAccountOne);
    }

    @Test
    void constructorDesignationEmpty() {
        double balance = 12.5;
        String designation = "";
        int cashAccountID = 1001;

        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID,currency);

        Assertions.assertNotNull(cashAccountOne);
    }

    @Test
    void constructorDesignationBlank() {
        double balance = 12.5;
        String designation = "  ";
        int cashAccountID = 1001;

        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID,currency);

        Assertions.assertNotNull(cashAccountOne);
    }

    @Test
    void getCashAccountIDGivenIDOneThousandAndOne() {
        double balance = 0;
        String designation = "Account";
        int cashAccountID = 1001;
        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID,currency);
        int expected = 1001;

        int result = cashAccountOne.getAccountID();

        assertEquals(expected, result);
    }

    @Test
    void getCashAccountIDGivenIDOneThousandAndTwo() {
        double balance = 0;
        String designation = "Account";
        int cashAccountID = 1002;
        CashAccount cashAccountTwo = new CashAccount(designation, balance, cashAccountID,currency);
        int expected = 1002;

        int result = cashAccountTwo.getAccountID();

        assertEquals(expected, result);
    }

    @Test
    void getBalance() {
        double balance = 10;
        String designation = "Account";
        int cashAccountID = 1002;
        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID,currency);
        double expected = 10;

        double result = cashAccountOne.getMoneyBalance().getValue();

        assertEquals(expected, result, 0.001);
    }

    @Test
    void changeBalanceByFive() {
        double balance = 10;
        String designation = "Account";
        int cashAccountID = 1002;
        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID,currency);
        double expected = 15;

        cashAccountOne.credit(new MoneyValue(5.0, CurrencyEnum.EURO));
        double result = cashAccountOne.getMoneyBalance().getValue();

        assertEquals(expected, result, 0.001);
    }

    @Test
    void changeBalanceByMinusFive() {
        double balance = 10;
        String designation = "Account";
        int cashAccountID = 1002;
        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID,currency);
        double expected = 5;

        cashAccountOne.debit(new MoneyValue(5.0, CurrencyEnum.EURO));
        double result = cashAccountOne.getMoneyBalance().getValue();

        assertEquals(expected, result, 0.001);
    }

    @Test
    void changeBalanceInvalidNegativeBalance() {
        double balance = 10;
        String designation = "Account";
        int cashAccountID = 1002;
        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID,currency);
        assertThrows(IllegalStateException.class, () -> {
            cashAccountOne.debit(new MoneyValue(15.0, CurrencyEnum.EURO));
        });
    }

    @Test
    void equalsTrueItself() {
        CashAccount one = new CashAccount("Account", 1, 1,currency);

        assertTrue(one.equals(one));
    }

    @Test
    void equalsFalseNotCashAccountObject() {
        CashAccount one = new CashAccount("Account", 1, 1,currency);
        FamilyService familyService = new FamilyService();

        assertFalse(one.equals(familyService));
    }

    @Test
    void equalsTrueSameBalanceAndID() {
        CashAccount one = new CashAccount("Account", 1, 1,currency);
        CashAccount two = new CashAccount("Account", 1, 1,currency);

        assertTrue(one.equals(two));
    }

    @Test
    void equalsFalseSameBalanceDifferentID() {
        CashAccount one = new CashAccount("Account", 1, 1,currency);
        CashAccount two = new CashAccount("Account", 5, 1,currency);

        assertFalse(one.equals(two));
    }

    @Test
    void equalsFalseDifferentBalanceSameID() {
        CashAccount one = new CashAccount("Account", 1, 1,currency);
        CashAccount two = new CashAccount("Account", 1.01, 1,currency);

        assertFalse(one.equals(two));
    }


    @Test
    void checkAccountType_CashAccount_ExpectingTrue() {
        //Arrange
        CashAccount cashAccount = new CashAccount("cash", 200.00, 1,currency);
        AccountTypeEnum expectedType = CASHACCOUNT;
        //Act
        boolean result = cashAccount.checkAccountType(expectedType);
        //Assert
        assertTrue(result);
    }

    @Test
    void checkAccountType_CashAccount_ExpectingFalse() {
        //Arrange
        CashAccount cashAccount = new CashAccount("cash", 200.00, 1,currency);
        AccountTypeEnum expectedType = CREDITCARDACCOUNT;
        //Act
        boolean result = cashAccount.checkAccountType(expectedType);
        //Assert
        assertFalse(result);
    }

    @Test
    void checkAccountType_CashAccount_ExpectingFalseWithOtherType() {
        //Arrange
        CashAccount cashAccount = new CashAccount("cash", 200.00, 1,currency);
        AccountTypeEnum expectedType = CREDITCARDACCOUNT;
        //Act
        boolean result = cashAccount.checkAccountType(expectedType);
        //Assert
        assertFalse(result);
    }


    @Test
    void hasEnoughMoneyForTransaction() {
        MoneyValue transferenceAmount = new MoneyValue(10.0, CurrencyEnum.EURO);
        CashAccount cashAccount = new CashAccount("Acc", 50, 1,currency);
        assertTrue(cashAccount.hasEnoughMoneyForTransaction(transferenceAmount));
    }

    @Test
    void NotEnoughMoneyForTransaction() {
        MoneyValue transferenceAmount = new MoneyValue(100.0, CurrencyEnum.EURO);
        CashAccount cashAccount = new CashAccount("Acc", 50, 1,currency);
        assertFalse(cashAccount.hasEnoughMoneyForTransaction(transferenceAmount));
    }

    @Test
    void NotEnoughMoneyForTransaction_NegativeAmmount() {
        MoneyValue transferenceAmount = new MoneyValue(-10.0, CurrencyEnum.EURO);
        CashAccount cashAccount = new CashAccount("Acc", 50, 1,currency);
        assertThrows(IllegalArgumentException.class, () -> {
            cashAccount.hasEnoughMoneyForTransaction(transferenceAmount);
        });
    }

}