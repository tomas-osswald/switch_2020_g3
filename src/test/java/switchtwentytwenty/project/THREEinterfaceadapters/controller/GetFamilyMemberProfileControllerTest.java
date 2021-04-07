package switchtwentytwenty.project.THREEinterfaceadapters.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.Application;
import switchtwentytwenty.project.ONEdomain.aggregates.person.Person;
import switchtwentytwenty.project.dto.AddPersonDTO;
import switchtwentytwenty.project.dto.CreateFamilyDTO;
import switchtwentytwenty.project.dto.ProfileOutputDTO;
import switchtwentytwenty.project.ONEdomain.valueobject.*;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class GetFamilyMemberProfileControllerTest {

    //
    final String VALIDNAME = "TonyZe";
    final String VALIDEMAIL = "tonyze@latinlover.pt";
    final int VALIDVATNUMBER = 999999999;
    final Integer VALIDPHONENUMBER = 916969696;
    final String VALIDSTREET = "Rua";
    final String VALIDCITY = "Ermesinde";
    final String VALIDZIPCODE = "4700-111";
    final int VALIDADDRESSNUMBER = 69;
    final String VALIDBIRTHDATE = "01/03/1990";
    //
    final String VALID_FAMILY_NAME = "Simpson";
    final LocalDate VALID_REGISTRATION_DATE = LocalDate.of(2021, 12, 25);
    //
    GetFamilyMemberProfileController getFamilyMemberProfileController;
    Application application;
    CreateFamilyController createFamilyController;
    Person validPerson;
    //
    CreateFamilyDTO VALIDCreateFamilyDTO;
    AddPersonDTO addPersonDTO;
    LocalDate localDate = LocalDate.of(2019, 12, 12);


    @BeforeEach
    void setup() {
        Name tonyZeName = new Name(VALIDNAME);
        BirthDate tonyZeBirthDate = new BirthDate(VALIDBIRTHDATE);
        PersonID tonyZeEmail = new PersonID(VALIDEMAIL);
        VATNumber tonyZeVat = new VATNumber(VALIDVATNUMBER);
        PhoneNumber tonyZePhone = new PhoneNumber(VALIDPHONENUMBER);
        Address tonyZeAddress = new Address(VALIDSTREET, VALIDCITY, VALIDZIPCODE, VALIDADDRESSNUMBER);
        FamilyID familyID = new FamilyID(UUID.randomUUID());
        validPerson = new Person(tonyZeName, tonyZeBirthDate, tonyZeEmail, tonyZeVat, tonyZePhone, tonyZeAddress, familyID);

        application.setLoggedPerson(validPerson);

        createFamilyController = new CreateFamilyController(application);

        addPersonDTO = new AddPersonDTO(VALIDEMAIL, VALIDNAME, VALIDBIRTHDATE, VALIDVATNUMBER, VALIDPHONENUMBER, VALIDSTREET, VALIDCITY, VALIDADDRESSNUMBER, VALIDZIPCODE);
        VALIDCreateFamilyDTO = new CreateFamilyDTO(VALID_FAMILY_NAME, VALID_REGISTRATION_DATE);


        getFamilyMemberProfileController = new GetFamilyMemberProfileController(application);
    }

    @Disabled
    @DisplayName("Get Family Member Profile, success")
    @Test
    void shouldReturnAValidProfileOutputDTO() {
        // Arrange
        createFamilyController.createFamilyAndAdmin(VALIDCreateFamilyDTO, addPersonDTO);
        ProfileOutputDTO expected = new ProfileOutputDTO(VALIDEMAIL, VALIDNAME, VALIDBIRTHDATE, VALIDVATNUMBER, VALIDPHONENUMBER, VALIDSTREET, VALIDCITY, VALIDADDRESSNUMBER, VALIDZIPCODE);

        // Act
        ProfileOutputDTO result = getFamilyMemberProfileController.getFamilyMemberProfile();

        // Assert
        assertEquals(expected, result);
    }

    @Disabled
    @DisplayName("Get Family Member Profile, different ProfileInfo")
    @Test
    void shouldReturnAValidProfileOutputDTOButNotCorrect() {
        // Arrange
        createFamilyController.createFamilyAndAdmin(VALIDCreateFamilyDTO, addPersonDTO);

        String anotherPersonName = "O outro";

        ProfileOutputDTO expected = new ProfileOutputDTO(VALIDEMAIL, anotherPersonName, VALIDBIRTHDATE, VALIDVATNUMBER, VALIDPHONENUMBER, VALIDSTREET, VALIDCITY, VALIDADDRESSNUMBER, VALIDZIPCODE);

        // Act
        ProfileOutputDTO result = getFamilyMemberProfileController.getFamilyMemberProfile();

        // Assert
        assertNotEquals(expected, result);
    }
}