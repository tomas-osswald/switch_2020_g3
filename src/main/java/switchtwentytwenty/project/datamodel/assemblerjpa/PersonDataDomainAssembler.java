package switchtwentytwenty.project.datamodel.assemblerjpa;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.datamodel.AddressJPA;
import switchtwentytwenty.project.datamodel.EmailAddressJPA;
import switchtwentytwenty.project.datamodel.PersonJPA;
import switchtwentytwenty.project.datamodel.PhoneNumberJPA;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDataDomainAssembler {

    public PersonJPA toData(Person person) {
        PersonID personID = person.id();

        PersonIDJPA personIDJPA = new PersonIDJPA(personID.toString());

        String name = person.getName().toString();
        String birthdate = person.getBirthdate().toString();

        int vat = person.getVat().toInt();
        List<PhoneNumber> phoneNumbers = person.getPhoneNumbers();

        Address address = person.getAddress();
        AddressJPA addressJPA = new AddressJPA(address.getStreet(), address.getCity(), address.getZipCode(), address.getDoorNumber() );
        FamilyID familyID = person.getFamilyID();

        FamilyIDJPA familyIDJPA = new FamilyIDJPA(familyID.getFamilyID().toString());

        PersonJPA personJPA = new PersonJPA(personIDJPA, name, birthdate, vat, addressJPA, familyIDJPA);

        List<EmailAddressJPA> emails = generateEmailAddressJPAList(person.getEmails(), personJPA);

        List<PhoneNumberJPA> phoneNumberJPAS = generetePhoneNumberJPAList(phoneNumbers, personJPA);

        personJPA.setPhones(phoneNumberJPAS);
        personJPA.setEmails(emails);

        return personJPA;
    }

    public Person toDomain(PersonJPA personJPA, AddressJPA addressJPA) {
        PersonID personID = new PersonID(personJPA.getId().toString());
        Name name = new Name(personJPA.getName());
        BirthDate birthDate = new BirthDate(personJPA.getBirthdate());
        VATNumber vatNumber = new VATNumber(personJPA.getVat());
        FamilyID familyID = new FamilyID(personJPA.getFamilyid().toString());
        Address address = new Address(addressJPA.getStreet(), addressJPA.getCity(), addressJPA.getZipCode(), addressJPA.getDoorNumber());

        Person person = new Person(personID, name, birthDate, vatNumber, familyID);

        person.setAddress(address);

        return person;
    }

    private List<EmailAddressJPA> generateEmailAddressJPAList(List<EmailAddress> emailAddressList, PersonJPA personJPA) {
        List<EmailAddressJPA> emailAddressJPAList = new ArrayList<>();

        for (EmailAddress email : emailAddressList) {
            EmailAddressJPA emailAddressJPA = new EmailAddressJPA(email.toString(), personJPA);
            emailAddressJPAList.add(emailAddressJPA);

        }

        return emailAddressJPAList;
    }

    private List<PhoneNumberJPA> generetePhoneNumberJPAList(List<PhoneNumber> numberJPAList, PersonJPA personJPA) {
        List<PhoneNumberJPA> phoneNumberList = new ArrayList<>();

        for (PhoneNumber phoneNumber : numberJPAList) {
            PhoneNumberJPA phoneNumberJPA = new PhoneNumberJPA(phoneNumber.getNumber(), personJPA);
            phoneNumberList.add(phoneNumberJPA);
        }

        return phoneNumberList;
    }
}