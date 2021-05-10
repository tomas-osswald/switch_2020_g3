package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.family.InternalFamilyMemberDTO;
import switchtwentytwenty.project.dto.person.InputPersonDTO;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDTODomainAssembler {
    /**
     * US010 - Assembler method to create a Person domain object from a DTO.
     *
     * @param inputPersonDTO DTO that contains the Person's information
     * @param familyID       Domain object representing the FamilyID of the Family of the Person to be created
     * @return Person domain object
     */
    public Person toDomain(InputPersonDTO inputPersonDTO, FamilyID familyID) {

        PersonID personID = new PersonID(inputPersonDTO.unpackEmail());
        Name name = new Name(inputPersonDTO.unpackName());
        BirthDate birthDate = new BirthDate(inputPersonDTO.unpackBirthDate());
        VATNumber vat = new VATNumber(inputPersonDTO.unpackVAT());
        PhoneNumber phone = new PhoneNumber(inputPersonDTO.unpackPhone());
        Address address = new Address(inputPersonDTO.unpackStreet(), inputPersonDTO.unpackCity(), inputPersonDTO.unpackZipCode(), inputPersonDTO.unpackHouseNumber());

        Person person = new Person(name, birthDate, personID, vat, phone, address, familyID);

        return person;
    }

    /**
     * US101 - Assembler method that creates a Person domain object from a DTO
     *
     * @param anInternalFamilyMemberDTO
     * @return Person
     */
    public Person toDomain(InternalFamilyMemberDTO anInternalFamilyMemberDTO) {
        PersonID personID = new PersonID(anInternalFamilyMemberDTO.getEmailID());
        Name name = new Name(anInternalFamilyMemberDTO.getName());
        BirthDate birthDate = new BirthDate(anInternalFamilyMemberDTO.getBirtDate());
        VATNumber vat = new VATNumber(anInternalFamilyMemberDTO.getVatNumber());
        PhoneNumber phone = new PhoneNumber(anInternalFamilyMemberDTO.getPhone());
        Address address = new Address(anInternalFamilyMemberDTO.getStreet(), anInternalFamilyMemberDTO.getCity(), anInternalFamilyMemberDTO.getZipCode(), anInternalFamilyMemberDTO.getHouseNumber());
        FamilyID familyID = new FamilyID(anInternalFamilyMemberDTO.getAdminID());

        Person person = new Person(name, birthDate, personID, vat, phone, address, familyID);

        return person;
    }

    public OutputPersonDTO toDTO(Person savedPerson) {
        OutputPersonDTO outputPersonDTO = new OutputPersonDTO();
        outputPersonDTO.setId(savedPerson.id().toString());
        outputPersonDTO.setName(savedPerson.getName().toString());
        outputPersonDTO.setBirthdate(savedPerson.getBirthdate().toString());
        outputPersonDTO.setVat(savedPerson.getVat().toString());
        //outputPersonDTO.setAddress(savedPerson.getAddress().toString());
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


}