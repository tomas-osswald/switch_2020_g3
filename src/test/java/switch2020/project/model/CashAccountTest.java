package switch2020.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashAccountTest {

    @Test
    void constructorValidID() {
        assertDoesNotThrow(() -> {CashAccount cashAccountOne = new CashAccount(1);});
    }

    @Test
    void constructorInvalidID() {
        assertThrows(IllegalArgumentException.class, () -> {CashAccount cashAccountOne = new CashAccount(-1);});
    }

    @Test
    void constructorValidBalanceValidID() {
        assertDoesNotThrow(() -> {CashAccount cashAccountOne = new CashAccount(1, 1);});
    }

    @Test
    void constructorInvalidBalanceValidID() {
        assertThrows(IllegalArgumentException.class, () -> {CashAccount cashAccountOne = new CashAccount(1, -1);});
    }

    @Test
    void constructorValidBalanceInvalidID() {
        assertThrows(IllegalArgumentException.class, () -> {CashAccount cashAccountOne = new CashAccount(-1, 1);});
    }

    @Test
    void constructorInvalidBalanceInvalidID() {
        assertThrows(IllegalArgumentException.class, () -> {CashAccount cashAccountOne = new CashAccount(-1, -1);});
    }

    @Test
    void getCashAccountIDNoGivenID() {
        double balance = 0;
        CashAccount cashAccountZero = new CashAccount(balance);
        int expected = 0;

        int result = cashAccountZero.getCashAccountID();

        assertEquals(expected, result);
    }

    @Test
    void getCashAccountIDGivenIDOne() {
        CashAccount cashAccountOne = new CashAccount(1);
        int expected = 1;

        int result = cashAccountOne.getCashAccountID();

        assertEquals(expected, result);
    }

    @Test
    void getCashAccountIDGivenIDTwo() {
        CashAccount cashAccountTwo = new CashAccount(2);
        int expected = 2;

        int result = cashAccountTwo.getCashAccountID();

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
        assertThrows(IllegalStateException.class, () -> {cashAccountOne.changeBalance(-5.00);});
    }

}