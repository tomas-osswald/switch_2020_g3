package switchtwentytwenty.project.domain.aggregates.account;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.valueobject.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
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

    @Test
    void getOwnerIdSameID() {
        PersonID personID = new PersonID("tonyZe@gmail.com");
        IAccount accountOne = new CashAccount();
        accountOne.setOwner(personID);

        assertEquals(accountOne.getOwnerId(), ownerID);
        assertNotSame(accountOne.getOwnerId(), ownerID);
    }

    @Test
    void getOwnerIdDifferentID() {
        PersonID personID = new PersonID("tony@gmail.com");
        IAccount accountOne = new CashAccount();
        accountOne.setOwner(personID);

        assertNotEquals(accountOne.getOwnerId(), ownerID);
    }

    @Test
    void getDesignationSame() {
        Designation designationOne = new Designation("Fágêsse");
        IAccount accountOne = new CashAccount();
        accountOne.setDesignation(designationOne);

        assertEquals(accountOne.getDesignation(), designation);
    }

    @Test
    void getDesignationDifferent() {
        Designation designationOne = new Designation("breaks");
        IAccount accountOne = new CashAccount();
        accountOne.setDesignation(designationOne);

        assertEquals(accountOne.getDesignation(), designation);
    }

    @Test
    void getBalanceSame() {

    }

    @Test
    void getAccountType() {

    }

    @Test
    void setAccountID() {
    }

    @Test
    void setOwner() {
    }

    @Test
    void setDesignation() {
    }

    @Test
    void setMovements() {
    }

    @Test
    void addMovement() {
    }

}