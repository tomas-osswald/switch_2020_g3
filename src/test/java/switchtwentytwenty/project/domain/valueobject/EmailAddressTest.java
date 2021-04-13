package switchtwentytwenty.project.domain.valueobject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import switchtwentytwenty.project.exceptions.InvalidEmailException;

import static org.junit.jupiter.api.Assertions.*;

public class EmailAddressTest {


    @ParameterizedTest
    @ValueSource(strings = {"  "})
    @NullAndEmptySource
    @DisplayName("Test if an EmailAddress Object throws an error if the String is empty, blank or null")
    void shouldThrowIfEmailNullBlankEmpty(String value) {
        assertThrows(InvalidEmailException.class, () -> new EmailAddress(value));
    }


    @DisplayName("Test if the Regex catches @@ in email")
    @Test
    void shouldAssertFalseIfTwoAtsInEmail() {
        String twoAtsOrArrobesInEnglish = "tonyze@@gmail.com";
        assertThrows(InvalidEmailException.class, () -> new EmailAddress(twoAtsOrArrobesInEnglish));
    }

    @DisplayName("Test if the Regex catches no @ in email")
    @Test
    void shouldAssertFalseIfNoAtsInEmail() {
        String noArrobesEmail = "tonyze.email.com";
        assertThrows(InvalidEmailException.class, () -> new EmailAddress(noArrobesEmail));
    }

    @DisplayName("Test if the Regex catches  single word email")
    @Test
    void shouldAssertFalseIfSingleWordEmail() {
        String noPointsNorArrobesJustTonyTheNewFragranceByPacoRayban = "tonyze";
        assertThrows(InvalidEmailException.class, () -> new EmailAddress(noPointsNorArrobesJustTonyTheNewFragranceByPacoRayban));
    }

    @DisplayName("Assert Throw for invalid Domain")
    @Test
    public void shouldTrowDomainInvalid() {
        String invalidDomain = "1120717@isep.ipp.p";
        assertThrows(InvalidEmailException.class, () -> new EmailAddress(invalidDomain));
    }


    @Test
    @DisplayName("Assert Throw for Email with [:space:]")
    public void shouldTrowEmailAddressWithSpace() {
        String emailWithSpace = "11207 17@isep.ipp.pt";
        assertThrows(InvalidEmailException.class, () -> {
            new EmailAddress(emailWithSpace);
        });
    }

    @Test
    @DisplayName("Assert Throw for Email with Illegal Characters")
    public void shouldTrowEmailAddressWithIllegalCharacters() {
        String emailWithIllegalCharacters = "tony!ze@gmail.com";
        assertThrows(InvalidEmailException.class, () -> {
            new EmailAddress(emailWithIllegalCharacters);
        });
    }

    @Test
    @DisplayName("Assert Throw for Email with + character")
    public void shouldThrowEmailAddressWithPlusCharacters() {
        String emailWithSignOfMore = "1120+717@isep.ipp.pt";
        assertThrows(InvalidEmailException.class, () -> {
            new EmailAddress(emailWithSignOfMore);
        });
    }


    @Test
    @DisplayName("Assert equals same instance")
    public void shouldAssertSameEmailAddressObject() {
        EmailAddress email = new EmailAddress("1120717@isep.ipp.pt");
        assertEquals(email, email);
    }

    @Test
    @DisplayName("Assert different type objects through equals")
    public void shouldAssertNotEqualsDifferentClassObject() {
        EmailAddress email = new EmailAddress("1120717@isep.ipp.pt");
        String familyService = "20717@isep.ipp.pt";
        assertNotEquals(email, familyService);
    }

    @Test
    @DisplayName("Assert equals when the String is the same on two EmailAddress objects")
    public void shouldAssertEqualsSameEmailAddresses() {
        EmailAddress emailOne = new EmailAddress("1120717@isep.ipp.pt");
        EmailAddress emailTwo = new EmailAddress("1120717@isep.ipp.pt");
        assertEquals(emailOne, emailTwo);
    }

    @Test
    @DisplayName("Assert Not Equals, diferent instance with diferent email")
    public void shouldAssertNotEqualsDifferentEmailAddresses() {
        EmailAddress emailOne = new EmailAddress("1120717@isep.ipp.pt");
        EmailAddress emailTwo = new EmailAddress("1120718@isep.ipp.pt");

        assertNotEquals(emailOne, emailTwo);
    }

    @Test
    @DisplayName("Assert same hashcode in different objects with same content")
    void testHashCode_True() {
        EmailAddress emailOne = new EmailAddress("1120717@isep.ipp.pt");
        EmailAddress emailTwo = new EmailAddress("1120717@isep.ipp.pt");

        assertEquals(emailOne.hashCode(), emailTwo.hashCode());
    }

    @Test
    @DisplayName("Assert that two different EmailAddress objects don't share the same hash code")
    void testHashCode_False() {
        EmailAddress emailOne = new EmailAddress("1120717@isep.ipp.pt");
        EmailAddress emailTwo = new EmailAddress("1120722@isep.ipp.pt");

        assertNotEquals(emailOne.hashCode(), emailTwo.hashCode());
    }
}
