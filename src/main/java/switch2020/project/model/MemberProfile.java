package switch2020.project.model;

import java.util.List;

public class MemberProfile {
    private List<EmailAddress> emails;
    private String name;
    private String birthDate;
    private List<PhoneNumber> phoneNumbers;
    private VatNumber vatNumber;
    private Address address;




    public MemberProfile(List<EmailAddress> emails, String name, String birthDate, List<PhoneNumber> phoneNumbers, VatNumber vatNumber, Address address) {
        this.emails = emails;
        this.name = name;
        this.birthDate = birthDate;
        this.phoneNumbers = phoneNumbers;
        this.vatNumber = vatNumber;
        this.address = address;
    }
}
