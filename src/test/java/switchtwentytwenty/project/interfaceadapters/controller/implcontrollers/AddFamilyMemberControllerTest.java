package switchtwentytwenty.project.interfaceadapters.controller.ImplControllers;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.dto.AddFamilyMemberDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IAddFamilyMemberService;

@RunWith(SpringRunner.class)
@SpringBootTest
class AddFamilyMemberControllerTest {

    @Mock
    IAddFamilyMemberService addFamilyMemberService;

    @Mock
    AddFamilyMemberDTO addFamilyMemberDTO;

    @InjectMocks
    switchtwentytwenty.project.interfaceadapters.controller.implcontrollers.AddFamilyMemberController addFamilyMemberController;


    //TODO: Rever testes do controller. Tudo a quebrar
    @Test
    @Tag("US101")
    void addFamilyMemberSuccess() {

        boolean result = addFamilyMemberController.addFamilyMember(addFamilyMemberDTO);

        assertTrue(result);
    }

    @Test
    @Tag("US101")
    void addFamilyMemberFail() {

        Mockito.doThrow(IllegalArgumentException.class).when(addFamilyMemberService).addPerson(InAddFamilyMemberDTO);

        boolean result = addFamilyMemberController.addFamilyMember(addFamilyMemberDTO);

        assertFalse(result);
    }



}