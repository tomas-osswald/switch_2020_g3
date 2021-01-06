package switch2020.project.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertThrows;


class EmailAddressTest {
    @Test
    public void CreatingValidEmailAddress()
    {
        EmailAddress email = new EmailAddress("1120717@isep.ipp.pt");
        Assertions.assertNotNull(email);
    }

    @Test
    public void CreatingEmailAddressWithInvalidDomain()
    {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> {
            EmailAddress badEmail = new EmailAddress("1120717@isep.ipp.p");});
    }

    @Test
    public void CreatingEmailAddressWithNoAt()
    {
        Throwable exception =
                assertThrows(IllegalArgumentException.class, () -> {
                    EmailAddress badEmail = new EmailAddress("1120717.isep.ipp.pt");});
    }


}