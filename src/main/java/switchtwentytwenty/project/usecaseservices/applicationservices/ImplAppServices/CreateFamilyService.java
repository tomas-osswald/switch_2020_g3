package switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.*;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICreateFamilyService;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;

@Service
public class CreateFamilyService implements ICreateFamilyService {

    private IPersonRepository personRepository;
    private IFamilyRepository familyRepository;
    private PersonDTODomainAssembler personDTODomainAssembler;
    private FamilyDTODomainAssembler familyDTODomainAssembler;

    @Autowired
    public CreateFamilyService(IPersonRepository personRepository, IFamilyRepository familyRepository, PersonDTODomainAssembler personDTODomainAssembler, FamilyDTODomainAssembler familyDTODomainAssembler) {
        this.personRepository = personRepository;
        this.familyRepository = familyRepository;
        this.personDTODomainAssembler = personDTODomainAssembler;
        this.familyDTODomainAssembler = familyDTODomainAssembler;
    }

    /**
     * Service method to create a Family and set its administrator
     * @param inputFamilyDTO DTO that contains the Family's information
     * @param inputPersonDTO DTO that contains the Family Administrator's information
     */
    public FamilyOutputDTO createFamilyAndAddAdmin(InputFamilyDTO inputFamilyDTO, InputPersonDTO inputPersonDTO) {
        PersonID adminID = new PersonID(inputPersonDTO.unpackEmail());
        FamilyID familyID = familyRepository.generateID();
        Person admin = personDTODomainAssembler.toDomain(inputPersonDTO,familyID);
        Family family = familyDTODomainAssembler.toDomain(inputFamilyDTO,familyID,adminID);

        personRepository.add(admin);
        Family registeredFamily = familyRepository.add(family);

        FamilyOutputDTO familyOutputDTO = familyDTODomainAssembler.toDTO(registeredFamily);
        return familyOutputDTO;
    }
}