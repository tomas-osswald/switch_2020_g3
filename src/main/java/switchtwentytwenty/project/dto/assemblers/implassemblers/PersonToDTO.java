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
        List<String> phoneNumbers = generatePhoneNumberList(person);
        String address = person.getAddress().toString();
        String familyID = person.getFamilyID().toString();

        OutputPersonDTO outputPersonDTO = new OutputPersonDTO(id,name,birthdate,emails,phoneNumbers,vat,address,familyID);
        return outputPersonDTO;
    }

    private List<String> generatePhoneNumberList(Person person) {
        List<String> stringPhoneNumbers = new ArrayList<>();
        if (!person.getPhoneNumbers().isEmpty()) {
            for (PhoneNumber phoneNumber : person.getPhoneNumbers()) {
                stringPhoneNumbers.add(phoneNumber.toString());
            }
        }
        return stringPhoneNumbers;
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
