package switchtwentytwenty.project.interfaceadapters.controller.ImplControllers;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.dto.AddEmailDTO;
import switchtwentytwenty.project.dto.InputEmailDTO;
import switchtwentytwenty.project.dto.InputPersonIDDTO;
import switchtwentytwenty.project.dto.OutputEmailDTO;
import switchtwentytwenty.project.interfaceadapters.controller.IControllers.IPersonRESTController;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IAddEmailService;

import static org.junit.jupiter.api.Assertions.*;
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