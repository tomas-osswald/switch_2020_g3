package switchtwentytwenty.project.interfaceadapters.controller.ImplControllers;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.dto.AddPersonDTO;
import switchtwentytwenty.project.exceptions.UserIsNotAdminException;
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
    AddPersonDTO addPersonDTO;

    @Test
    void addFamilyMemberSuccess() {
        Mockito.doNothing().when(addFamilyMemberService).addPerson(addPersonDTO);

        boolean result = addFamilyMemberController.addFamilyMember(addPersonDTO);

        assertTrue(result);
    }

    @Test
    void addFamilyMemberFail() {
        Mockito.doThrow(IllegalArgumentException.class).when(addFamilyMemberService).addPerson(addPersonDTO);

        boolean result = addFamilyMemberController.addFamilyMember(addPersonDTO);

        assertFalse(result);
    }


}