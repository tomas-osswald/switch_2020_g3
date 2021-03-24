package switchtwentytwenty.project.domain.person;

import switchtwentytwenty.project.AggregateRoot;
import switchtwentytwenty.project.deprecated.CCnumber;
import switchtwentytwenty.project.shared.*;

public class Person implements AggregateRoot {

    private Name name;
    private BirthDate birthdate;
    private EmailAddress id;
    private VATNumber vat;
    private PhoneNumber phone;
    private Address address;
    private CCnumber cc;
    private FamilyID familyID;

    public Person(Name name, BirthDate birthDate, EmailAddress email, VATNumber vat, PhoneNumber phone, Address address, CCnumber cc, FamilyID familyID) {
        this.name = name;
        this.birthdate = birthDate;
        this.id = email;
        this.vat = vat;
        this.phone = phone;
        this.address = address;
        this.cc = cc;
        this.familyID = familyID;
    }

    public boolean isSameEmail(EmailAddress email) {
        return this.id.equals(email);
    }
}