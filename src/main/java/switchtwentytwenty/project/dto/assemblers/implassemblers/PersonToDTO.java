package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.EmailAddress;
import switchtwentytwenty.project.domain.valueobject.PhoneNumber;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;

import java.util.ArrayList;
import java.util.List;


@Component
public class PersonToDTO {

    public PersonToDTO() {

    }

    public OutputPersonDTO createPersonProfileDTO(Person person) {
        String id = person.id().toString();
        String name = person.getName().toString();
        String birthdate = person.getBirthdate().toString();
        List<String> emails = generateEmailLists(person);
        String vat = person.getVat().toString();
        List<Integer> phoneNumbers = generatePhoneNumberList(person);
        String street = person.getAddress().getStreet();
        String city = person.getAddress().getCity();
        String zipCode = person.getAddress().getZipCode();
        String doorNumber = person.getAddress().getDoorNumber();
        String familyID = person.getFamilyID().toString();

        OutputPersonDTO outputPersonDTO = new OutputPersonDTO(id,name,birthdate,emails,phoneNumbers,vat,street, city, zipCode, doorNumber,familyID);
        return outputPersonDTO;
    }

    private List<Integer> generatePhoneNumberList(Person person) {
        List<Integer> integersPhoneNumbers = new ArrayList<>();
        if (!person.getPhoneNumbers().isEmpty()) {
            for (PhoneNumber phoneNumber : person.getPhoneNumbers()) {
                integersPhoneNumbers.add(phoneNumber.getNumber());
            }
        }
        return integersPhoneNumbers;
    }

    private List<String> generateEmailLists(Person person) {
        List<String> stringEmails = new ArrayList<>();
        if (!person.getEmails().isEmpty()) {
            for (EmailAddress email : person.getEmails()) {
                stringEmails.add(email.toString());
            }
        }

        return stringEmails;
    }
}
