package switchtwentytwenty.project.domain.aggregates.account;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.domain.valueobject.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AccountFactoryTest {

    @Autowired
    AccountFactory accountFactory;

    Designation designation = new Designation("Compras");
    Monetary monetary = new Monetary("EUR", BigDecimal.valueOf(20.00));
    OwnerID ownerID = new PersonID("toni@emial.com");
    String bankAccountType = "bank";
    String cashAccountType = "cash";
    AccountID accountID = new AccountID(3L);
    List<Movement> movements = new ArrayList<>();
    Movement movement = new Movement(monetary);

    @DisplayName("Account is successfully created with Monetary")
    @Test
    public void createAccountWithMonetarySuccess() {

        IAccount expected = new BankAccount();
        expected.setDesignation(new Designation("Compras"));
        expected.addMovement(new Movement(new Monetary("EUR", BigDecimal.valueOf(20.00))));
        expected.setOwner(new PersonID("toni@emial.com"));

        IAccount result = accountFactory.createAccount(designation, monetary, ownerID, bankAccountType);

        assertEquals(expected, result);
    }

    @DisplayName("Account fails with Monetary - Account type dont match")
    @Test
    public void createAccountWithMonetaryFailsAccount() {
        assertThrows(IllegalArgumentException.class,()->accountFactory.createAccount(designation, monetary, ownerID, "baank"));
    }

    @DisplayName("Account is successfully created with List of Movements")
    @Test
    public void createAccountWithListOfMovementsSuccess(){
        IAccount expected = new CashAccount();
        expected.setAccountID(accountID);
        expected.setDesignation(designation);
        expected.setMovements(movements);
        expected.setOwner(ownerID);

        IAccount result = accountFactory.createAccount(accountID, movements, ownerID, designation, cashAccountType);

        assertEquals(expected, result);
    }

    @DisplayName("Account fails with Monetary - Account type dont match")
    @Test
    public void createAccountWithListOfMovementsFailsAccount() {
        assertThrows(IllegalArgumentException.class,()->accountFactory.createAccount(accountID, movements, ownerID, designation, "baank"));
    }
}