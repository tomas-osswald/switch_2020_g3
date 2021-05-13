package switchtwentytwenty.project.domain.aggregates.account;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.valueobject.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardAccountTest {
    Long id = 66L;
    AccountID accountID = new AccountID(id);
    OwnerID personID = new PersonID("tonyze@latinlover.com");
    Designation designation = new Designation("noitadas");

    Long otherID = 99L;
    AccountID otherAccountID = new AccountID(otherID);

    String currency = new String("EUR");
    BigDecimal amount = new BigDecimal("66.6");
    BigDecimal otherAmount = new BigDecimal("99.9");
    Monetary monetaryOne = new Monetary(currency, amount);
    Movement movementOne = new Movement(monetaryOne);
    Monetary monetaryTwo = new Monetary(currency, otherAmount);
    Movement movementTwo = new Movement(monetaryTwo);
    List<Movement> movementList = new ArrayList<>();
    List<Movement> otherMovementList = new ArrayList<>();

    @Test
    void getAccountIDTest() {
        IAccount creditCardAccount = new CreditCardAccount(personID, designation);
        creditCardAccount.setAccountID(accountID);

        AccountID expected = accountID;

        AccountID result = creditCardAccount.id();

        assertEquals(expected, result);
    }
    @Test
    void getOwnerIDTest() {
        IAccount creditCardAccount = new CreditCardAccount(personID, designation);

        OwnerID expected = new PersonID("tonyze@latinlover.com");

        OwnerID result = creditCardAccount.getOwnerId();

        assertEquals(expected, result);
        assertNotSame(expected, result);
    }
    @Test
    void getDesignationTest() {
        IAccount creditCardAccount = new CreditCardAccount();
        creditCardAccount.setDesignation(designation);

        Designation expected = designation;

        Designation result = creditCardAccount.getDesignation();

        assertEquals(expected, result);
    }
    @Test
    void getListOfMovementsTest() {
        IAccount creditCardAccount = new CreditCardAccount(personID, designation);

        movementList.add(movementOne);
        movementList.add(movementTwo);
        creditCardAccount.setMovements(movementList);

        List<Movement> expected = movementList;

        List<Movement> result = creditCardAccount.getListOfMovements();

        assertEquals(expected, result);
    }
    @Test
    void getListOfMovementsTestEmptyList() {
        IAccount creditCardAccount = new CreditCardAccount(personID, designation);

        List<Movement> expected = new ArrayList<>();

        List<Movement> result = creditCardAccount.getListOfMovements();

        assertEquals(expected, result);
    }

    @Test
    void getAccountTypeTest() {
        IAccount creditCardAccount = new CreditCardAccount();

        String expected = "Credit Card Account";

        String result = creditCardAccount.getAccountType();

        assertEquals(expected, result);
    }
    @Test
    void setOwnerTest() {
        IAccount creditCardAccountOne = new CreditCardAccount();
        creditCardAccountOne.setOwner(personID);

        OwnerID expected = new PersonID("tonyze@latinlover.com");

        OwnerID result = creditCardAccountOne.getOwnerId();

        assertEquals(expected, result);
        assertNotSame(expected, result);
    }
    @Test
    void setDesignation() {
        IAccount creditCardAccountOne = new CreditCardAccount();
        creditCardAccountOne.setDesignation(designation);

        Designation expected = new Designation("noitadas");

        Designation result = creditCardAccountOne.getDesignation();

        assertEquals(expected, result);
        assertNotSame(expected, result);
    }
    @Test
    void addMovementTest(){
        IAccount creditCardAccount = new CreditCardAccount(personID, designation);

        movementList.add(movementOne);
        movementList.add(movementTwo);
        List<Movement> expected = movementList;

        creditCardAccount.addMovement(movementOne);
        creditCardAccount.addMovement(movementTwo);
        List<Movement> result = creditCardAccount.getListOfMovements();

        assertEquals(expected, result);
    }
    @Test
    void hasIDTrueTest() {
        IAccount creditCardAccountOne = new CreditCardAccount(personID, designation);
        creditCardAccountOne.setAccountID(accountID);

        assertTrue(creditCardAccountOne.hasID(accountID));
    }
    @Test
    void hasIDFalseTest() {
        IAccount creditCardAccountOne = new CreditCardAccount(personID, designation);
        creditCardAccountOne.setAccountID(accountID);

        assertFalse(creditCardAccountOne.hasID(otherAccountID));
    }
    @Test
    void equalsCreditCardAccountTest(){
        IAccount creditCardAccountOne = new CreditCardAccount(personID, designation);
        IAccount creditCardAccountTwo = new CreditCardAccount(personID, designation);

        assertEquals(creditCardAccountOne, creditCardAccountTwo);
        assertNotSame(creditCardAccountOne, creditCardAccountTwo);
    }
    @Test
    void equalsCreditCardAccountAllArgsTest(){
        IAccount creditCardAccountOne = new CreditCardAccount(accountID, personID, designation, movementList);
        IAccount creditCardAccountTwo = new CreditCardAccount(accountID, personID, designation, movementList);

        assertEquals(creditCardAccountOne, creditCardAccountTwo);
        assertNotSame(creditCardAccountOne, creditCardAccountTwo);
    }
    @Test
    void equalsCreditCardAccountNoArgsTest(){
        IAccount creditCardAccountOne = new CreditCardAccount();
        IAccount creditCardAccountTwo = new CreditCardAccount();

        assertEquals(creditCardAccountOne, creditCardAccountTwo);
        assertNotSame(creditCardAccountOne, creditCardAccountTwo);
    }
    @Test
    void equalsCreditCardAccountIsSameTest(){
        IAccount creditCardAccountOne = new CreditCardAccount(personID, designation);
        IAccount creditCardAccountTwo = creditCardAccountOne;

        assertEquals(creditCardAccountOne, creditCardAccountTwo);
        assertSame(creditCardAccountOne, creditCardAccountTwo);
    }
    @Test
    void equalsCreditCardAccountAllIsDifferentTest(){
        IAccount creditCardAccountOne = new CreditCardAccount(personID, designation);
        creditCardAccountOne.setAccountID(accountID);
        IAccount creditCardAccountTwo = new CreditCardAccount(personID, designation);
        creditCardAccountTwo.setAccountID(otherAccountID);

        assertNotEquals(creditCardAccountOne, creditCardAccountTwo);
    }
    @Test
    void equalsCreditCardAccountIsDifferentClassTest(){
        IAccount creditCardAccountOne = new CreditCardAccount(personID, designation);

        assertNotEquals(creditCardAccountOne, accountID);
        assertNotSame(creditCardAccountOne, accountID);
    }
    @Test
    void equalsCreditCardAccountIsDifferentFromNullTest(){
        IAccount creditCardAccountOne = new CreditCardAccount(personID, designation);
        String nullString = null;

        assertNotEquals(creditCardAccountOne, nullString);
        assertNotSame(creditCardAccountOne, nullString);
    }
    @Test
    void hashCodeCreditCardAccountIsEqualsTest() {
        IAccount creditCardAccountOne = new CreditCardAccount(personID, designation);
        IAccount creditCardAccountTwo = new CreditCardAccount(personID, designation);

        assertEquals(creditCardAccountOne.hashCode(), creditCardAccountTwo.hashCode());
        assertNotSame(creditCardAccountOne, creditCardAccountTwo);
    }
    @Test
    void hashCodeCreditCardAccountIsDifferentTest() {
        IAccount creditCardAccountOne = new CreditCardAccount(personID, designation);
        creditCardAccountOne.setAccountID(accountID);
        IAccount creditCardAccountTwo = new CreditCardAccount(personID, designation);
        creditCardAccountTwo.setAccountID(otherAccountID);

        assertNotEquals(creditCardAccountOne.hashCode(), creditCardAccountTwo.hashCode());
    }

}

