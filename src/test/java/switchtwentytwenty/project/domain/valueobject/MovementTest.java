package switchtwentytwenty.project.domain.valueobject;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class MovementTest {

    @Test
    void constructorTest (){
        AccountID accountID = new AccountID(101L);
        Movement movement = new Movement(accountID);

        assertNotNull(movement);
    }
}