package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.dto.assemblers.implassemblers.PersonDTODomainAssembler;
import switchtwentytwenty.project.dto.person.InputGetProfileDTO;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

@SpringBootTest
@RunWith(SpringRunner.class)
class GetFamilyMemberProfileServiceTest {

    @Mock
    IPersonRepository personRepository;

    @Mock
    PersonDTODomainAssembler mockPersonToDTO;

    @Mock
    Person person;

    @InjectMocks
     GetFamilyMemberProfileService getFamilyMemberProfileService;


    @Test
    void getFamilyMemberProfileTest() {
        InputGetProfileDTO internalGetProfileDTO = new InputGetProfileDTO();
        internalGetProfileDTO.setId("person@email.pt");

        OutputPersonDTO profileDTO = new OutputPersonDTO();
        PersonID personID = new PersonID("person@email.pt");
        Mockito.when(personRepository.getByID(personID)).thenReturn(person);
        Mockito.when(mockPersonToDTO.toDTO(person)).thenReturn(profileDTO);

        OutputPersonDTO expected = new OutputPersonDTO();

        OutputPersonDTO result = getFamilyMemberProfileService.getFamilyMemberProfile(internalGetProfileDTO);

        assertNotSame(expected, result);
        assertEquals(expected, result);

    }

}