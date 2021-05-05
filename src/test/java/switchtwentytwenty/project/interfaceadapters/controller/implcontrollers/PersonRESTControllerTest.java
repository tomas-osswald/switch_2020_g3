package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.dto.GetProfileInfoDTO;
import switchtwentytwenty.project.dto.InternalProfileDTO;
import switchtwentytwenty.project.dto.OutputEmailDTO;
import switchtwentytwenty.project.dto.ProfileOutputDTO;
import switchtwentytwenty.project.dto.assemblers.implassemblers.ProfileInternalExternalAssembler;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;
import switchtwentytwenty.project.interfaceadapters.controller.IControllers.IPersonRESTController;

import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IAddEmailService;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IGetFamilyMemberProfileService;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@RunWith(SpringRunner.class)
class PersonRESTControllerTest {

    @Mock
    IAddEmailService addEmailService;

    @Mock
    OutputEmailDTO outputEmailDTO;

    @Mock
    IGetFamilyMemberProfileService getFamilyMemberProfileService;

    @Mock
    GetProfileInfoDTO getProfileInfoDTO;

    @Mock
    InternalProfileDTO anInternalProfileDTO;

    @Mock
    OutputPersonDTO outputPersonDTO;

    @Mock
    ProfileInternalExternalAssembler profileInternalExternalAssembler;

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

    @Disabled
    @Test
    void successCaseInGetProfileInfo() {

        Mockito.when(profileInternalExternalAssembler.toService(getProfileInfoDTO)).thenReturn(anInternalProfileDTO);
        Mockito.when(getFamilyMemberProfileService.getFamilyMemberProfile(anInternalProfileDTO)).thenReturn(outputPersonDTO);

        Mockito.when(getProfileInfoDTO.getPersonID()).thenReturn("tonyze@latinlover.com");

        OutputPersonDTO expectedOutputPersonDTO = new OutputPersonDTO();
        //expectedOutputPersonDTO.add(link);
        ResponseEntity<OutputPersonDTO> expected = new ResponseEntity<OutputPersonDTO>(outputPersonDTO, HttpStatus.FOUND);

        ResponseEntity<OutputPersonDTO> result = personRESTController.getProfileInfo(getProfileInfoDTO);

        Assertions.assertEquals(expected.getStatusCode(), result.getStatusCode());
        Assertions.assertEquals(expected.getBody(), result.getBody());
    }
}