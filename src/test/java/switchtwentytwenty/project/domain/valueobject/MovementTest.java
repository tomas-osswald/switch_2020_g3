package switchtwentytwenty.project.domain.valueobject;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class MovementTest {

    @Test
    void getMonetaryTest(){
        Monetary monetaryValue = new Monetary("EUR", BigDecimal.valueOf(100));
        Movement movement = new Movement(monetaryValue);
        Monetary expected = new Monetary("EUR",BigDecimal.valueOf(100));

        Monetary result = movement.getMonetary();

        assertEquals(expected,result);
    }

    @Test
    void setMonetaryTest(){
        Monetary monetaryValue = new Monetary("EUR", BigDecimal.valueOf(100));
        Movement movement = new Movement(monetaryValue);
        Monetary expected = new Monetary("USD",BigDecimal.valueOf(200));

        movement.setMonetary(new Monetary("USD",BigDecimal.valueOf(200)));
        Monetary result = movement.getMonetary();

        assertEquals(expected,result);
    }

    @Test
    void equalsTestEqualMovements(){
        Monetary monetaryValue = new Monetary("EUR",BigDecimal.valueOf(200));
        Movement movementOne = new Movement(monetaryValue);
        Movement movementTwo = new Movement(monetaryValue);

        assertEquals(movementOne,movementTwo);
        assertNotSame(movementOne,movementTwo);
    }

    @Test
    void equalsTestSameMovement(){
        Monetary monetaryValue = new Monetary("EUR",BigDecimal.valueOf(200));
        Movement movementOne = new Movement(monetaryValue);
        Movement movementTwo = movementOne;

        assertEquals(movementOne,movementTwo);
    }

    @Test
    void equalsTestDifferentMovements(){
        Monetary monetaryValueOne = new Monetary("EUR",BigDecimal.valueOf(200));
        Movement movementOne = new Movement(monetaryValueOne);
        Monetary monetaryValueTwo = new Monetary("USD",BigDecimal.valueOf(100));
        Movement movementTwo = new Movement(monetaryValueTwo);

        assertNotEquals(movementOne,movementTwo);
    }

    @Test
    void equalsTestDifferentObjects(){
        Monetary monetaryValue = new Monetary("EUR",BigDecimal.valueOf(200));
        Movement movement = new Movement(monetaryValue);
        String notAMovement = "not a movement";

        assertNotEquals(movement,notAMovement);
    }

    @Test
    void equalsTestDifferentFromNull(){
        Monetary monetaryValue = new Monetary("EUR",BigDecimal.valueOf(200));
        Movement movement = new Movement(monetaryValue);
        String nullString = null;

        assertNotEquals(movement,nullString);
    }

    @Test
    void hashCodeTestSameHashCode() {
        Monetary monetaryValue = new Monetary("EUR",BigDecimal.valueOf(200));
        Movement movementOne = new Movement(monetaryValue);
        Movement movementTwo = new Movement(monetaryValue);

        assertEquals(movementOne.hashCode(),movementTwo.hashCode());
        assertNotSame(movementOne,movementTwo);
    }

    @Test
    void hashCodeTestDifferentHashCodes() {
        Monetary monetaryValueOne = new Monetary("EUR",BigDecimal.valueOf(200));
        Movement movementOne = new Movement(monetaryValueOne);
        Monetary monetaryValueTwo = new Monetary("USD",BigDecimal.valueOf(100));
        Movement movementTwo = new Movement(monetaryValueTwo);

        assertNotEquals(movementOne.hashCode(),movementTwo.hashCode());
    }

}