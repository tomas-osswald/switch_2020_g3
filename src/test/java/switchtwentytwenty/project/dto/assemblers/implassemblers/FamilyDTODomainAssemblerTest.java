package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.family.InputFamilyDTO;
import switchtwentytwenty.project.dto.family.InputRelationDTO;
import switchtwentytwenty.project.dto.family.OutputFamilyDTO;
import switchtwentytwenty.project.dto.family.OutputRelationDTO;

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

    @Test
    void personIDOneToDomain() {
        InputRelationDTO inputRelationDTO = new InputRelationDTO();
        inputRelationDTO.setPersonIDOne("admin@mail.net");
        PersonID expected = new PersonID("admin@mail.net");

        PersonID result = familyDTODomainAssembler.personIDOneToDomain(inputRelationDTO);

        assertEquals(expected,result);
    }

    @Test
    void personIDTwoToDomain() {
        InputRelationDTO inputRelationDTO = new InputRelationDTO();
        inputRelationDTO.setPersonIDTwo("person@mail.net");
        PersonID expected = new PersonID("person@mail.net");

        PersonID result = familyDTODomainAssembler.personIDTwoToDomain(inputRelationDTO);

        assertEquals(expected,result);
    }

    @Test
    void relationDesignationToDomain() {
        InputRelationDTO inputRelationDTO = new InputRelationDTO();
        inputRelationDTO.setDesignation("Friends");
        RelationDesignation expected = new RelationDesignation("Friends");

        RelationDesignation result = familyDTODomainAssembler.relationDesignationToDomain(inputRelationDTO);

        assertEquals(expected,result);
    }

    @Test
    void familyIDToDomain() {
        InputRelationDTO inputRelationDTO = new InputRelationDTO();
        inputRelationDTO.setFamilyID("@person@mail.net");
        FamilyID expected = new FamilyID("@person@mail.net");

        FamilyID result = familyDTODomainAssembler.familyIDToDomain(inputRelationDTO);

        assertEquals(expected,result);
    }

    @Test
    void testToDTO() {
        PersonID personIDA = new PersonID("admin@mail.net");
        PersonID personIDB = new PersonID("person@mail.net");
        RelationDesignation designation = new RelationDesignation("Friends");
        RelationID id = new RelationID(13);
        Relation relation = new Relation(personIDA,personIDB,designation,id);
        OutputRelationDTO expected = new OutputRelationDTO("admin@mail.net","person@mail.net","Friends","13");

        OutputRelationDTO result = familyDTODomainAssembler.toDTO(relation);

        assertEquals(expected.getLinks(),result.getLinks());
        assertEquals(expected.getMemberOneID(),result.getMemberOneID());
        assertEquals(expected.getMemberTwoID(),result.getMemberTwoID());
        assertEquals(expected.getRelationDesignation(),result.getRelationDesignation());
    }

}