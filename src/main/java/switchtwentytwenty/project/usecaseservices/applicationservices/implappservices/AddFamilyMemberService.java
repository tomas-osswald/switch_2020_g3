package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.assemblers.implassemblers.PersonDTODomainAssembler;
import switchtwentytwenty.project.dto.family.InternalAddFamilyMemberDTO;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IAddFamilyMemberService;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;

@Service
public class AddFamilyMemberService implements IAddFamilyMemberService {

    private IPersonRepository personRepository;
    //private IFamilyRepository familyRepository;
    private PersonDTODomainAssembler personDTODomainAssembler;


    @Autowired
    public AddFamilyMemberService(IPersonRepository personRepository) {
        this.personRepository = personRepository;
        //this.familyRepository = familyRepository;
    }

    // o userID vem como string do controlador ou é logo lá é convertido em PersonID?
    public OutputPersonDTO addPerson(InternalAddFamilyMemberDTO internalAddFamilyMemberDTO) {
        PersonDTODomainAssembler personDTODomainAssembler = new PersonDTODomainAssembler();
        PersonID loggedUserID = new PersonID(internalAddFamilyMemberDTO.getAdminID());
        //familyRepository.verifyAdmin(loggedUserID);
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