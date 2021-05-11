package switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.datamodel.assemblerjpa.iassemblersjpa.IPersonDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.*;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;

import java.util.ArrayList;
import java.util.List;

//TODO Entity being instatied here - should be in Repository
@Component
public class PersonDataDomainAssembler implements IPersonDataDomainAssembler {
    /**
     * Assembler method to convert a Person domain object into a PersonJPA data object.
     *
     * @param person domain object to be converted
     * @return PersonJPA data object corresponding the inputted person.
     */
    public PersonJPA toData(Person person) {
        PersonID personID = person.id();

        PersonIDJPA personIDJPA = new PersonIDJPA(personID.toString());

        String name = person.getName().toString();
        String birthdate = person.getBirthdate().toString();

        int vat = person.getVat().toInt();
        List<PhoneNumber> phoneNumbers = person.getPhoneNumbers();

        Address address = person.getAddress();
        FamilyID familyID = person.getFamilyID();

        FamilyIDJPA familyIDJPA = new FamilyIDJPA(familyID.getFamilyID().toString());

        PersonJPA personJPA = new PersonJPA(personIDJPA, name, birthdate, vat, familyIDJPA);

        AddressJPA addressJPA = new AddressJPA(address.getStreet(), address.getCity(), address.getZipCode(), address.getDoorNumber(), personJPA);

        List<EmailAddressJPA> emailsJPA = generateEmailAddressJPAList(person.getEmails(), personJPA);

        List<PhoneNumberJPA> phoneNumbersJPA = generetePhoneNumberJPAList(phoneNumbers, personJPA);

        personJPA.setAddress(addressJPA);
        personJPA.setPhones(phoneNumbersJPA);
        personJPA.setEmails(emailsJPA);

        return personJPA;
    }

    /**
     * Assembler method to convert a PersonJPA data object into a Person domain object
     *
     * @param personJPA data object to be converted
     * @return Person domain object corresponding the inputted personJPA.
     */
    public Person toDomain(PersonJPA personJPA) {
        PersonID personID = new PersonID(personJPA.getId().toString());
        Name name = new Name(personJPA.getName());
        BirthDate birthDate = new BirthDate(personJPA.getBirthdate());
        VATNumber vatNumber = new VATNumber(personJPA.getVat());
        FamilyID familyID = new FamilyID(personJPA.getFamilyid().toString());

        AddressJPA addressJPA = personJPA.getAddress();
        Address address = new Address(addressJPA.getStreet(), addressJPA.getCity(), addressJPA.getZipCode(), addressJPA.getDoorNumber());

        Person person = new Person(personID, name, birthDate, vatNumber, familyID);

        List<EmailAddress> emails = generateEmailAddressList(personJPA.getEmails());
        List<PhoneNumber> phoneNumbers = generatePhoneNumberList(personJPA.getPhones());

        person.setEmailList(emails);
        person.setPhoneNumberList(phoneNumbers);

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

    private List<PhoneNumber> generatePhoneNumberList(List<PhoneNumberJPA> numberList) {
        List<PhoneNumber> phoneNumberList = new ArrayList<>();

        for (PhoneNumberJPA phoneNumberJPA : numberList) {
            PhoneNumber phoneNumber = new PhoneNumber(phoneNumberJPA.getNumber());
            phoneNumberList.add(phoneNumber);
        }
        return phoneNumberList;
    }

    private List<EmailAddress> generateEmailAddressList(List<EmailAddressJPA> emailList) {
        List<EmailAddress> emailAddressList = new ArrayList<>();

        for (EmailAddressJPA emailAddressJPA : emailList) {
            EmailAddress emailAddress = new EmailAddress(emailAddressJPA.getEmail());
            emailAddressList.add(emailAddress);
        }
        return emailAddressList;
    }
}

