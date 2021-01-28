package switchtwentytwenty.project.domain.model.user_data;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.services.FamilyService;

import static org.junit.jupiter.api.Assertions.*;


class EmailAddressTest {

    @Test
    public void CreatingValidEmailAddress() {

        EmailAddress email = new EmailAddress("1120717@isep.ipp.pt");
        Assertions.assertNotNull(email);
    }

    @Test
    public void CreatingEmailAddressWithInvalidDomain() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    EmailAddress badEmail = new EmailAddress("1120717@isep.ipp.p");
                });
    }

    @Test
    public void CreatingEmailAddressWithNoAt() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    EmailAddress badEmail = new EmailAddress("1120717.isep.ipp.pt");
                });
    }

    @Test
    public void CreatingEmailAddressWithSpace() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    EmailAddress badEmail = new EmailAddress("11207 17@isep.ipp.pt");
                });
    }

    @Test
    public void CreatingEmailAddressWithIllegalCharacters() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    EmailAddress badEmail = new EmailAddress("!1120717@isep.ipp.pt");
                });
    }

    @Test
    public void CreatingEmailAddressWithPlusCharacters() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    EmailAddress badEmail = new EmailAddress("1120+717@isep.ipp.pt");
                });
    }

    @Test
    public void CreatingEmailAddressWithTwoAts() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    EmailAddress badEmail = new EmailAddress("1120717@@isep.ipp.pt");
                });
    }

    @Test
    public void CreatingEmptyEmailAddress() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    EmailAddress badEmail = new EmailAddress("");
                });
    }

    @Test
    public void CreatingBlankEmailAddress() {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    EmailAddress badEmail = new EmailAddress("    ");
                });
    }

    @Test
    public void CreatingNullEmailAddress() {
        String nullEmail = null;
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    EmailAddress badEmail = new EmailAddress(nullEmail);
                });
    }

    @Test
    public void EqualsSameEmailAddressObject() {
        EmailAddress email = new EmailAddress("1120717@isep.ipp.pt");

        assertEquals(email, email);
    }

    @Test
    public void EqualsDifferentClassObject() {
        EmailAddress email = new EmailAddress("1120717@isep.ipp.pt");
        FamilyService familyService = new FamilyService();

        assertNotEquals(email, familyService);
    }

    @Test
    public void EqualsSameEmailAddresses() {
        EmailAddress emailOne = new EmailAddress("1120717@isep.ipp.pt");
        EmailAddress emailTwo = new EmailAddress("1120717@isep.ipp.pt");

        assertEquals(emailOne, emailTwo);
    }

    @Test
    public void EqualsDifferentEmailAddresses() {
        EmailAddress emailOne = new EmailAddress("1120717@isep.ipp.pt");
        EmailAddress emailTwo = new EmailAddress("1120718@isep.ipp.pt");

        assertNotEquals(emailOne, emailTwo);
    }
}

