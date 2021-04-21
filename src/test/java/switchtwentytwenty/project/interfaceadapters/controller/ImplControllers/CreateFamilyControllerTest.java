package switchtwentytwenty.project.interfaceadapters.controller.ImplControllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.dto.AddPersonFormDTO;
import switchtwentytwenty.project.dto.CreateFamilyDTO;
import switchtwentytwenty.project.exceptions.InvalidNameException;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICreateFamilyService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class CreateFamilyControllerTest {

    @Mock
    ICreateFamilyService familyService;

    @Mock
    CreateFamilyDTO createFamilyDTO;

    @Mock
    AddPersonFormDTO addPersonFormDTO;

    @InjectMocks
    CreateFamilyController familyController;



    @Test
    @Tag("US010")
    @DisplayName("createFamilyAndAdmin Test - Valid data returns true")
    void createFamilyAndAdminTestValidDataReturnsTrue(){
        Mockito.doNothing().when(familyService).createFamilyAndAddAdmin(createFamilyDTO,addPersonFormDTO);

        boolean result = familyController.createFamilyAndAdmin(createFamilyDTO,addPersonFormDTO);

        assertTrue(result);
    }

    @Test
    @Tag("US010")
    @DisplayName("createFamilyAndAdmin Test - Invalid name returns false")
    void createFamilyAndAdminTestInValidDataReturnsFalse(){
        Mockito.doThrow(InvalidNameException.class).when(familyService).createFamilyAndAddAdmin(createFamilyDTO,addPersonFormDTO);

        boolean result = familyController.createFamilyAndAdmin(createFamilyDTO,addPersonFormDTO);

        assertFalse(result);
    }

}