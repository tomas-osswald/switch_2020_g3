package switchtwentytwenty.project.domain.valueobject;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AccountIDTest {

    @Test
    void constructorTestValidObject(){
        AccountID accountID = new AccountID(UUID.randomUUID());

        assertNotNull(accountID);
    }

    @Test
    void invalidIDShouldThrowException(){
        assertThrows(IllegalArgumentException.class,()-> {
            AccountID accountID = new AccountID(null);
        });
    }

    @Test
    void equalsTestEqualObjects(){
        UUID id = UUID.randomUUID();
        AccountID accountIDOne = new AccountID(id);
        AccountID accountIDTwo = new AccountID(id);

        assertEquals(accountIDOne,accountIDTwo);
        assertNotSame(accountIDOne,accountIDTwo);
    }

    @Test
    void equalsTestSameObject(){
        UUID id = UUID.randomUUID();
        AccountID accountIDOne = new AccountID(id);
        AccountID accountIDTwo = accountIDOne;

        assertEquals(accountIDOne,accountIDTwo);
    }

    @Test
    void equalsTestDifferentAccountIDs(){
        AccountID accountIDOne = new AccountID(UUID.randomUUID());
        AccountID accountIDTwo = new AccountID(UUID.randomUUID());

        assertNotEquals(accountIDOne,accountIDTwo);
    }

    @Test
    void equalsTestDifferentObjects(){
        AccountID accountID = new AccountID(UUID.randomUUID());
        LocalDate notAccountID = LocalDate.now();

        assertNotEquals(accountID,notAccountID);
    }

    @Test
    void hashCodeSameHashCode(){
        UUID id = UUID.randomUUID();
        AccountID accountIDOne = new AccountID(id);
        AccountID accountIDTwo = new AccountID(id);

        assertEquals(accountIDOne.hashCode(),accountIDTwo.hashCode());
        assertNotSame(accountIDOne,accountIDTwo);
    }

    @Test
    void hashCodeDifferentHashCode(){
        AccountID accountIDOne = new AccountID(UUID.randomUUID());
        AccountID accountIDTwo = new AccountID(UUID.randomUUID());

        assertNotEquals(accountIDOne.hashCode(),accountIDTwo.hashCode());
    }
}