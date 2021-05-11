package switchtwentytwenty.project.domain.aggregates.account;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.valueobject.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

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

    @Test
    void getOwnerId() {
        PersonID personID = new PersonID("tonyZe@gmail.com");
        IAccount accountOne = new CashAccount();
        accountOne.setOwner(personID);

        assertEquals(accountOne.getOwnerId(), ownerID);
        assertNotSame(accountOne.getOwnerId(), ownerID);
    }

    @Test
    void getDesignation() {
        Designation designationOne = new Designation("Fágêsse");
        IAccount accountOne = new CashAccount();
        accountOne.setDesignation(designationOne);

        assertEquals(accountOne.getDesignation(), designationOne);
    }


    // TODO: Add changeBalance method to CashAccount and complete de test
    @Test
    void getBalanceSame() {
        BigDecimal amount = new BigDecimal("3");
        Monetary balance = new Monetary("EUR",amount);
        IAccount accountOne = new CashAccount();

    }

    @Test
    void getAccountType() {
        String otherAccount = "Cash Account";
        IAccount accountOne = new CashAccount();

        assertEquals(accountOne.getAccountType(), otherAccount);
    }


    @Test
    void setAccountID() {
        IAccount accountOne = new CashAccount();
        IAccount accountTwo = new CashAccount();
        accountOne.setAccountID(accountID);
        accountTwo.setAccountID(accountID);

        assertEquals(accountOne.id(), accountTwo.id());
    }

    @Test
    void setOwner() {
        IAccount accountOne = new CashAccount();
        IAccount accountTwo = new CashAccount();
        accountOne.setOwner(ownerID);
        accountTwo.setOwner(ownerID);

        assertEquals(accountOne.getOwnerId(), accountTwo.getOwnerId());
    }

    @Test
    void setDesignation() {
        IAccount accountOne = new CashAccount();
        IAccount accountTwo = new CashAccount();
        accountOne.setDesignation(designation);
        accountTwo.setDesignation(designation);

        assertEquals(accountOne.getDesignation(), accountTwo.getDesignation());
    }

    @Test
    void setMovements() {
        IAccount accountOne = new CashAccount();
        IAccount accountTwo = new CashAccount();
        accountOne.setMovements(movements);
        accountTwo.setMovements(movements);

        //assertNotEquals(accountOne, accountTwo);
    }

    @Test
    void addMovement() {
        IAccount accountOne = new CashAccount();
        IAccount accountTwo = new CashAccount();
        accountOne.addMovement(movement);
        accountTwo.addMovement(movement);

        //assertNotEquals(accountOne, accountTwo);
    }

}