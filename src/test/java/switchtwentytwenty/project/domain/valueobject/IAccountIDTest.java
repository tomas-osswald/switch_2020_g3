package switchtwentytwenty.project.domain.valueobject;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class IAccountIDTest {

    Long idOne = 100L;
    Long idTwo = 200L;

    @Test
    void constructorTestValidObject(){
        AccountID accountID = new AccountID(idOne);

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
        AccountID accountIDOne = new AccountID(idOne);
        AccountID accountIDTwo = new AccountID(idOne);

        assertEquals(accountIDOne,accountIDTwo);
        assertNotSame(accountIDOne,accountIDTwo);
    }

    @Test
    void equalsTestSameObject(){
        AccountID accountIDOne = new AccountID(idOne);
        AccountID accountIDTwo = accountIDOne;

        assertEquals(accountIDOne,accountIDTwo);
    }

    @Test
    void equalsTestDifferentAccountIDs(){
        AccountID accountIDOne = new AccountID(idOne);
        AccountID accountIDTwo = new AccountID(idTwo);

        assertNotEquals(accountIDOne,accountIDTwo);
    }

    @Test
    void equalsTestDifferentObjects(){
        AccountID accountID = new AccountID(idOne);
        LocalDate notAccountID = LocalDate.now();

        assertNotEquals(accountID,notAccountID);
    }

    @Test
    void hashCodeSameHashCode(){
        AccountID accountIDOne = new AccountID(idOne);
        AccountID accountIDTwo = new AccountID(idOne);

        assertEquals(accountIDOne.hashCode(),accountIDTwo.hashCode());
        assertNotSame(accountIDOne,accountIDTwo);
    }

    @Test
    void hashCodeDifferentHashCode(){
        AccountID accountIDOne = new AccountID(idOne);
        AccountID accountIDTwo = new AccountID(idTwo);

        assertNotEquals(accountIDOne.hashCode(),accountIDTwo.hashCode());
    }
}