package switchtwentytwenty.project.domain.family;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.shared.EmailAddress;
import switchtwentytwenty.project.shared.FamilyID;
import switchtwentytwenty.project.shared.FamilyName;
import switchtwentytwenty.project.shared.RegistrationDate;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {

    @Test
    void familyConstructorTest_validFamily() {
        //Arrange
        UUID id = UUID.randomUUID();
        FamilyID familyID = new FamilyID(id);
        String familyNameString = "Ribeiro";
        FamilyName familyName = new FamilyName(familyNameString);
        LocalDate date = LocalDate.of(2021, 3, 17);
        RegistrationDate registrationDate = new RegistrationDate(date);
        String emailString = "admin@gmail.com";
        EmailAddress adminEmail = new EmailAddress(emailString);
        //Act
        Family result = new Family(familyID, familyName, registrationDate, adminEmail);
        //Assert
        assertNotNull(result);
    }

    @Test
    void isIDofThisFamilyTest_sameFamilyID() {
        //Arrange
        UUID id = UUID.randomUUID();
        FamilyID familyID = new FamilyID(id);
        String familyNameString = "Ribeiro";
        FamilyName familyName = new FamilyName(familyNameString);
        LocalDate date = LocalDate.of(2021, 3, 17);
        RegistrationDate registrationDate = new RegistrationDate(date);
        String emailString = "admin@gmail.com";
        EmailAddress adminEmail = new EmailAddress(emailString);
        Family aFamily = new Family(familyID, familyName, registrationDate, adminEmail);
        FamilyID sameID = new FamilyID(id);
        //Act
        boolean result = aFamily.hasID(sameID);
        //Assert
        assertTrue(result);
    }

    @Test
    void isIDofThisFamilyTest_differentFamilyID() {
        //Arrange
        UUID id = UUID.randomUUID();
        FamilyID familyID = new FamilyID(id);
        String familyNameString = "Ribeiro";
        FamilyName familyName = new FamilyName(familyNameString);
        LocalDate date = LocalDate.of(2021, 3, 17);
        RegistrationDate registrationDate = new RegistrationDate(date);
        String emailString = "admin@gmail.com";
        EmailAddress adminEmail = new EmailAddress(emailString);
        Family aFamily = new Family(familyID, familyName, registrationDate, adminEmail);
        UUID differentID = UUID.randomUUID();
        FamilyID otherFamilyID = new FamilyID(differentID);
        //Act
        boolean result = aFamily.hasID(otherFamilyID);
        //Assert
        assertFalse(result);
    }

    @Test
    void testEquals_equalNotSame() {
        UUID id = UUID.randomUUID();
        FamilyID familyID = new FamilyID(id);
        String familyNameString = "Ribeiro";
        FamilyName familyName = new FamilyName(familyNameString);
        LocalDate date = LocalDate.of(2021, 3, 17);
        RegistrationDate registrationDate = new RegistrationDate(date);
        String emailString = "admin@gmail.com";
        EmailAddress adminEmail = new EmailAddress(emailString);
        Family familyOne = new Family(familyID, familyName, registrationDate, adminEmail);
        Family familyTwo = new Family(familyID, familyName, registrationDate, adminEmail);

        assertNotSame(familyOne, familyTwo);
        assertEquals(familyOne, familyTwo);
    }

    @Test
    void equalsTest_equalSame() {
        UUID id = UUID.randomUUID();
        FamilyID familyID = new FamilyID(id);
        String familyNameString = "Ribeiro";
        FamilyName familyName = new FamilyName(familyNameString);
        LocalDate date = LocalDate.of(2021, 3, 17);
        RegistrationDate registrationDate = new RegistrationDate(date);
        String emailString = "admin@gmail.com";
        EmailAddress adminEmail = new EmailAddress(emailString);
        Family familyOne = new Family(familyID, familyName, registrationDate, adminEmail);
        Family familyTwo = familyOne;

        assertSame(familyOne, familyTwo);
        assertEquals(familyOne, familyTwo);
    }

    @Test
    void equalsTest_notEqual() {
        UUID id = UUID.randomUUID();
        FamilyID familyIDOne = new FamilyID(id);
        String familyNameString = "Ribeiro";
        FamilyName familyName = new FamilyName(familyNameString);
        LocalDate date = LocalDate.of(2021, 3, 17);
        RegistrationDate registrationDate = new RegistrationDate(date);
        String emailString = "admin@gmail.com";
        EmailAddress adminEmail = new EmailAddress(emailString);
        Family familyOne = new Family(familyIDOne, familyName, registrationDate, adminEmail);
        UUID idTwo = UUID.randomUUID();
        FamilyID familyIDTwo = new FamilyID(idTwo);
        Family familyTwo = new Family(familyIDTwo, familyName, registrationDate, adminEmail);

        assertNotEquals(familyOne, familyTwo);
    }

    @Test
    void equalsTest_notEqualDifferentObject() {
        UUID id = UUID.randomUUID();
        FamilyID familyID = new FamilyID(id);
        String familyNameString = "Ribeiro";
        FamilyName familyName = new FamilyName(familyNameString);
        LocalDate date = LocalDate.of(2021, 3, 17);
        RegistrationDate registrationDate = new RegistrationDate(date);
        String emailString = "admin@gmail.com";
        EmailAddress adminEmail = new EmailAddress(emailString);
        Family familyOne = new Family(familyID, familyName, registrationDate, adminEmail);

        assertNotEquals(familyOne, registrationDate);
    }

    @Test
    void testHashCode_sameHashCode() {
        UUID id = UUID.randomUUID();
        FamilyID familyID = new FamilyID(id);
        String familyNameString = "Ribeiro";
        FamilyName familyName = new FamilyName(familyNameString);
        LocalDate date = LocalDate.of(2021, 3, 17);
        RegistrationDate registrationDate = new RegistrationDate(date);
        String emailString = "admin@gmail.com";
        EmailAddress adminEmail = new EmailAddress(emailString);
        Family familyOne = new Family(familyID, familyName, registrationDate, adminEmail);
        Family familyTwo = new Family(familyID, familyName, registrationDate, adminEmail);

        assertEquals(familyOne.hashCode(), familyTwo.hashCode());
    }

    @Test
    void testHashCode_differentHashCode() {
        UUID id = UUID.randomUUID();
        FamilyID familyIDOne = new FamilyID(id);
        String familyNameString = "Ribeiro";
        FamilyName familyName = new FamilyName(familyNameString);
        LocalDate date = LocalDate.of(2021, 3, 17);
        RegistrationDate registrationDate = new RegistrationDate(date);
        String emailString = "admin@gmail.com";
        EmailAddress adminEmail = new EmailAddress(emailString);
        Family familyOne = new Family(familyIDOne, familyName, registrationDate, adminEmail);
        UUID idTwo = UUID.randomUUID();
        FamilyID familyIDTwo = new FamilyID(idTwo);
        Family familyTwo = new Family(familyIDTwo, familyName, registrationDate, adminEmail);

        assertNotEquals(familyOne.hashCode(), familyTwo.hashCode());
    }

    /*
    @Test
    void shouldCreateAValidFamilyInstanceWithBuilder() {
        UUID id = UUID.randomUUID();
        FamilyID familyID = new FamilyID(id);
        String familyNameString = "Ribeiro";
        FamilyName familyName = new FamilyName(familyNameString);
        LocalDate date = LocalDate.of(2021, 3, 17);
        RegistrationDate registrationDate = new RegistrationDate(date);
        String emailString = "admin@gmail.com";
        EmailAddress adminEmail = new EmailAddress(emailString);
        //Act
        Family result = new Family.Builder(familyID)
                .withName(familyName)
                .withRegistrationDate(registrationDate)
                .withAdmin(adminEmail)
                .build();
        //Assert
        assertNotNull(result);
    }*/
}