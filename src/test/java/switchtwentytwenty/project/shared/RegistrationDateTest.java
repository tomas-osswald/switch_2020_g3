package switchtwentytwenty.project.shared;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationDateTest {

    @Test
    void registrationDateTest_Valid() {
        LocalDate date = LocalDate.of(2021, 3, 15);
        RegistrationDate registrationDate = new RegistrationDate(date);

        assertNotNull(registrationDate);
    }

    @Test
    void registrationDateTest_ValidNull() {
        LocalDate date = null;
        RegistrationDate registrationDate = new RegistrationDate(date);

        assertNotNull(registrationDate);
    }

    @Test
    void equalsTest_equalNotSame() {
        LocalDate date = LocalDate.of(2021, 3, 15);
        RegistrationDate registrationDateOne = new RegistrationDate(date);
        RegistrationDate registrationDateTwo = new RegistrationDate(date);

        assertEquals(registrationDateOne, registrationDateTwo);
    }

    @Test
    void equalsTest_equalSame() {
        LocalDate date = LocalDate.of(2021, 3, 15);
        RegistrationDate registrationDateOne = new RegistrationDate(date);
        RegistrationDate registrationDateTwo = registrationDateOne;

        assertEquals(registrationDateOne, registrationDateTwo);
    }

    @Test
    void equalsTest_notEqual() {
        LocalDate dateOne = LocalDate.of(2021, 3, 15);
        RegistrationDate registrationDateOne = new RegistrationDate(dateOne);
        LocalDate dateTwo = null;
        RegistrationDate registrationDateTwo = new RegistrationDate(dateTwo);

        assertNotEquals(registrationDateOne, registrationDateTwo);
    }

    @Test
    void equalsTest_notEqualDifferentObject() {
        LocalDate dateOne = LocalDate.of(2021, 3, 15);
        RegistrationDate registrationDateOne = new RegistrationDate(dateOne);
        String notRegistrationDate = "not a RegistrationDate";

        assertNotEquals(registrationDateOne, notRegistrationDate);
    }

    @Test
    void hashCodeTest_sameHashCode() {
        LocalDate date = LocalDate.of(2021, 3, 15);
        RegistrationDate registrationDateOne = new RegistrationDate(date);
        RegistrationDate registrationDateTwo = new RegistrationDate(date);

        assertEquals(registrationDateOne.hashCode(), registrationDateTwo.hashCode());
    }

    @Test
    void hashCodeTest_differentHashCode() {
        LocalDate dateOne = LocalDate.of(2021, 3, 15);
        RegistrationDate registrationDateOne = new RegistrationDate(dateOne);
        LocalDate dateTwo = null;
        RegistrationDate registrationDateTwo = new RegistrationDate(dateTwo);

        assertNotEquals(registrationDateOne.hashCode(), registrationDateTwo.hashCode());
    }
}