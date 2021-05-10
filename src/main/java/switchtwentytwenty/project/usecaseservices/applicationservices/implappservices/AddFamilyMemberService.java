package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.assemblers.implassemblers.PersonDTODomainAssembler;
import switchtwentytwenty.project.dto.family.InternalAddFamilyMemberDTO;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IAddFamilyMemberService;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;

@Service
@NoArgsConstructor
public class AddFamilyMemberService implements IAddFamilyMemberService {

    private IPersonRepository personRepository;
    private IFamilyRepository familyRepository;
    private PersonDTODomainAssembler personDTODomainAssembler;


    @Autowired
    public AddFamilyMemberService(IFamilyRepository familyRepository, IPersonRepository personRepository, PersonDTODomainAssembler personDTODomainAssembler) {
        this.personRepository = personRepository;
        this.personDTODomainAssembler = personDTODomainAssembler;
        this.familyRepository = familyRepository;
    }


    public OutputPersonDTO addPerson(InternalAddFamilyMemberDTO internalAddFamilyMemberDTO) {

        PersonID loggedUserID = new PersonID(internalAddFamilyMemberDTO.getAdminID());
        familyRepository.verifyAdmin(loggedUserID);
        FamilyID familyID = personRepository.getByID(loggedUserID).getFamilyID();
        Name name = personDTODomainAssembler.createName(internalAddFamilyMemberDTO);
        BirthDate birthDate = personDTODomainAssembler.createBirthDate(internalAddFamilyMemberDTO);
        VATNumber vat = personDTODomainAssembler.createVATNumber(internalAddFamilyMemberDTO);
        PhoneNumber phone = personDTODomainAssembler.createPhoneNumber(internalAddFamilyMemberDTO);
        Address address = personDTODomainAssembler.createAddress(internalAddFamilyMemberDTO);
        PersonID personID = personDTODomainAssembler.createPersonID(internalAddFamilyMemberDTO);

        Person aPerson = new Person(name, birthDate, personID, vat, phone, address, familyID);

        Person addedPerson = personRepository.add(aPerson);
        OutputPersonDTO outputPersonDTO = personDTODomainAssembler.toDTO(addedPerson);
        return outputPersonDTO;
    }
}