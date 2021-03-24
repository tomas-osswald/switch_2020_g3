package switchtwentytwenty.project.domain.family;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.shared.EmailAddress;
import switchtwentytwenty.project.shared.FamilyID;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {

    @Test
    void familyConstructorTest_validFamily() {
        //Arrange
        UUID familyID = UUID.randomUUID();
        String familyName = "Ribeiro";
        LocalDate registrationDate = LocalDate.of(2021, 3, 17);
        String emailString = "admin@gmail.com";
        EmailAddress adminEmail = new EmailAddress(emailString);
        //Act
        Family result = new Family(familyID, familyName, registrationDate, adminEmail);
        //Assert
        assertNotNull(result);
    }

    @Test
    void familyConstructorTest_invalidFamilyName() {
        //Arrange
        UUID familyID = UUID.randomUUID();
        String invalidFamilyName = "";
        LocalDate registrationDate = LocalDate.of(2021, 3, 17);
        String emailString = "admin@gmail.com";
        EmailAddress adminEmail = new EmailAddress(emailString);
        //Act & Assert
        assertThrows(IllegalArgumentException.class, () ->
                new Family(familyID, invalidFamilyName, registrationDate, adminEmail)
        );
    }

    @Test
    void familyConstructorTest_invalidFamilyID() {
        //Arrange
        UUID familyID = null;
        String invalidFamilyName = "Ribeiro";
        LocalDate registrationDate = LocalDate.of(2021, 3, 17);
        String emailString = "admin@gmail.com";
        EmailAddress adminEmail = new EmailAddress(emailString);
        //Act & Assert
        assertThrows(IllegalArgumentException.class, () ->
                new Family(familyID, invalidFamilyName, registrationDate, adminEmail)
        );
    }

    @Test
    void isIDofThisFamilyTest_sameFamilyID() {
        //Arrange
        UUID familyID = UUID.randomUUID();
        String familyName = "Ribeiro";
        LocalDate registrationDate = LocalDate.of(2021, 3, 17);
        String emailString = "admin@gmail.com";
        EmailAddress adminEmail = new EmailAddress(emailString);
        Family aFamily = new Family(familyID, familyName, registrationDate, adminEmail);
        FamilyID sameID = new FamilyID(familyID);
        //Act
        boolean result = aFamily.isIDofThisFamily(sameID);
        //Assert
        assertTrue(result);
    }

    @Test
    void isIDofThisFamilyTest_differentFamilyID() {
        //Arrange
        UUID familyID = UUID.randomUUID();
        String familyName = "Ribeiro";
        LocalDate registrationDate = LocalDate.of(2021, 3, 17);
        String emailString = "admin@gmail.com";
        EmailAddress adminEmail = new EmailAddress(emailString);
        Family aFamily = new Family(familyID, familyName, registrationDate, adminEmail);
        UUID differentID = UUID.randomUUID();
        FamilyID otherFamilyID = new FamilyID(differentID);
        //Act
        boolean result = aFamily.isIDofThisFamily(otherFamilyID);
        //Assert
        assertFalse(result);
    }

    @Test
    void testEquals_equalNotSame() {
        UUID familyID = UUID.randomUUID();
        String familyName = "Ribeiro";
        LocalDate registrationDate = LocalDate.of(2021, 3, 17);
        String emailString = "admin@gmail.com";
        EmailAddress adminEmail = new EmailAddress(emailString);
        Family familyOne = new Family(familyID, familyName, registrationDate, adminEmail);
        Family familyTwo = new Family(familyID, familyName, registrationDate, adminEmail);

        assertNotSame(familyOne, familyTwo);
        assertEquals(familyOne, familyTwo);
    }

    @Test
    void equalsTest_equalSame() {
        UUID familyID = UUID.randomUUID();
        String familyName = "Ribeiro";
        LocalDate registrationDate = LocalDate.of(2021, 3, 17);
        String emailString = "admin@gmail.com";
        EmailAddress adminEmail = new EmailAddress(emailString);
        Family familyOne = new Family(familyID, familyName, registrationDate, adminEmail);
        Family familyTwo = familyOne;

        assertSame(familyOne, familyTwo);
        assertEquals(familyOne, familyTwo);
    }

    @Test
    void equalsTest_notEqual() {
        UUID familyIDOne = UUID.randomUUID();
        String familyName = "Ribeiro";
        LocalDate registrationDate = LocalDate.of(2021, 3, 17);
        String emailString = "admin@gmail.com";
        EmailAddress adminEmail = new EmailAddress(emailString);
        Family familyOne = new Family(familyIDOne, familyName, registrationDate, adminEmail);
        UUID familyIDTwo = UUID.randomUUID();
        Family familyTwo = new Family(familyIDTwo, familyName, registrationDate, adminEmail);

        assertNotEquals(familyOne, familyTwo);
    }

    @Test
    void equalsTest_notEqualDifferentObject() {
        UUID familyIDOne = UUID.randomUUID();
        String familyName = "Ribeiro";
        LocalDate registrationDate = LocalDate.of(2021, 3, 17);
        String emailString = "admin@gmail.com";
        EmailAddress adminEmail = new EmailAddress(emailString);
        Family familyOne = new Family(familyIDOne, familyName, registrationDate, adminEmail);

        assertNotEquals(familyOne, registrationDate);
    }

    @Test
    void testHashCode_sameHashCode() {
        UUID familyID = UUID.randomUUID();
        String familyName = "Ribeiro";
        LocalDate registrationDate = LocalDate.of(2021, 3, 17);
        String emailString = "admin@gmail.com";
        EmailAddress adminEmail = new EmailAddress(emailString);
        Family familyOne = new Family(familyID, familyName, registrationDate, adminEmail);
        Family familyTwo = new Family(familyID, familyName, registrationDate, adminEmail);

        assertEquals(familyOne.hashCode(), familyTwo.hashCode());
    }

    @Test
    void testHashCode_differentHashCode() {
        UUID familyIDOne = UUID.randomUUID();
        String familyName = "Ribeiro";
        LocalDate registrationDate = LocalDate.of(2021, 3, 17);
        String emailString = "admin@gmail.com";
        EmailAddress adminEmail = new EmailAddress(emailString);
        Family familyOne = new Family(familyIDOne, familyName, registrationDate, adminEmail);
        UUID familyIDTwo = UUID.randomUUID();
        Family familyTwo = new Family(familyIDTwo, familyName, registrationDate, adminEmail);

        assertNotEquals(familyOne.hashCode(), familyTwo.hashCode());
    }

}