package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import org.hibernate.result.Output;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import switchtwentytwenty.project.dto.OptionsDTO;
import switchtwentytwenty.project.dto.category.CreateStandardCategoryDTO;
import switchtwentytwenty.project.dto.category.InputCategoryDTO;
import switchtwentytwenty.project.dto.category.OutputCategoryDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICategoriesOptionsService;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICreateStandardCategoryService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@ExtendWith(MockitoExtension.class)
class CategoryRESTControllerTest {

    @Mock
    ICategoriesOptionsService categoriesOptionsService;

    @Mock
    ICreateStandardCategoryService createStandardCategoryService;

    @InjectMocks
    CategoryRESTController controller;

    @Test
    void getCategoryTest() {
        String categoryID = "12";

        assertThrows(UnsupportedOperationException.class, () -> controller.getCategory(categoryID));
    }

    @Test
    void categoriesOptionsTest() {
        OptionsDTO options = new OptionsDTO();
        when(categoriesOptionsService.getCategoriesOptions()).thenReturn(options);
        HttpHeaders header = new HttpHeaders();
        header.set("Allow", "POST, OPTIONS");

        ResponseEntity expected = new ResponseEntity(options, header, HttpStatus.OK);

        ResponseEntity result = controller.categoriesOptions();

        assertEquals(expected, result);
    }

    @Test
    void createStandardCategoryTestInvalidCategoryObject() {
        CreateStandardCategoryDTO createStandardCategoryDTO = new CreateStandardCategoryDTO("","2L");
        when(createStandardCategoryService.createStandardCategory(any(InputCategoryDTO.class))).thenThrow(new IllegalArgumentException(""));
        ResponseEntity expected = new ResponseEntity("Error: ", HttpStatus.UNPROCESSABLE_ENTITY);

        ResponseEntity<OutputCategoryDTO> result = controller.createStandardCategory(createStandardCategoryDTO);

        assertEquals(expected,result);
    }

    @Test
    void createStandardCategoryTest() {
        CreateStandardCategoryDTO createStandardCategoryDTO = new CreateStandardCategoryDTO("Casa","2L");
        when(createStandardCategoryService.createStandardCategory(any(InputCategoryDTO.class))).thenReturn(new OutputCategoryDTO("Casa","1L","2L"));
        OutputCategoryDTO expectedDTO = new OutputCategoryDTO("Casa","1L","2L");
        expectedDTO.add(linkTo(methodOn(CategoryRESTController.class).getCategory("1")).withSelfRel());
        ResponseEntity expected = new ResponseEntity(expectedDTO, HttpStatus.CREATED);

        ResponseEntity<OutputCategoryDTO> result = controller.createStandardCategory(createStandardCategoryDTO);

        assertEquals(expected,result);
    }

    @Test
    void createStandardCategoryTestNullParentCategory() {
        CreateStandardCategoryDTO createStandardCategoryDTO = new CreateStandardCategoryDTO("Casa",null);
        when(createStandardCategoryService.createStandardCategory(any(InputCategoryDTO.class))).thenReturn(new OutputCategoryDTO("Casa","1L" ));
        OutputCategoryDTO expectedDTO = new OutputCategoryDTO("Casa","1L");
        expectedDTO.add(linkTo(methodOn(CategoryRESTController.class).getCategory("1")).withSelfRel());
        ResponseEntity expected = new ResponseEntity(expectedDTO, HttpStatus.CREATED);

        ResponseEntity<OutputCategoryDTO> result = controller.createStandardCategory(createStandardCategoryDTO);

        assertEquals(expected,result);
    }
}