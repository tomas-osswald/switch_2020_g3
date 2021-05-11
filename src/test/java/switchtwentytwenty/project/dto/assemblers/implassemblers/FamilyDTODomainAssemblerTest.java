package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.domain.valueobject.FamilyName;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.domain.valueobject.RegistrationDate;
import switchtwentytwenty.project.dto.family.InputFamilyDTO;
import switchtwentytwenty.project.dto.family.OutputFamilyDTO;

import static org.junit.jupiter.api.Assertions.*;

class FamilyDTODomainAssemblerTest {


    FamilyDTODomainAssembler familyDTODomainAssembler = new FamilyDTODomainAssembler();



    @Test
    void toDTO() {
        FamilyID familyID = new FamilyID("admin@gmail.com");
        String familyNameString = "Ribeiro";
        FamilyName familyName = new FamilyName(familyNameString);
        String date = "12/12/1990";
        RegistrationDate registrationDate = new RegistrationDate(date);
        String emailString = "admin@gmail.com";
        PersonID adminEmail = new PersonID(emailString);

        Family family = new Family(familyID, familyName, registrationDate, adminEmail);

        OutputFamilyDTO expected = new OutputFamilyDTO(familyNameString, familyID.toString(), emailString, registrationDate.toString());

        OutputFamilyDTO result = familyDTODomainAssembler.toDTO(family);

        assertEquals(expected, result);
        assertNotNull(result);
    }

    @Test
    void createFamilyNameTest(){
        String familyName = "Simpson";
        String registrationDate = "11/09/2020";
        InputFamilyDTO inputFamilyDTO = new InputFamilyDTO(familyName,registrationDate);
        FamilyName expected = new FamilyName(familyName);

        FamilyName result = familyDTODomainAssembler.createFamilyName(inputFamilyDTO);

        assertEquals(expected,result);
    }

    @Test
    void createRegistrationDateTest(){
        String familyName = "Simpson";
        String registrationDate = "11/09/2020";
        InputFamilyDTO inputFamilyDTO = new InputFamilyDTO(familyName,registrationDate);
        RegistrationDate expected = new RegistrationDate(registrationDate);

        RegistrationDate result = familyDTODomainAssembler.createRegistrationDate(inputFamilyDTO);

        assertEquals(expected,result);
    }
}