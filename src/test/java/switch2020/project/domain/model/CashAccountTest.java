package switch2020.project.domain.model;

import org.junit.jupiter.api.Test;
import switch2020.project.domain.services.FamilyService;

import static org.junit.jupiter.api.Assertions.*;

class CashAccountTest {

    @Test
    void constructorValidBalanceOne() {
        assertDoesNotThrow(() -> {
            CashAccount cashAccountOne = new CashAccount(1.00);
        });
    }

    @Test
    void constructorValidBalanceSevenPointTwoFive() {
        assertDoesNotThrow(() -> {
            CashAccount cashAccountOne = new CashAccount(7.25);
        });
    }

    @Test
    void constructorValidBalanceOneMillionPointSevenOne() {
        assertDoesNotThrow(() -> {
            CashAccount cashAccountOne = new CashAccount(1000000.71);
        });
    }

    @Test
    void constructorInvalidBalanceMinusOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            CashAccount cashAccountOne = new CashAccount(-1.00);
        });
    }

    @Test
    void constructorInvalidBalanceMinusTwoHundredPointThree() {
        assertThrows(IllegalArgumentException.class, () -> {
            CashAccount cashAccountOne = new CashAccount(-200.3);
        });
    }

    @Test
    void constructorInvalidBalanceMinusSevenThousandThirtyFourPointFiveThree() {
        assertThrows(IllegalArgumentException.class, () -> {
            CashAccount cashAccountOne = new CashAccount(-7034.53);
        });
    }

    @Test
    void constructorValidIDOne() {
        assertDoesNotThrow(() -> {
            CashAccount cashAccountOne = new CashAccount(1);
        });
    }

    @Test
    void constructorValidIDZero() {
        assertDoesNotThrow(() -> {
            CashAccount cashAccountOne = new CashAccount(0);
        });
    }

    @Test
    void constructorValidIDThousand() {
        assertDoesNotThrow(() -> {
            CashAccount cashAccountOne = new CashAccount(1000);
        });
    }

    @Test
    void constructorInvalidIDNegativeOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            CashAccount cashAccountOne = new CashAccount(-1);
        });
    }

    @Test
    void constructorInvalidIDNegativeTen() {
        assertThrows(IllegalArgumentException.class, () -> {
            CashAccount cashAccountOne = new CashAccount(-10);
        });
    }

    @Test
    void constructorInvalidIDNegativeThousand() {
        assertThrows(IllegalArgumentException.class, () -> {
            CashAccount cashAccountOne = new CashAccount(-1000);
        });
    }

    @Test
    void constructorValidBalanceValidID() {
        assertDoesNotThrow(() -> {
            CashAccount cashAccountOne = new CashAccount(10, 1);
        });
    }

    @Test
    void constructorInvalidBalanceValidID() {
        assertThrows(IllegalArgumentException.class, () -> {
            CashAccount cashAccountOne = new CashAccount(1, -1);
        });
    }

    @Test
    void constructorValidBalanceInvalidID() {
        assertThrows(IllegalArgumentException.class, () -> {
            CashAccount cashAccountOne = new CashAccount(-1, 1);
        });
    }

    @Test
    void constructorInvalidBalanceInvalidID() {
        assertThrows(IllegalArgumentException.class, () -> {
            CashAccount cashAccountOne = new CashAccount(-111, -1);
        });
    }

    @Test
    void getCashAccountIDNoGivenID() {
        double balance = 0;
        CashAccount cashAccountZero = new CashAccount(balance);
        int expected = 0;

        int result = cashAccountZero.getAccountID();

        assertEquals(expected, result);
    }

    @Test
    void getCashAccountIDGivenIDOne() {
        CashAccount cashAccountOne = new CashAccount(1);
        int expected = 1;

        int result = cashAccountOne.getAccountID();

        assertEquals(expected, result);
    }

    @Test
    void getCashAccountIDGivenIDTwo() {
        CashAccount cashAccountTwo = new CashAccount(2);
        int expected = 2;

        int result = cashAccountTwo.getAccountID();

        assertEquals(expected, result);
    }

    @Test
    void getBalance() {
        CashAccount cashAccountOne = new CashAccount(1);
        double expected = 0;

        double result = cashAccountOne.getBalance();

        assertEquals(expected, result, 0.001);
    }

    @Test
    void changeBalanceByFive() {
        CashAccount cashAccountOne = new CashAccount(1);
        double expected = 5;

        cashAccountOne.changeBalance(5.00);
        double result = cashAccountOne.getBalance();

        assertEquals(expected, result, 0.001);
    }

    @Test
    void changeBalanceByMinusFive() {
        CashAccount cashAccountOne = new CashAccount(1, 5);
        double expected = 0;

        cashAccountOne.changeBalance(-5.00);
        double result = cashAccountOne.getBalance();

        assertEquals(expected, result, 0.001);
    }

    @Test
    void changeBalanceInvalidNegativeBalance() {
        CashAccount cashAccountOne = new CashAccount(1);
        assertThrows(IllegalStateException.class, () -> {
            cashAccountOne.changeBalance(-5.00);
        });
    }

    @Test
    void equalsTrueItself() {
        CashAccount one = new CashAccount(1, 1);

        assertTrue(one.equals(one));
    }

    @Test
    void equalsFalseNotCashAccountObject() {
        CashAccount one = new CashAccount(1, 1);
        FamilyService familyService = new FamilyService();

        assertFalse(one.equals(familyService));
    }

    @Test
    void equalsTrueSameBalanceAndID() {
        CashAccount one = new CashAccount(1, 1);
        CashAccount two = new CashAccount(1, 1);

        assertTrue(one.equals(two));
    }

    @Test
    void equalsFalseSameBalanceDifferentID() {
        CashAccount one = new CashAccount(1, 1);
        CashAccount two = new CashAccount(5, 1);

        assertFalse(one.equals(two));
    }

    @Test
    void equalsFalseDifferentBalanceSameID() {
        CashAccount one = new CashAccount(1, 1);
        CashAccount two = new CashAccount(1, 1.01);

        assertFalse(one.equals(two));
    }

}