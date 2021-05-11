package switchtwentytwenty.project.datamodel.domainjpa;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountIDJPATest {

    Long idOne = 127L;
    Long idTwo = 721L;

    @Test
    void getAccountIDSame(){
        AccountIDJPA accountIDOne = new AccountIDJPA(idOne);
        AccountIDJPA accountIDTwo = new AccountIDJPA(idOne);
        Long expected = accountIDOne.getId();
        Long result = accountIDTwo.getId();

        assertEquals(expected, result);
        assertSame(expected, result);
    }

    @Test
    void getAccountIDDifferent(){
        AccountIDJPA accountIDOne = new AccountIDJPA(idOne);
        AccountIDJPA accountIDTwo = new AccountIDJPA(idTwo);
        Long expected = accountIDOne.getId();
        Long result = accountIDTwo.getId();

        assertNotEquals(expected, result);
    }

    @Test
    void setAccountIDSame(){
        AccountIDJPA accountIDOne = new AccountIDJPA(idOne);
        AccountIDJPA accountIDTwo = new AccountIDJPA(idTwo);
        accountIDTwo.setId(idTwo);

        assertEquals(accountIDOne, accountIDTwo);
        assertNotSame(accountIDOne, accountIDTwo);
    }

    @Test
    void setAccountIDDifferent(){
        AccountIDJPA accountIDOne = new AccountIDJPA(idOne);
        AccountIDJPA accountIDTwo = new AccountIDJPA(idTwo);

        assertNotEquals(accountIDOne, accountIDTwo);
    }

}