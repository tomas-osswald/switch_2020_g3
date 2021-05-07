package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.dto.family.AddFamilyMemberDTO;
import switchtwentytwenty.project.dto.family.InternalFamilyMemberDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IAddFamilyMemberService;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
class AddFamilyMemberControllerTest {

    @Mock
    IAddFamilyMemberService addFamilyMemberService;

    @Mock
    AddFamilyMemberDTO addFamilyMemberDTO;

    @InjectMocks
    switchtwentytwenty.project.interfaceadapters.controller.implcontrollers.AddFamilyMemberController addFamilyMemberController;

    @Mock
    InternalFamilyMemberDTO internalFamilyMemberDTO;

    @Mock
    AddFamilyMemberDTO addFamilyMemberDTO;


    //TODO: Rever testes do controller. Tudo a quebrar
    @Test
    @Tag("US101")
    @Disabled
    void addFamilyMemberSuccess() {

        boolean result = addFamilyMemberController.addFamilyMember(addFamilyMemberDTO);

        assertTrue(result);
    }

    @Test
    @Tag("US101")
    @Disabled
    void addFamilyMemberFail() {

        Mockito.doThrow(IllegalArgumentException.class).when(addFamilyMemberService).addPerson(internalFamilyMemberDTO);

        boolean result = addFamilyMemberController.addFamilyMember(addFamilyMemberDTO);

        assertFalse(result);
    }



}