package switchtwentytwenty.project.interfaceadapters.controller.ImplControllers;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.dto.person.OutputEmailDTO;
import switchtwentytwenty.project.interfaceadapters.controller.icontrollers.IPersonRESTController;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IAddEmailService;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@RunWith(SpringRunner.class)
class PersonRESTControllerTest {

    @Mock
    IAddEmailService addEmailService;

    @Mock
    OutputEmailDTO outputEmailDTO;

    @InjectMocks
    IPersonRESTController personRESTController;

    /*
    @Test
    void successCaseInAddEmail() {
        Mockito.when(addEmailService.addEmail(any(InputEmailDTO.class), any(InputPersonIDDTO.class))).thenReturn(outputEmailDTO);

        OutputEmailDTO expected = new


        assertEquals(expected, result);
    }

     */
}