package switchtwentytwenty.project.domain.aggregates.person;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.aggregates.AggregateRoot;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.exceptions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class Person implements AggregateRoot<PersonID> {

    private PersonID id;
    private Name name;
    private BirthDate birthdate;
    private List<EmailAddress> emails = new ArrayList<>();
    private VATNumber vat;
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();
    @Setter
    private Address address;
    private FamilyID familyID;
    //private List<AccountID> accounts = new ArrayList<>();
    //private LedgerID ledger;
    //private List<FutureTransactionID> futureTransactions = new ArrayList<>();

    public Person(Name name, BirthDate birthDate, PersonID personID, VATNumber vat, PhoneNumber phone, Address address, FamilyID familyID) {
        this.name = name;
        this.birthdate = birthDate;
        this.id = personID;
        this.vat = vat;
        addPhone(phone);
        this.address = address;
        this.familyID = familyID;
    }

    public Person(PersonID personID, Name name, BirthDate birthDate, VATNumber vatNumber, FamilyID familyID) {
        this.id = personID;
        this.name = name;
        this.birthdate = birthDate;
        this.vat = vatNumber;
        this.familyID = familyID;
    }

    private void addPhone(PhoneNumber phone) {
        if (phone!=null) {
            this.phoneNumbers.add(phone);
        }
    }

    /**
     * This method is used to tell the Person to verify if they have that email associated. This way, when the Person
     * Repository iterates through all the Person in the entire system, doesn't use Getters and tells the Information Expert
     * to do it (Tell don't ask)
     *
     * @param personIDToCheck
     * @return
     */
    @Override
    public boolean hasID(PersonID personIDToCheck) {
        return this.id.equals(personIDToCheck);
    }

    public FamilyID getFamilyID() {
        return this.familyID;
    }

    @Override
    public PersonID id() {
        return this.id;
    }

    public void addEmail(EmailAddress email) {
        if (!isEmailAlreadyRegistered(email)) {
            this.emails.add(email);
        } else {
            throw new EmailAlreadyRegisteredException();
        }
    }

    private boolean isEmailAlreadyRegistered(EmailAddress email) {
        boolean emailPresent = false;
        for (EmailAddress registeredEmail : emails) {
            if (registeredEmail.equals(email)) {
                emailPresent = true;
            }
        }
        if (this.id.isThisEmail(email)) {
            emailPresent = true;
        }
        return emailPresent;
    }

    public Name getName() {
        return this.name;
    }

    public BirthDate getBirthdate() {
        return this.birthdate;
    }

    public List<EmailAddress> getEmails() {
        return this.emails;
    }

    public VATNumber getVat() {
        return this.vat;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setEmailList(List<EmailAddress> emails) {
        this.emails = emails;
    }

    public void setPhoneNumberList(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}