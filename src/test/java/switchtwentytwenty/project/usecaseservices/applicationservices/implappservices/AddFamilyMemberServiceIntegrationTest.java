package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa.PersonDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.PersonIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.PersonJPA;
import switchtwentytwenty.project.datamodel.repositoryjpa.IPersonRepositoryJPA;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.dto.assemblers.implassemblers.PersonDTODomainAssembler;
import switchtwentytwenty.project.dto.family.InternalFamilyMemberDTO;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;
import switchtwentytwenty.project.exceptions.InvalidNameException;
import switchtwentytwenty.project.exceptions.PersonAlreadyRegisteredException;
import switchtwentytwenty.project.interfaceadapters.implrepositories.PersonRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
class AddFamilyMemberServiceIntegrationTest {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonDTODomainAssembler personDTODomainAssembler;

    @Autowired
    PersonDataDomainAssembler personDataDomainAssembler;

    @Mock
    IPersonRepositoryJPA personRepositoryJPA;

    @Mock
    PersonJPA savedPersonJPA;

    String adminID = "tonyAdmin@gmail.com";
    String ID = "tonyZe@gamil.com";
    String name = "Tony";
    String invalidName = "     ";
    String birthDate = "1/1/1990";
    int vat = 234678912;
    Integer phone = 919997755;
    String street = "Rua";
    String city = "cite";
    String houseNum = "239";
    String zipCode = "1111-222";

    InternalFamilyMemberDTO internalFamilyMemberDTO = new InternalFamilyMemberDTO(adminID,ID,name,birthDate,vat,phone,street,city,houseNum,zipCode);
    InternalFamilyMemberDTO invalidNameInternalFamilyMemberDTO = new InternalFamilyMemberDTO(adminID,ID,invalidName,birthDate,vat,phone,street,city,houseNum,zipCode);

    @Disabled
    @Test
    void addPersonSuccess() {
        AddFamilyMemberService service = new AddFamilyMemberService(personRepository);
        Person familyMember = personDTODomainAssembler.toDomain(internalFamilyMemberDTO);
        //personRepository.isPersonIDAlreadyRegistered(familyMember.id());
        PersonJPA familyMemberJPA = personDataDomainAssembler.toData(familyMember);
        Mockito.when(personRepositoryJPA.findById(any(PersonIDJPA.class))).thenReturn(Optional.empty());
        Mockito.when(personRepositoryJPA.save(familyMemberJPA)).thenReturn(savedPersonJPA);
        //Person savedFamilyMember = personDataDomainAssembler.toDomain(savedPersonJPA);
        //OutputPersonDTO result = personDTODomainAssembler.toDTO(savedFamilyMember);
        OutputPersonDTO result = service.addPerson(internalFamilyMemberDTO);

        OutputPersonDTO expected = new OutputPersonDTO();
        expected.setId(ID);
        expected.setName(name);

        Assertions.assertEquals(expected, result);
    }

    @Disabled
    @Test
    void addPersonFail_PersonAlreadyRegistered(){
        AddFamilyMemberService service = new AddFamilyMemberService(personRepository);
        //Person familyMember = personDTODomainAssembler.toDomain(internalFamilyMemberDTO);
        //PersonJPA familyMemberJPA = personDataDomainAssembler.toData(familyMember);
        Mockito.when(personRepositoryJPA.findById(any(PersonIDJPA.class))).thenReturn(Optional.of(new PersonJPA()));

        assertThrows(PersonAlreadyRegisteredException.class,()-> service.addPerson(internalFamilyMemberDTO));

    }

    @Disabled
    @Test
    void addPersonFail_InvalidEmail(){
        AddFamilyMemberService service = new AddFamilyMemberService(personRepository);

        assertThrows(InvalidNameException.class,()-> service.addPerson(invalidNameInternalFamilyMemberDTO));
    }
}