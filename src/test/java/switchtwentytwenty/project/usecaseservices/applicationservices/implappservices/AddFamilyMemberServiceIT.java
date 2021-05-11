package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
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
import switchtwentytwenty.project.dto.assemblers.implassemblers.PersonDTODomainAssembler;
import switchtwentytwenty.project.dto.person.InputAddFamilyMemberDTO;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;
import switchtwentytwenty.project.exceptions.InvalidNameException;
import switchtwentytwenty.project.exceptions.PersonAlreadyRegisteredException;
import switchtwentytwenty.project.interfaceadapters.implrepositories.PersonRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
class AddFamilyMemberServiceIT {

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

    @Autowired
    AddFamilyMemberService service;


    String adminID = "tonyze@latinlover.com";
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

    InputAddFamilyMemberDTO internalAddFamilyMemberDTO = new InputAddFamilyMemberDTO(adminID, ID, name, birthDate, vat, phone, street, city, houseNum, zipCode);
    InputAddFamilyMemberDTO invalidNameInternalAddFamilyMemberDTO = new InputAddFamilyMemberDTO(adminID, ID, invalidName, birthDate, vat, phone, street, city, houseNum, zipCode);


    @DisplayName("Integration test of AddFamilyMemberService with Repository: Successfully add a person")
    @Test
    void addPersonSuccess() {

        OutputPersonDTO result = service.addPerson(internalAddFamilyMemberDTO);

        OutputPersonDTO expected = new OutputPersonDTO();
        expected.setId(ID);
        expected.setName(name.toString());

        Assertions.assertEquals(expected.getId(), result.getId());
        Assertions.assertEquals(expected.getName(), result.getName());
        Assertions.assertNotSame(expected,result);
    }

    @Disabled
    @Test
    void addPersonFail_PersonAlreadyRegistered() {
        AddFamilyMemberService service = new AddFamilyMemberService();
        //Person familyMember = personDTODomainAssembler.toDomain(internalFamilyMemberDTO);
        //PersonJPA familyMemberJPA = personDataDomainAssembler.toData(familyMember);
        Mockito.when(personRepositoryJPA.findById(any(PersonIDJPA.class))).thenReturn(Optional.of(new PersonJPA()));

        assertThrows(PersonAlreadyRegisteredException.class, () -> service.addPerson(internalAddFamilyMemberDTO));

    }

    @Disabled
    @Test
    void addPersonFail_InvalidEmail() {
        AddFamilyMemberService service = new AddFamilyMemberService();

        assertThrows(InvalidNameException.class, () -> service.addPerson(invalidNameInternalAddFamilyMemberDTO));
    }
}