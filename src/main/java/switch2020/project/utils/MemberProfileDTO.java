package switch2020.project.utils;

import switch2020.project.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
        this.birthDate = birthDate;
        this.phoneNumbers = phoneNumbers;
        this.emails = emails;
        this.vatNumber = vatNumber;
        this.address = address;
        this.relation = relation;
        this.administrator = administrator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MemberProfileDTO)) return false;
        MemberProfileDTO that = (MemberProfileDTO) o;
        return administrator == that.administrator && name.equals(that.name) && birthDate.equals(that.birthDate) && phoneNumbers.equals(that.phoneNumbers) && emails.equals(that.emails) && vatNumber.equals(that.vatNumber) && address.equals(that.address) && relation.equals(that.relation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate, phoneNumbers, emails, vatNumber, address, relation, administrator);
    }
}
