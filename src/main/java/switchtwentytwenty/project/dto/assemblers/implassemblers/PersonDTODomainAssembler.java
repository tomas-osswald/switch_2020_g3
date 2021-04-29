package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.person.InputPersonDTO;

@Component
public class PersonDTODomainAssembler{
    /**
     * Assembler method to create a Person domain object from a DTO.
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

}

