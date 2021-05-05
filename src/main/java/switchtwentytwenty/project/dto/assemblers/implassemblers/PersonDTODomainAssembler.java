package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.family.InAddFamilyMemberDTO;
import switchtwentytwenty.project.dto.person.InputPersonDTO;

@Component
public class PersonDTODomainAssembler {
    /**
     * US010 - Assembler method to create a Person domain object from a DTO.
     * @param inputPersonDTO DTO that contains the Person's information
     * @param familyID Domain object representing the FamilyID of the Family of the Person to be created
     * @return Person domain object
     */
    public Person toDomain(InputPersonDTO inputPersonDTO, FamilyID familyID){

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
     * @param InAddFamilyMemberDTO
     * @return Person
     */
    public Person toDomain(InAddFamilyMemberDTO InAddFamilyMemberDTO){
        PersonID personID = new PersonID(InAddFamilyMemberDTO.getEmailID());
        Name name = new Name(InAddFamilyMemberDTO.getName());
        BirthDate birthDate = new BirthDate(InAddFamilyMemberDTO.getBirtDate());
        VATNumber vat = new VATNumber(InAddFamilyMemberDTO.getVatNumber());
        PhoneNumber phone = new PhoneNumber(InAddFamilyMemberDTO.getPhone());
        Address address = new Address(InAddFamilyMemberDTO.getStreet(), InAddFamilyMemberDTO.getCity(), InAddFamilyMemberDTO.getZipCode(), InAddFamilyMemberDTO.getHouseNumber());
        FamilyID familyID = new FamilyID(InAddFamilyMemberDTO.getAdminID());

        Person person = new Person(name, birthDate, personID, vat, phone, address, familyID);

        return person;
    }

}

