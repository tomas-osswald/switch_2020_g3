package switch2020.project.domain.DTOs.output;

import switch2020.project.domain.model.Relation;
import switch2020.project.domain.model.user_data.Address;
import switch2020.project.domain.model.user_data.EmailAddress;
import switch2020.project.domain.model.user_data.PhoneNumber;
import switch2020.project.domain.model.user_data.VatNumber;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberProfileDTO {
    private String name;
    private Date birthDate;
    private List<PhoneNumber> phoneNumbers = new ArrayList();
    private List<EmailAddress> emails = new ArrayList<>();
    private VatNumber vatNumber;
    private Address address;
    private Relation relation;
    private boolean administrator;


    public MemberProfileDTO(String name, Date birthDate, List<PhoneNumber> phoneNumbers, List<EmailAddress> emails, VatNumber vatNumber, Address address, Relation relation, boolean administrator) {
        this.name = name;
        this.birthDate = (Date) birthDate.clone();
        List<PhoneNumber> phoneNumbersClone = new ArrayList<>();
        phoneNumbersClone.addAll(phoneNumbers);
        this.phoneNumbers = phoneNumbersClone;
        List<EmailAddress> emailsCopy = new ArrayList<>();
        emailsCopy.addAll(emails);
        this.emails = emailsCopy;
        this.vatNumber = vatNumber;
        this.address = address;
        this.relation = relation;
        this.administrator = administrator;
    }

    //Method for people without relations
    public MemberProfileDTO(String name, Date birthDate, List<PhoneNumber> phoneNumbers, List<EmailAddress> emails, VatNumber vatNumber, Address address, boolean administrator) {
        this.name = name;
        this.birthDate = (Date) birthDate.clone();
        List<PhoneNumber> phoneNumbersClone = new ArrayList<>();
        phoneNumbersClone.addAll(phoneNumbers);
        this.phoneNumbers = phoneNumbersClone;
        List<EmailAddress> emailsCopy = new ArrayList<>();
        emailsCopy.addAll(emails);
        this.emails = emailsCopy;
        this.vatNumber = vatNumber;
        this.address = address;
        this.administrator = administrator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MemberProfileDTO)) return false;
        MemberProfileDTO that = (MemberProfileDTO) o;
        if (this.relation == null) {
            return administrator == that.administrator && name.equals(that.name) && birthDate.equals(that.birthDate) && phoneNumbers.equals(that.phoneNumbers) && emails.equals(that.emails) && vatNumber.equals(that.vatNumber) && address.equals(that.address);
        }
        return administrator == that.administrator && name.equals(that.name) && birthDate.equals(that.birthDate) && phoneNumbers.equals(that.phoneNumbers) && emails.equals(that.emails) && vatNumber.equals(that.vatNumber) && address.equals(that.address) && relation.equals(that.relation);
    }

    /*@Override
    public int hashCode() {
        return Objects.hash(name, birthDate, phoneNumbers, emails, vatNumber, address, administrator);
    }*/
}
