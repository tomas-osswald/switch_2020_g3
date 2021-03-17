package switchtwentytwenty.project.domain.person;

import switchtwentytwenty.project.AggregateRoot;
import switchtwentytwenty.project.shared.*;

public class Person implements AggregateRoot {

    private Name name;
    private EmailAddress id;
    private VATNumber vat;
    private PhoneNumber phone;
    private Address address;
    private CCnumber cc;

    public Person(Name name, EmailAddress email, VATNumber vat, PhoneNumber phone, Address address, CCnumber cc) {
        this.name = name;
        this.id = email;
        this.vat = vat;
        this.phone = phone;
        this.address = address;
        this.cc = cc;
    }

    public boolean isSameEmail(EmailAddress email) {
        return this.id.equals(email);
    }
}