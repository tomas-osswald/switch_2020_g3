package switchtwentytwenty.project.domain.model.accounts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.services.FamilyService;

import static org.junit.jupiter.api.Assertions.*;

class CashAccountTest {

    @Test
    void constructorValidBalanceOne() {
        double balance = 1.00;
        String designation = "My Cash Account";
        int cashAccountID = 1001;
        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID);

        Assertions.assertNotNull(cashAccountOne);
    }

    @Test
    void constructorValidBalanceSevenPointTwoFive() {
        double balance = 7.25;
        String designation = "Second Cash Account";
        int cashAccountID = 1011;

        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID);

        Assertions.assertNotNull(cashAccountOne);
    }

    @Test
    void constructorValidBalanceOneMillionPointSevenOne() {
        double balance = 1000000.71;
        String designation = "My Cash Account";
        int cashAccountID = 1001;

        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID);

        Assertions.assertNotNull(cashAccountOne);
    }

    @Test
    void constructorInvalidBalanceMinusOne() {
        double balance = -1.00;
        String designation = "My Cash Account";
        int cashAccountID = 1001;

        assertThrows(IllegalArgumentException.class, () -> {
            CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID);
        });
    }

    @Test
    void constructorInvalidBalanceMinusTwoHundredPointThree() {
        double balance = -200.03;
        String designation = "My Cash Account";
        int cashAccountID = 1001;

        assertThrows(IllegalArgumentException.class, () -> {
            CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID);
        });
    }

    @Test
    void constructorDesignationNull() {
        double balance = 12.5;
        String designation = null;
        int cashAccountID = 1001;

        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID);

        Assertions.assertNotNull(cashAccountOne);
    }

    @Test
    void constructorDesignationEmpty() {
        double balance = 12.5;
        String designation = "";
        int cashAccountID = 1001;

        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID);

        Assertions.assertNotNull(cashAccountOne);
    }

    @Test
    void constructorDesignationBlank() {
        double balance = 12.5;
        String designation = "  ";
        int cashAccountID = 1001;

        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID);

        Assertions.assertNotNull(cashAccountOne);
    }

    @Test
    void getCashAccountIDGivenIDOneThousandAndOne() {
        double balance = 0;
        String designation = "Account";
        int cashAccountID = 1001;
        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID);
        int expected = 1001;

        int result = cashAccountOne.getAccountID();

        assertEquals(expected, result);
    }

    @Test
    void getCashAccountIDGivenIDOneThousandAndTwo() {
        double balance = 0;
        String designation = "Account";
        int cashAccountID = 1002;
        CashAccount cashAccountTwo = new CashAccount(designation, balance, cashAccountID);
        int expected = 1002;

        int result = cashAccountTwo.getAccountID();

        assertEquals(expected, result);
    }

    @Test
    void getBalance() {
        double balance = 10;
        String designation = "Account";
        int cashAccountID = 1002;
        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID);
        double expected = 10;

        double result = cashAccountOne.getBalance();

        assertEquals(expected, result, 0.001);
    }

    @Test
    void changeBalanceByFive() {
        double balance = 10;
        String designation = "Account";
        int cashAccountID = 1002;
        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID);
        double expected = 15;

        cashAccountOne.changeBalance(5.00);
        double result = cashAccountOne.getBalance();

        assertEquals(expected, result, 0.001);
    }

    @Test
    void changeBalanceByMinusFive() {
        double balance = 10;
        String designation = "Account";
        int cashAccountID = 1002;
        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID);
        double expected = 5;

        cashAccountOne.changeBalance(-5.00);
        double result = cashAccountOne.getBalance();

        assertEquals(expected, result, 0.001);
    }

    @Test
    void changeBalanceInvalidNegativeBalance() {
        double balance = 10;
        String designation = "Account";
        int cashAccountID = 1002;
        CashAccount cashAccountOne = new CashAccount(designation, balance, cashAccountID);
        assertThrows(IllegalStateException.class, () -> {
            cashAccountOne.changeBalance(-15.00);
        });
    }

    @Test
    void equalsTrueItself() {
        CashAccount one = new CashAccount("Account",1, 1);

        assertTrue(one.equals(one));
    }

    @Test
    void equalsFalseNotCashAccountObject() {
        CashAccount one = new CashAccount("Account",1, 1);
        FamilyService familyService = new FamilyService();

        assertFalse(one.equals(familyService));
    }

    @Test
    void equalsTrueSameBalanceAndID() {
        CashAccount one = new CashAccount("Account",1, 1);
        CashAccount two = new CashAccount("Account",1, 1);

        assertTrue(one.equals(two));
    }

    @Test
    void equalsFalseSameBalanceDifferentID() {
        CashAccount one = new CashAccount("Account",1, 1);
        CashAccount two = new CashAccount("Account",5, 1);

        assertFalse(one.equals(two));
    }

    @Test
    void equalsFalseDifferentBalanceSameID() {
        CashAccount one = new CashAccount("Account",1, 1);
        CashAccount two = new CashAccount("Account",1.01, 1);

        assertFalse(one.equals(two));
    }

}