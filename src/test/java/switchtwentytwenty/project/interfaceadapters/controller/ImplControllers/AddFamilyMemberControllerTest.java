package switchtwentytwenty.project.interfaceadapters.controller.ImplControllers;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.dto.AddPersonFormDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IAddFamilyMemberService;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class AddFamilyMemberControllerTest {

    @Mock
    IAddFamilyMemberService addFamilyMemberService;

    @InjectMocks
    AddFamilyMemberController addFamilyMemberController;

    @Mock
    AddPersonFormDTO addPersonFormDTO;

    @Test
    void addFamilyMemberSuccess() {
        Mockito.doNothing().when(addFamilyMemberService).addPerson(addPersonFormDTO);

        boolean result = addFamilyMemberController.addFamilyMember(addPersonFormDTO);

        assertTrue(result);
    }

    @Test
    void addFamilyMemberFail() {
        Mockito.doThrow(IllegalArgumentException.class).when(addFamilyMemberService).addPerson(addPersonFormDTO);

        boolean result = addFamilyMemberController.addFamilyMember(addPersonFormDTO);

        assertFalse(result);
    }


}