package switchtwentytwenty.project.interfaceadapters.controller.ImplControllers;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.dto.InputPersonDTO;
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
    InputPersonDTO inputPersonDTO;

    @Test
    @Tag("US101")
    void addFamilyMemberSuccess() {
        Mockito.doNothing().when(addFamilyMemberService).addPerson(inputPersonDTO, "email@email.com");

        boolean result = addFamilyMemberController.addFamilyMember(inputPersonDTO, "email@email.com");

        assertTrue(result);
    }

    @Test
    @Tag("US101")
    void addFamilyMemberFail() {
        Mockito.doThrow(IllegalArgumentException.class).when(addFamilyMemberService).addPerson(inputPersonDTO, "email@email.com");

        boolean result = addFamilyMemberController.addFamilyMember(inputPersonDTO, "email@email.com");

        assertFalse(result);
    }


}