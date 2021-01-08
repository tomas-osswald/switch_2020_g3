package switch2020.project.utils;

import switch2020.project.model.Address;
import switch2020.project.model.EmailAddress;
import switch2020.project.model.PhoneNumber;
import switch2020.project.model.VatNumber;

import java.util.Date;
import java.util.List;

public class MemberProfileDTO {
    private List<EmailAddress> emails;
    private String name;
    private Date birthDate;
    private List<PhoneNumber> phoneNumbers;
    private VatNumber vatNumber;
    private Address address;




    public MemberProfileDTO(List<EmailAddress> emails, String name, Date birthDate, List<PhoneNumber> phoneNumbers, VatNumber vatNumber, Address address) {
        this.emails = emails;
        this.name = name;
        this.birthDate = birthDate;
        this.phoneNumbers = phoneNumbers;
        this.vatNumber = vatNumber;
        this.address = address;
    }
}
