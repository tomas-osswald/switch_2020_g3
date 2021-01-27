package switch2020.project.domain.utils;

import org.junit.jupiter.api.Test;
import switch2020.project.domain.DTOs.output.MemberProfileDTO;
import switch2020.project.domain.model.user_data.Address;
import switch2020.project.domain.model.user_data.EmailAddress;
import switch2020.project.domain.model.user_data.PhoneNumber;
import switch2020.project.domain.model.user_data.VatNumber;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberProfileDTOTest {

    //Family Member Diogo
    String cc = "000000000ZZ4";
    String name = "Diogo";
    Date date = new Date(1990, 8, 26);
    Integer numero = 919999999;
    String email = "josediogoccbr@gmail.com";
    int nif = 212122233;
    String rua = "Rua Nossa";
    String codPostal = "4444-555";
    String local = "Zinde";
    String city = "Porto";
    String relacao = "filho";
    boolean admin = false;

    Address address = new Address(rua, codPostal, local, city);
    EmailAddress emailAddress = new EmailAddress(email);
    List<EmailAddress> emails = new ArrayList<>();
    PhoneNumber phoneNumber = new PhoneNumber(numero);
    List<PhoneNumber> phoneNumbers = new ArrayList<>();
    VatNumber vatNumber = new VatNumber(nif);

    @Test
    void compareSameProfileMemberDTO() {

        MemberProfileDTO diogoProfile = new MemberProfileDTO(name, date, phoneNumbers, emails, vatNumber, address, admin);

        assertSame(diogoProfile, diogoProfile);
        assertEquals(diogoProfile, diogoProfile);
    }

    @Test
    void compareProfileDTOWithAnotherClass() {
        MemberProfileDTO diogoProfile = new MemberProfileDTO(name, date, phoneNumbers, emails, vatNumber, address, admin);

        assertNotEquals(diogoProfile, address);
    }
}