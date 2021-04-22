package switchtwentytwenty.project.interfaceadapters.controller;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class CreateFamilyControllerTest {

/*
    CreateFamilyController controller;
    CreateFamilyService createFamilyService;
    CreateFamilyDTO VALIDCreateFamilyDTO;
    AddPersonFormDTO addPersonDTO;
    LocalDate localDate = LocalDate.of(2019,12,12);

    @BeforeEach
    void setup(){
        controller = new CreateFamilyController();
        createFamilyService = new CreateFamilyService();
        VALIDCreateFamilyDTO = new CreateFamilyDTO( "Silva", LocalDate.of(2021,12,25) );
        addPersonDTO = new AddPersonFormDTO("email@there.com", "email@here.com","Rui", "28/12/1990", 123456789, 919999999, "Rua do Coiso", "Porto", 12, "4432-222");
    }



    @DisplayName("Test if a family can be successfully created")
    @Test
    void shouldBeTrueCreateFamily() {

        assertTrue(controller.createFamilyAndAdmin(VALIDCreateFamilyDTO,addPersonDTO));


    }

    @DisplayName("Test if a family isn't created if the admin email is already registered in the app")
    @Test
    void shouldBeFalseCreateFamilyEmailAlreadyregistered() {
        controller.createFamilyAndAdmin(VALIDCreateFamilyDTO,addPersonDTO);
        assertFalse(controller.createFamilyAndAdmin(VALIDCreateFamilyDTO,addPersonDTO));
    }

    @DisplayName("Test if a family isn't created if the family name is null, void or empty")
    @ParameterizedTest
    @ValueSource(strings = {"   "})
    @NullAndEmptySource
    void shouldBeFalseCreateFamilyInvalidFamilyName(String value) {
        CreateFamilyDTO INVALIDCreateFamilyDTO = new CreateFamilyDTO(value, localDate);
        assertFalse(controller.createFamilyAndAdmin(INVALIDCreateFamilyDTO,addPersonDTO));
    }
*/
}