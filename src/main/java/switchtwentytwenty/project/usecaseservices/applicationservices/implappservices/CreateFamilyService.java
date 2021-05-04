package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.dto.family.InputFamilyDTO;
import switchtwentytwenty.project.dto.family.OutputFamilyDTO;
import switchtwentytwenty.project.dto.assemblers.implassemblers.FamilyDTODomainAssembler;
import switchtwentytwenty.project.dto.assemblers.implassemblers.PersonDTODomainAssembler;
import switchtwentytwenty.project.dto.person.InputPersonDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICreateFamilyService;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;

@Service
public class CreateFamilyService implements ICreateFamilyService {

    final private IPersonRepository personRepository;
    final private IFamilyRepository familyRepository;
    final private PersonDTODomainAssembler personDTODomainAssembler;
    final private FamilyDTODomainAssembler familyDTODomainAssembler;

    @Autowired
    public CreateFamilyService(IPersonRepository personRepository, IFamilyRepository familyRepository, PersonDTODomainAssembler personDTODomainAssembler, FamilyDTODomainAssembler familyDTODomainAssembler) {
        this.personRepository = personRepository;
        this.familyRepository = familyRepository;
        this.personDTODomainAssembler = personDTODomainAssembler;
        this.familyDTODomainAssembler = familyDTODomainAssembler;
    }

    /**cd
     * Service method to create a Family and set its administrator
     *
     * @param inputFamilyDTO DTO that contains the Family's information
     * @param inputPersonDTO DTO that contains the Family Administrator's information
     */
    public OutputFamilyDTO createFamilyAndAddAdmin(InputFamilyDTO inputFamilyDTO, InputPersonDTO inputPersonDTO) {
        PersonID adminID = new PersonID(inputPersonDTO.unpackEmail());
        FamilyID familyID = new FamilyID(inputPersonDTO.unpackEmail());
        Person admin = personDTODomainAssembler.toDomain(inputPersonDTO, familyID);
        Family family = familyDTODomainAssembler.toDomain(inputFamilyDTO, familyID, adminID);

        Person person = personRepository.add(admin);
        Family registeredFamily = familyRepository.add(family);

        OutputFamilyDTO outputFamilyDTO = familyDTODomainAssembler.toDTO(registeredFamily);
        return outputFamilyDTO;
    }
}