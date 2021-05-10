package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.dto.person.InputPersonDTO;
import switchtwentytwenty.project.dto.family.InputFamilyDTO;
import switchtwentytwenty.project.exceptions.InvalidNameException;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICreateFamilyService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class CreateFamilyControllerTest {

    @Mock
    ICreateFamilyService familyService;

    @Mock
    InputFamilyDTO inputFamilyDTO;

    @Mock
    InputPersonDTO inputPersonDTO;

    @InjectMocks
    CreateFamilyController familyController;


    //TODO: Como fazer o assert do EntityResponse<>? temos que meter estes testes no novo controlador
    @Test
    @Tag("US010")
    @DisplayName("createFamilyAndAdmin Test - Valid data returns true")
    @Disabled
    void createFamilyAndAdminTestValidDataReturnsTrue(){
        //Mockito.when(familyService.createFamilyAndAddAdmin(inputFamilyDTO, inputPersonDTO)).thenReturn();

        boolean result = familyController.createFamilyAndSetAdmin(inputFamilyDTO, inputPersonDTO);

        assertTrue(result);
    }

    @Test
    @Tag("US010")
    @DisplayName("createFamilyAndAdmin Test - Invalid name returns false")
    void createFamilyAndAdminTestInValidDataReturnsFalse(){
        Mockito.doThrow(InvalidNameException.class).when(familyService).createFamilyAndAddAdmin(inputFamilyDTO, inputPersonDTO);

        boolean result = familyController.createFamilyAndSetAdmin(inputFamilyDTO, inputPersonDTO);

        assertFalse(result);
    }

}