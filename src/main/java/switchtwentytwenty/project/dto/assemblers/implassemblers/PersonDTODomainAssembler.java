package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.assemblers.iassemblers.IPersonDTODomainAssembler;
import switchtwentytwenty.project.dto.person.IInputPersonDTO;
import switchtwentytwenty.project.dto.person.InputGetProfileDTO;
import switchtwentytwenty.project.dto.person.OutputEmailDTO;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDTODomainAssembler implements IPersonDTODomainAssembler {


    public Address createAddress(IInputPersonDTO inputPersonDTO) {
        Address address = new Address(inputPersonDTO.unpackStreet(), inputPersonDTO.unpackCity(), inputPersonDTO.unpackZipCode(), inputPersonDTO.unpackHouseNumber());
        return address;
    }


    public PhoneNumber createPhoneNumber(IInputPersonDTO inputPersonDTO) {
        PhoneNumber phone = new PhoneNumber(inputPersonDTO.unpackPhone());
        return phone;
    }

    public VATNumber createVATNumber(IInputPersonDTO inputPersonDTO) {
        VATNumber vat = new VATNumber(inputPersonDTO.unpackVAT());
        return vat;
    }

    public PersonID createPersonID(IInputPersonDTO inputPersonDTO) {
        PersonID personID = new PersonID(inputPersonDTO.unpackEmail());
        return personID;
    }


    public Name createName(IInputPersonDTO inputPersonDTO) {
        Name name = new Name(inputPersonDTO.unpackName());
        return name;
    }

    public BirthDate createBirthDate(IInputPersonDTO inputPersonDTO) {
        BirthDate birthDate = new BirthDate(inputPersonDTO.unpackBirthDate());
        return birthDate;
    }


    public OutputPersonDTO toDTO(Person savedPerson) {
        OutputPersonDTO outputPersonDTO = new OutputPersonDTO();
        outputPersonDTO.setId(savedPerson.id().toString());
        outputPersonDTO.setName(savedPerson.getName().toString());
        outputPersonDTO.setBirthdate(savedPerson.getBirthdate().toString());
        outputPersonDTO.setVat(savedPerson.getVat().toString());
        outputPersonDTO.setStreet(savedPerson.getAddress().getStreet());
        outputPersonDTO.setCity(savedPerson.getAddress().getCity());
        outputPersonDTO.setZipCode(savedPerson.getAddress().getZipCode());
        outputPersonDTO.setDoorNumber(savedPerson.getAddress().getDoorNumber());
        outputPersonDTO.setFamilyID(savedPerson.getFamilyID().toString());

        outputPersonDTO.setEmails(getPersonStringEmailList(savedPerson));
        outputPersonDTO.setPhoneNumbers(getPersonStringPhoneNumberList(savedPerson));

        return outputPersonDTO;
    }

    private List<Integer> getPersonStringPhoneNumberList(Person savedPerson) {
        List<Integer> phoneNumbers = new ArrayList<>();
        List<PhoneNumber> phoneNumbersObjects = savedPerson.getPhoneNumbers();
        if (phoneNumbersObjects != null) {
            for (PhoneNumber phoneNumberObject : phoneNumbersObjects) {
                phoneNumbers.add(phoneNumberObject.getNumber());
            }
        }
        return phoneNumbers;
    }

    private List<String> getPersonStringEmailList(Person savedPerson) {
        List<String> emails = new ArrayList<>();
        List<EmailAddress> emailObjects = savedPerson.getEmails();
        if (emailObjects != null) {
            for (EmailAddress emailObject : emailObjects) {
                emails.add(emailObject.toString());
            }
        }
        return emails;
    }

    public OutputEmailDTO toEmailDTO(Person savedPerson) {
        OutputEmailDTO outputEmailDTO = new OutputEmailDTO();
        int index = savedPerson.getEmails().size() - 1;

        outputEmailDTO.setEmail(savedPerson.getEmails().get(index).toString());
        return outputEmailDTO;
    }

    public PersonID createPersonID(InputGetProfileDTO internalGetProfileDTO) {
        return new PersonID(internalGetProfileDTO.unpackID());
    }
}