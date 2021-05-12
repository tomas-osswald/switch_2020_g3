package switchtwentytwenty.project.domain.aggregates.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.valueobject.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CashAccountTest {

    AccountID accountID = new AccountID(100L);
    OwnerID ownerID = new PersonID("tonyZe@gmail.com");
    Designation designation = new Designation("Fágêsse");
    Balance balance = new Balance();
    List<Movement> movements = new ArrayList<>();
    String accountType = "CashAccount";
    BigDecimal amount = new BigDecimal("3");
    Monetary monetary = new Monetary("EUR", amount);
    Movement movement = new Movement(monetary);
    
    AccountID otherAccountID = new AccountID(123L);

    @Test
    void getIDTest() {
        IAccount accountOne = new CashAccount();
        accountOne.setAccountID(accountID);

        AccountID expected = new AccountID(100L);
        AccountID result = accountOne.id();

        assertEquals(expected, result);
        assertNotSame(expected, result);
    }
    @Test
    void getOwnerIdTest() {
        IAccount accountOne = new CashAccount();
        accountOne.setOwner(ownerID);

        OwnerID expected = new PersonID("tonyZe@gmail.com");
        OwnerID result = accountOne.getOwnerId();

        assertEquals(expected, result);
        assertNotSame(expected, result);
    }

    @Test
    void getDesignationTest() {
        Designation designationOne = new Designation("Fágêsse");
        IAccount accountOne = new CashAccount();
        accountOne.setDesignation(designationOne);

        assertEquals(accountOne.getDesignation(), designationOne);
    }


    // TODO: Add changeBalance method to CashAccount and complete de test
    @Test
    void getBalanceSameTest() {
        BigDecimal amount = new BigDecimal("3");
        Monetary balance = new Monetary("EUR",amount);
        IAccount accountOne = new CashAccount();

    }

    @Test
    void getAccountTypeTest() {
        String otherAccount = "Cash Account";
        IAccount accountOne = new CashAccount();

        assertEquals(accountOne.getAccountType(), otherAccount);
    }


    @Test
    void setAccountIDTest() {
        IAccount accountOne = new CashAccount();
        IAccount accountTwo = new CashAccount();
        accountOne.setAccountID(accountID);
        accountTwo.setAccountID(accountID);

        assertEquals(accountOne.id(), accountTwo.id());
    }

    @Test
    void setOwnerTest() {
        IAccount accountOne = new CashAccount();
        IAccount accountTwo = new CashAccount();
        accountOne.setOwner(ownerID);
        accountTwo.setOwner(ownerID);

        assertEquals(accountOne.getOwnerId(), accountTwo.getOwnerId());
    }

    @Test
    void setDesignationTest() {
        IAccount accountOne = new CashAccount();
        IAccount accountTwo = new CashAccount();
        accountOne.setDesignation(designation);
        accountTwo.setDesignation(designation);

        assertEquals(accountOne.getDesignation(), accountTwo.getDesignation());
    }

    /*
    @Test
    void setMovementsTest() {
        IAccount accountOne = new CashAccount();
        IAccount accountTwo = new CashAccount();
        accountOne.setMovements(movements);
        accountTwo.setMovements(movements);

        //assertNotEquals(accountOne, accountTwo);
    }
     */

    @Test
    void addMovementTest() {
        IAccount accountOne = new CashAccount(ownerID, designation);

        movements.add(movement);
        List<Movement> expected = movements;

        accountOne.addMovement(movement);
        List<Movement> result = accountOne.getListOfMovements();

        Assertions.assertEquals(expected, result);
    }

    @Test
    void hasIDTrueTest() {
        IAccount accountOne = new CashAccount(ownerID, designation);
        accountOne.setAccountID(accountID);

        assertTrue(accountOne.hasID(accountID));
    }
    @Test
    void hasIDFalseTest() {
        IAccount accountOne = new CashAccount(ownerID, designation);
        accountOne.setAccountID(accountID);

        assertFalse(accountOne.hasID(otherAccountID));
    }
    @Test
    void equalsCashAccountTest(){
        IAccount accountOne = new CashAccount(ownerID, designation);
        IAccount accountTwo = new CashAccount(ownerID, designation);

        Assertions.assertEquals(accountOne, accountTwo);
        assertNotSame(accountOne, accountTwo);
    }
    @Test
    void equalsCashAccountAllArgsTest(){
        IAccount accountOne = new CashAccount(accountID, ownerID, designation, movements);
        IAccount accountTwo = new CashAccount(accountID, ownerID, designation, movements);

        Assertions.assertEquals(accountOne, accountTwo);
        assertNotSame(accountOne, accountTwo);
    }
    @Test
    void equalsCashAccountNoArgsTest(){
        IAccount accountOne = new CashAccount();
        IAccount accountTwo = new CashAccount();

        Assertions.assertEquals(accountOne, accountTwo);
        assertNotSame(accountOne, accountTwo);
    }
    @Test
    void equalsCashAccountIsSameTest(){
        IAccount accountOne = new CashAccount(ownerID, designation);
        IAccount accountTwo = accountOne;

        Assertions.assertEquals(accountOne, accountTwo);
        assertSame(accountOne, accountTwo);
    }
    @Test
    void equalsCashAccountAllIsDifferentTest(){
        IAccount accountOne = new CashAccount(ownerID, designation);
        accountOne.setAccountID(accountID);
        IAccount accountTwo = new CashAccount(ownerID, designation);
        accountTwo.setAccountID(otherAccountID);

        assertNotEquals(accountOne, accountTwo);
    }
    @Test
    void equalsCashAccountIsDifferentClassTest(){
        IAccount accountOne = new CashAccount(ownerID, designation);

        assertNotEquals(accountOne, accountID);
        assertNotSame(accountOne, accountID);
    }
    @Test
    void equalsCashAccountIsDifferentFromNullTest(){
        IAccount accountOne = new CashAccount(ownerID, designation);
        String nullString = null;

        assertNotEquals(accountOne, nullString);
        assertNotSame(accountOne, nullString);
    }
    @Test
    void hashCodeCashAccountIsEqualsTest() {
        IAccount accountOne = new CashAccount(ownerID, designation);
        IAccount accountTwo = new CashAccount(ownerID, designation);

        Assertions.assertEquals(accountOne.hashCode(), accountTwo.hashCode());
        assertNotSame(accountOne, accountTwo);
    }
    @Test
    void hashCodeCashAccountIsDifferentTest() {
        IAccount accountOne = new CashAccount(ownerID, designation);
        accountOne.setAccountID(accountID);
        IAccount accountTwo = new CashAccount(ownerID, designation);
        accountTwo.setAccountID(otherAccountID);

        assertNotEquals(accountOne.hashCode(), accountTwo.hashCode());
    }

}