package switchtwentytwenty.project.dto;

import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.EmailAddress;
import switchtwentytwenty.project.domain.valueobject.PhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class PersonToDTO {
    private Person person;

    public PersonToDTO(Person person) {
        this.person = person;
    }

    public PersonProfileDTO createPersonProfileDTO() {

        PersonProfileDTO personProfileDTO = new PersonProfileDTO();

        personProfileDTO.setId(person.id().toString());
        personProfileDTO.setName(person.getName().toString());
        personProfileDTO.setBirthdate(person.getBirthdate().toString());
        List<String> emails = generateEmailLists();
        personProfileDTO.setEmails(emails);
        personProfileDTO.setVat(person.getVat().toString());
        List<String> phoneNumbers = generatePhoneNumberList();
        personProfileDTO.setPhoneNumbers(phoneNumbers);
        personProfileDTO.setAddress(person.getAddress().toString());
        personProfileDTO.setFamilyID(person.getFamilyID().toString());


        return personProfileDTO;
    }

    private List<String> generatePhoneNumberList() {
        List<String> stringPhoneNumbers = new ArrayList<>();
        if (!person.getPhoneNumbers().isEmpty()) {
            for (PhoneNumber phoneNumber : person.getPhoneNumbers()) {
                stringPhoneNumbers.add(phoneNumber.toString());
            }
        }
        return stringPhoneNumbers;
    }

    private List<String> generateEmailLists() {
        List<String> stringEmails = new ArrayList<>();
        if (!person.getEmails().isEmpty()) {
            for (EmailAddress email : person.getEmails()) {
                stringEmails.add(email.toString());
            }
        }

        return stringEmails;
    }
}
