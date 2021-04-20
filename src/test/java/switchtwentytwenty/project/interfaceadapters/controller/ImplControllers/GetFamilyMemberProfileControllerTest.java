package switchtwentytwenty.project.interfaceadapters.controller.ImplControllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.dto.PersonProfileDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IGetFamilyMemberProfileService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class GetFamilyMemberProfileControllerTest {

    PersonProfileDTO personProfileDTOoutput = new PersonProfileDTO();

    @Mock
    IGetFamilyMemberProfileService getProfileService;

    @InjectMocks
    GetFamilyMemberProfileController getFamilyMemberProfileController;

    @Test
    @DisplayName("Test if the GetFamilyMemberProfileController returns the correct DTO")
    void getFamilyMemberProfileSuccessCase() {
        String personID = "email@domain.pt";
        PersonProfileDTO expected = new PersonProfileDTO();

        Mockito.when(getProfileService.getFamilyMemberProfile(personID)).thenReturn(personProfileDTOoutput);

        PersonProfileDTO result = getFamilyMemberProfileController.getFamilyMemberProfile(personID);

        assertNotSame(expected, result);
        assertEquals(expected, result);

    }

    @Test
    void testGetFamilyMemberProfileFailCase() {

    }
}