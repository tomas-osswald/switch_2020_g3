package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import switchtwentytwenty.project.dto.OptionsDTO;
import switchtwentytwenty.project.dto.assemblers.implassemblers.FamilyInputDTOAssembler;
import switchtwentytwenty.project.dto.assemblers.implassemblers.PersonInputDTOAssembler;
import switchtwentytwenty.project.dto.category.OutputCategoryTreeDTO;
import switchtwentytwenty.project.dto.family.AddFamilyAndSetAdminDTO;
import switchtwentytwenty.project.dto.family.InputFamilyDTO;
import switchtwentytwenty.project.dto.family.OutputFamilyDTO;
import switchtwentytwenty.project.dto.person.InputPersonDTO;
import switchtwentytwenty.project.dto.family.CreateRelationDTO;
import switchtwentytwenty.project.exceptions.InvalidEmailException;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICreateFamilyService;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IFamiliesOptionsService;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IFamilyOptionsService;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IGetCustomCategoriesService;

import java.awt.image.RescaleOp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@ExtendWith(MockitoExtension.class)
class FamilyRESTControllerTest {
    AddFamilyAndSetAdminDTO dto = new AddFamilyAndSetAdminDTO("tony@email.com", "Silva", "12/12/1222", 999999999, 919999999, "Rua", "Cidade", "12B", "4400-123", "Silva", "12/12/2000");
    AddFamilyAndSetAdminDTO invaliddto = new AddFamilyAndSetAdminDTO("tonyemail.com", "Silva", "12/12/1222", 999999999, 919999999, "Rua", "Cidade", "12B", "4400-123", "Silva", "12/12/2000");

    @Mock
    ICreateFamilyService createFamilyService;

    @Mock
    FamilyInputDTOAssembler familyAssembler;

    @Mock
    PersonInputDTOAssembler personAssembler;

    @Mock
    IFamiliesOptionsService familiesOptionsService;

    @Mock
    IFamilyOptionsService familyOptionsService;

    @Mock
    IGetCustomCategoriesService getCustomCategoriesService;

    @InjectMocks
    FamilyRESTController familyRESTController;


    @Test
    @DisplayName("CreateFamilyAndSetAdmin function success case")
    void createFamilyAndSetAdmin() {
        AddFamilyAndSetAdminDTO addFamilyAndSetAdminDTO = new AddFamilyAndSetAdminDTO("tonyze@gmail.com", "TonyZe", "28/12/1990", 123123123, 919999999, "rua", "cidade", "23b", "1234-123", "Silva", "12/12/1990");

        InputPersonDTO inputPersonDTO = new InputPersonDTO("tonyze@gmail.com", "TonyZe", "28/12/1990", 123123123, 919999999, "rua", "cidade", "23b", "1234-123");

        InputFamilyDTO inputFamilyDTO = new InputFamilyDTO("Silva", "12/12/1990");

        OutputFamilyDTO outputFamilyDTO = new OutputFamilyDTO("Silva", "@tony@email.com", "tony@email.com", "12/12/1990");

        when(personAssembler.toInputPersonDTO(any(AddFamilyAndSetAdminDTO.class))).thenReturn(inputPersonDTO);
        when(familyAssembler.toInputFamilyDTO(any(AddFamilyAndSetAdminDTO.class))).thenReturn(inputFamilyDTO);
        when(createFamilyService.createFamilyAndAddAdmin(any(), any())).thenReturn(outputFamilyDTO);

        // Expected

        OutputFamilyDTO expectedOutputDTO = new OutputFamilyDTO("Silva", "@tony@email.com", "tony@email.com", "12/12/1990");

        Link expectedLink = linkTo(methodOn(FamilyRESTController.class).getFamily(outputFamilyDTO.getFamilyID())).withSelfRel();

        expectedOutputDTO.add(expectedLink);

        ResponseEntity expected = new ResponseEntity(expectedOutputDTO, HttpStatus.CREATED);

        ResponseEntity result = familyRESTController.createFamilyAndSetAdmin(addFamilyAndSetAdminDTO);


        assertNotNull(result);
        //assertEquals(result.getStatusCode(),HttpStatus.CREATED);
        assertEquals(result, expected);
    }


    @Test
    void testCreateFamilyAndSetAdmin() {
        InputPersonDTO inputPersonDTO = new InputPersonDTO("tonyze@gmail.com", "TonyZe", "28/12/1990", 123123123, 919999999, "rua", "cidade", "23b", "1234-123");

        InputFamilyDTO inputFamilyDTO = new InputFamilyDTO("Silva", "12/12/1990");

        when(personAssembler.toInputPersonDTO(any(AddFamilyAndSetAdminDTO.class))).thenReturn(inputPersonDTO);
        when(familyAssembler.toInputFamilyDTO(any(AddFamilyAndSetAdminDTO.class))).thenReturn(inputFamilyDTO);
        when(createFamilyService.createFamilyAndAddAdmin(any(), any())).thenThrow(InvalidEmailException.class);

        ResponseEntity expected = new ResponseEntity("Error: " + null, HttpStatus.UNPROCESSABLE_ENTITY);
        ResponseEntity result = familyRESTController.createFamilyAndSetAdmin(invaliddto);

        assertEquals(expected.getBody(), result.getBody());
        assertEquals(expected.getStatusCode(), result.getStatusCode());
    }


    @Test
    void familiesOptionsTest() {
        OptionsDTO optionsDTO = new OptionsDTO();

        Link linkToFamilyOptions = linkTo(methodOn(FamilyRESTController.class).familiesOptions()).withSelfRel();
        Link linkToAddFamily = linkTo(methodOn(FamilyRESTController.class).createFamilyAndSetAdmin(new AddFamilyAndSetAdminDTO())).withRel("POST - Add new Family");

        optionsDTO.add(linkToFamilyOptions);
        optionsDTO.add(linkToAddFamily);

        when(familiesOptionsService.getFamiliesOptions()).thenReturn(optionsDTO);

        OptionsDTO expectedOptionsDTO = new OptionsDTO();

        Link expectedLinkToFamilyOptions = linkTo(methodOn(FamilyRESTController.class).familiesOptions()).withSelfRel();
        Link expectedLinkToAddFamily = linkTo(methodOn(FamilyRESTController.class).createFamilyAndSetAdmin(new AddFamilyAndSetAdminDTO())).withRel("POST - Add new Family");

        expectedOptionsDTO.add(expectedLinkToFamilyOptions);
        expectedOptionsDTO.add(expectedLinkToAddFamily);

        HttpHeaders header = new HttpHeaders();
        header.set("Allow", "POST, OPTIONS");

        ResponseEntity expected = new ResponseEntity<>(optionsDTO, header, HttpStatus.OK);
        ResponseEntity result = familyRESTController.familiesOptions();

        assertEquals(result, expected);
    }


 /*   @Test
    void addRelationTest() {
        CreateRelationDTO createRelationDTO = new CreateRelationDTO();

        assertThrows(UnsupportedOperationException.class, () -> familyRESTController.createRelation(createRelationDTO, "@tonize@gmail.com"));
    }*/

    @Test
    void getFamilyNameTest() {
        String familyName = "Silva";

        assertThrows(UnsupportedOperationException.class, () -> familyRESTController.getFamily(familyName));
    }

    @Test
    void getFamilyOptionsTest() {
        String familyID = "@tonize@gmail.com";

        OptionsDTO options = new OptionsDTO();
        Link optionOne = linkTo(methodOn(FamilyRESTController.class).getFamily(familyID)).withSelfRel();
        Link optionTwo = linkTo(methodOn(FamilyRESTController.class).createRelation(new CreateRelationDTO(), familyID)).withRel("OPTIONS - relations");
        Link optionThree = linkTo(methodOn(FamilyRESTController.class).getCategoriesOptions(familyID)).withRel("OPTIONS - categories");

        options.add(optionOne);
        options.add(optionTwo);
        options.add(optionThree);

        when(familyOptionsService.getFamilyOptions(familyID)).thenReturn(options);

        // Expected
        OptionsDTO exoectedOptions = new OptionsDTO();
        Link exoectedOptionOne = linkTo(methodOn(FamilyRESTController.class).getFamily(familyID)).withSelfRel();
        Link exoectedOptionTwo = linkTo(methodOn(FamilyRESTController.class).createRelation(new CreateRelationDTO(), familyID)).withRel("OPTIONS - relations");
        Link exoectedOptionThree = linkTo(methodOn(FamilyRESTController.class).getCategoriesOptions(familyID)).withRel("OPTIONS - categories");

        exoectedOptions.add(exoectedOptionOne);
        exoectedOptions.add(exoectedOptionTwo);
        exoectedOptions.add(exoectedOptionThree);

        HttpHeaders header = new HttpHeaders();
        header.set("Allow", "OPTIONS");

        ResponseEntity expectedResponse = new ResponseEntity(exoectedOptions, header, HttpStatus.OK);

        // Act

        ResponseEntity resultResponse = familyRESTController.getFamilyOptions(familyID);

        assertEquals(expectedResponse, resultResponse);
    }

    @Test
    void getCategoriesOption() {
        assertThrows(UnsupportedOperationException.class, () -> familyRESTController.getCategoriesOptions("@tonyze@gmail.com"));
    }

    @Test
    void getCategoriesSuccess() {
        String familyID = "@tonize@gmail.com";

        OutputCategoryTreeDTO expectedOutputCategoryTreeDTO = new OutputCategoryTreeDTO();
        Link expectedLink = linkTo(methodOn(FamilyRESTController.class).getCategories(familyID)).withSelfRel();
        expectedOutputCategoryTreeDTO.add(expectedLink);
        ResponseEntity expected = new ResponseEntity(expectedOutputCategoryTreeDTO, HttpStatus.OK);

        when(getCustomCategoriesService.getCustomCategories(any(String.class))).thenReturn(new OutputCategoryTreeDTO());

        ResponseEntity result = familyRESTController.getCategories(familyID);

        assertEquals(result, expected);
    }

    @Test
    void getCategoriesFail() {
        String familyID = "@tonize@gmail.com";

        OutputCategoryTreeDTO expectedOutputCategoryTreeDTO = new OutputCategoryTreeDTO();
        Link expectedLink = linkTo(methodOn(FamilyRESTController.class).getCategories(familyID)).withSelfRel();
        expectedOutputCategoryTreeDTO.add(expectedLink);
        ResponseEntity expected = new ResponseEntity("Error: No such family", HttpStatus.BAD_REQUEST);

        when(getCustomCategoriesService.getCustomCategories(any(String.class))).thenThrow(new IllegalArgumentException("No such family"));

        ResponseEntity result = familyRESTController.getCategories(familyID);

        assertEquals(result, expected);
    }
}