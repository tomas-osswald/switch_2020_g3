package switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.FamilyDTODomainAssembler;
import switchtwentytwenty.project.dto.InputFamilyDTO;
import switchtwentytwenty.project.dto.InputPersonDTO;
import switchtwentytwenty.project.dto.PersonDTODomainAssembler;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICreateFamilyService;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;

@Service
public class CreateFamilyService implements ICreateFamilyService {

    private IPersonRepository personRepository;
    private IFamilyRepository familyRepository;

    @Autowired
    PersonDTODomainAssembler personDTODomainAssembler;
    @Autowired
    FamilyDTODomainAssembler familyDTODomainAssembler;

    @Autowired
    public CreateFamilyService(IPersonRepository personRepository, IFamilyRepository familyRepository) {
        this.personRepository = personRepository;
        this.familyRepository = familyRepository;
    }

    /**
     * Service method to create a Family and set its administrator
     * @param inputFamilyDTO DTO that contains the Family's information
     * @param inputPersonDTO DTO that contains the Family Administrator's information
     */
    public void createFamilyAndAddAdmin(InputFamilyDTO inputFamilyDTO, InputPersonDTO inputPersonDTO) {
        //TODO: adaptar testes para se remover isto
        FamilyName familyName = new FamilyName(inputFamilyDTO.unpackFamilyName());
        Name name = new Name(inputPersonDTO.unpackName());
        BirthDate birthdate = new BirthDate(inputPersonDTO.unpackBirthDate());
        VATNumber vat = new VATNumber(inputPersonDTO.unpackVAT());
        PhoneNumber phone = new PhoneNumber(inputPersonDTO.unpackPhone());
        Address address = new Address(inputPersonDTO.unpackStreet(), inputPersonDTO.unpackCity(), inputPersonDTO.unpackZipCode(), inputPersonDTO.unpackHouseNumber());
        RegistrationDate registrationDate = new RegistrationDate(inputFamilyDTO.unpackLocalDate());

        PersonID adminID = new PersonID(inputPersonDTO.unpackEmail());
        FamilyID familyID = familyRepository.generateID();
        Person admin = personDTODomainAssembler.toDomain(inputPersonDTO,familyID);
        Family family = familyDTODomainAssembler.toDomain(inputFamilyDTO,familyID,adminID);

        personRepository.add(admin);
        familyRepository.add(family);


    }
}