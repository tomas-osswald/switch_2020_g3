package switchtwentytwenty.project.domain.person;

import switchtwentytwenty.project.AggregateRoot;
import switchtwentytwenty.project.deprecated.CCnumber;
import switchtwentytwenty.project.shared.*;

import java.util.ArrayList;
import java.util.List;

public class Person implements AggregateRoot {

    private Name name;
    private BirthDate birthdate;
    //private EmailAddress id;
    private List<EmailAddress> emails = new ArrayList<>();
    private VATNumber vat;
    private List<PhoneNumber> phone = new ArrayList<>();
    private Address address;
    private CCnumber cc;
    private FamilyID familyID;
    private List<AccountID> accounts = new ArrayList<>();
    private LedgerID ledger;
    private List<FutureTransactionID> futureTransactions = new ArrayList<>();

    public Person(Name name, BirthDate birthDate, EmailAddress email, VATNumber vat, PhoneNumber phone, Address address, CCnumber cc, FamilyID familyID) {
        this.name = name;
        this.birthdate = birthDate;
        this.emails.add(email);
        this.vat = vat;
        addPhone(phone);
        this.address = address;
        this.cc = cc;
        this.familyID = familyID;
    }

    private void addPhone(PhoneNumber phone) {
        if(!phone.isNull()){
            this.phone.add(phone);
        }
    }

    public boolean doesPersonHaveThisEmail(EmailAddress emailToCheck) {
        boolean result = false;
        for (EmailAddress email : emails) {
            if (email.equals(emailToCheck)) {
                result = true;
            }
        }
        return result;

    }

    public FamilyID getFamilyID() {
        return this.familyID.clone();
    }


    public EmailAddress getID() {
        return emails.get(0);
    }
}