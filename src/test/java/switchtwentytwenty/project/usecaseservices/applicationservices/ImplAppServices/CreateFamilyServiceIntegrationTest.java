package switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.dto.FamilyDTODomainAssembler;
import switchtwentytwenty.project.dto.InputFamilyDTO;
import switchtwentytwenty.project.dto.InputPersonDTO;
import switchtwentytwenty.project.dto.PersonDTODomainAssembler;
import switchtwentytwenty.project.exceptions.EmailAlreadyRegisteredException;
import switchtwentytwenty.project.exceptions.InvalidNameException;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;
import switchtwentytwenty.project.usecaseservices.irepositories.IPersonRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class CreateFamilyServiceIntegrationTest {

    CreateFamilyService createFamilyService;
    @Autowired
    IFamilyRepository familyRepository;
    @Autowired
    IPersonRepository personRepository;
    @Autowired
    PersonDTODomainAssembler personDTODomainAssembler;
    @Autowired
    FamilyDTODomainAssembler familyDTODomainAssembler;



    final String VALIDNAME = "JessicaMicaela";
    final String VALIDEMAIL = "jessicaMicaela@latinlover.pt";
    final int VALIDVATNUMBER = 999999999;
    final Integer VALIDPHONENUMBER = 916969696;
    final String VALIDSTREET = "Rua";
    final String VALIDCITY = "Ermesinde";
    final String VALIDZIPCODE = "4700-111";
    final String VALIDADDRESSNUMBER = "69B";
    final String VALIDBIRTHDATE = "01/03/1990";
    InputPersonDTO inputPersonDTO = new InputPersonDTO(null,VALIDEMAIL,VALIDNAME,VALIDBIRTHDATE,VALIDVATNUMBER,
            VALIDPHONENUMBER,VALIDSTREET,VALIDCITY,VALIDADDRESSNUMBER,VALIDZIPCODE);
    //
    final String VALID_FAMILY_NAME = "Simpson";
    final String VALID_REGISTRATION_DATE = "01/03/1990";
    InputFamilyDTO inputFamilyDTO = new InputFamilyDTO(VALID_FAMILY_NAME,VALID_REGISTRATION_DATE);


    @Test
    @Tag("US010")
    void createFamilyAndAddAdminValidData() {
        createFamilyService = new CreateFamilyService(personRepository,familyRepository,personDTODomainAssembler,familyDTODomainAssembler);

        assertDoesNotThrow(()->createFamilyService.createFamilyAndAddAdmin(inputFamilyDTO,inputPersonDTO));
    }

    @Test
    @Tag("US010")
    void createFamilyAndAddAdminInvalidNameThrowsException() {
        createFamilyService = new CreateFamilyService(personRepository,familyRepository,personDTODomainAssembler,familyDTODomainAssembler);

        InputPersonDTO invalidInputPersonDTO = new InputPersonDTO(null,VALIDEMAIL,"",VALIDBIRTHDATE,VALIDVATNUMBER,
                VALIDPHONENUMBER,VALIDSTREET,VALIDCITY,VALIDADDRESSNUMBER,VALIDZIPCODE);

        assertThrows(InvalidNameException.class,()->createFamilyService.createFamilyAndAddAdmin(inputFamilyDTO,invalidInputPersonDTO));
    }



}