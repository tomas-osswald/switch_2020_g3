package switchtwentytwenty.project.domain.aggregates.account;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import switchtwentytwenty.project.domain.valueobject.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AccountFactoryTest {

    @Autowired
    AccountFactory accountFactory;


    @Test
    public void createAccountTestNewAccount() {
        Designation designation = new Designation("Compras");
        Monetary monetary = new Monetary("EUR", BigDecimal.valueOf(20.00));
        OwnerID ownerID = new PersonID("toni@emial.com");
        String accountType = "bank";


        IAccount expected = new BankAccount();
        expected.setDesignation(new Designation("Compras"));
        expected.addMovement(new Movement(new Monetary("EUR", BigDecimal.valueOf(20.00))));
        expected.setOwner(new PersonID("toni@emial.com"));

        IAccount result = accountFactory.createAccount(designation, monetary, ownerID, accountType);

        assertEquals(expected, result);
        assertEquals(expected.getDesignation(), result.getDesignation());
        assertEquals(expected.getListOfMovements(), result.getListOfMovements());
        assertEquals(expected.getOwnerId(),result.getOwnerId());
    }

    @Test
    public void createAccountTestExistingAccount() {
        Designation designation = new Designation("Compras");
        Monetary monetary = new Monetary("EUR", BigDecimal.valueOf(20.00));
        Movement movement = new Movement(monetary);
        List<Movement> movementList = new ArrayList<>();
        movementList.add(movement);
        OwnerID ownerID = new PersonID("toni@emial.com");
        String accountType = "bank";

        IAccount expected = new BankAccount();
        expected.setAccountID(new AccountID(0L));
        expected.setDesignation(new Designation("Compras"));
        expected.addMovement(new Movement(new Monetary("EUR", BigDecimal.valueOf(20.00))));
        expected.setOwner(new PersonID("toni@emial.com"));

        IAccount result = accountFactory.createAccount(new AccountID(0L), movementList, ownerID, designation, accountType);

        assertEquals(expected, result);
        assertEquals(expected.getDesignation(), result.getDesignation());
        assertEquals(expected.getListOfMovements(), result.getListOfMovements());
        assertEquals(expected.getOwnerId(),result.getOwnerId());
    }

}