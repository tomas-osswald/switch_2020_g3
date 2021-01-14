package switch2020.project.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


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
}

