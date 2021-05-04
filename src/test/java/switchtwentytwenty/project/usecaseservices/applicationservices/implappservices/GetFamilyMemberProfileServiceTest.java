package switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;
import switchtwentytwenty.project.dto.assemblers.implassemblers.PersonToDTO;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class GetFamilyMemberProfileServiceTest {

    @Mock
    IPersonRepository personRepository;

    @Mock
    PersonToDTO mockPersonToDTO;

    @Mock
    Person person;

    @InjectMocks
    GetFamilyMemberProfileService getFamilyMemberProfileService;

    @Test
    void getFamilyMemberProfileTest() {
        OutputPersonDTO profileDTO = new OutputPersonDTO();
        PersonID personID = new PersonID("person@email.pt");
        Mockito.when(personRepository.getByID(personID)).thenReturn(person);
        Mockito.when(mockPersonToDTO.createPersonProfileDTO(person)).thenReturn(profileDTO);

        OutputPersonDTO expected = new OutputPersonDTO();

        OutputPersonDTO result = getFamilyMemberProfileService.getFamilyMemberProfile("person@email.pt");

        assertNotSame(expected, result);
        assertEquals(expected, result);

    }

}