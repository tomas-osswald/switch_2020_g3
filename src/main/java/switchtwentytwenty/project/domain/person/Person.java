package switchtwentytwenty.project.domain.person;

import switchtwentytwenty.project.AggregateRoot;
import switchtwentytwenty.project.shared.*;

import java.util.ArrayList;
import java.util.List;

public class Person implements AggregateRoot {

    private Name name;
    private BirthDate birthdate;
    private EmailAddress id;
    private List<EmailAddress> emails = new ArrayList<>();
    private VATNumber vat;
    private List<PhoneNumber> phone = new ArrayList<>();
    private Address address;
    private FamilyID familyID;
    private List<AccountID> accounts = new ArrayList<>();
    private LedgerID ledger;
    private List<FutureTransactionID> futureTransactions = new ArrayList<>();

    public Person(Name name, BirthDate birthDate, EmailAddress email, VATNumber vat, PhoneNumber phone, Address address, FamilyID familyID) {
        this.name = name;
        this.birthdate = birthDate;
        this.emails.add(email);
        this.vat = vat;
        addPhone(phone);
        this.address = address;
        this.familyID = familyID;
    }

    private void addPhone(PhoneNumber phone) {
        if (!phone.isNull()) {
            this.phone.add(phone);
        }
    }

    /**
     * This method is used to tell the Person to verify if they have that email associated. This way, when the Person
     * Repository iterates through all the Person in the entire system, doesn't use Getters and tells the Information Expert
     * to do it (Tell don't ask)
     *
     * @param emailToCheck
     * @return
     */
    public boolean doesPersonHaveThisEmail(EmailAddress emailToCheck) {
        boolean result = false;
        for (EmailAddress email : emails) {
            if (email.equals(emailToCheck)) {
                result = true;
            }
        }
        if (this.id.equals(emailToCheck)) {
            result = true;
        }
        return result;

    }

    public FamilyID getFamilyID() {
        return this.familyID.clone();
    }


    public EmailAddress getID() {
        return this.id;
    }

    public void addEmail(EmailAddress email) {
        this.emails.add(email);
    }
}