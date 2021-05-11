package switchtwentytwenty.project.datamodel.domainjpa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountIDJPATest {

    Long id = 3L;

    Long otherID = 5L;

    @Test
    void equalsAccountIDJPAEqualAccountIDJPATest() {
        AccountIDJPA accountIDJPAOne = new AccountIDJPA(id);
        AccountIDJPA accountIDJPATwo = new AccountIDJPA(id);

        assertEquals(accountIDJPAOne, accountIDJPATwo);
        assertNotSame(accountIDJPAOne, accountIDJPATwo);
    }
    @Test
    void equalsAccountIDJPAEqualAccountIDJPANoArgsTest() {
        AccountIDJPA accountIDJPAOne = new AccountIDJPA();
        AccountIDJPA accountIDJPATwo = accountIDJPAOne;

        assertEquals(accountIDJPAOne, accountIDJPATwo);
    }
    @Test
    void equalsAccountIDJPAIsSameAccountIDJPA(){
        AccountIDJPA accountIDJPAOne = new AccountIDJPA(id);
        AccountIDJPA accountIDJPATwo = accountIDJPAOne;

        assertEquals(accountIDJPAOne, accountIDJPATwo);
    }
    @Test
    void equalsAccountIDJPADifferentAccountIDJPATest() {
        AccountIDJPA accountIDJPAOne = new AccountIDJPA(id);
        AccountIDJPA accountIDJPATwo = new AccountIDJPA(otherID);

        assertNotEquals(accountIDJPAOne, accountIDJPATwo);
        assertNotSame(accountIDJPAOne, accountIDJPATwo);
    }
    @Test
    void equalsAccountIDJPADifferentClassTest() {
        AccountIDJPA accountIDJPAOne = new AccountIDJPA(id);

        assertNotEquals(accountIDJPAOne, id);
    }
    @Test
    void equalsAccountIDJPADifferentFromNullTest() {
        AccountIDJPA accountIDJPAOne = new AccountIDJPA(id);
        String nullString = null;

        assertNotEquals(accountIDJPAOne, nullString);
    }
    @Test
    void hashCodeAccountIDJPAIsEquals(){
        AccountIDJPA accountIDJPAOne = new AccountIDJPA(id);
        AccountIDJPA accountIDJPATwo = new AccountIDJPA(id);

        assertEquals(accountIDJPAOne.hashCode(), accountIDJPATwo.hashCode());
        assertNotSame(accountIDJPAOne, accountIDJPATwo);
    }
    @Test
    void hashCodeAccountJPAIsDifferent(){
        AccountIDJPA accountIDJPAOne = new AccountIDJPA(id);
        AccountIDJPA accountIDJPATwo = new AccountIDJPA(otherID);

        assertNotEquals(accountIDJPAOne.hashCode(), accountIDJPATwo.hashCode());
    }
}

