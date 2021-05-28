package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.family.InputFamilyDTO;
import switchtwentytwenty.project.dto.family.InputRelationDTO;
import switchtwentytwenty.project.dto.family.OutputFamilyDTO;
import switchtwentytwenty.project.dto.family.OutputRelationDTO;

@Component
public class FamilyDTODomainAssembler {

    /**
     * Assembler method to create a FamilyName value object
     *
     * @param inputFamilyDTO DTO that contains the Family's information
     * @return FamilyName value object
     */
    public FamilyName createFamilyName(InputFamilyDTO inputFamilyDTO) {
        return new FamilyName((inputFamilyDTO.unpackFamilyName()));
    }

    /**
     * Assembler method to create a RegistrationDate value object
     *
     * @param inputFamilyDTO DTO that contains the Family's information
     * @return RegistrationDate value object
     */
    public RegistrationDate createRegistrationDate(InputFamilyDTO inputFamilyDTO) {
        return new RegistrationDate(inputFamilyDTO.unpackRegistrationDate());
    }

    /**
     * Assembler Method to create an output DTO from a domain Family Object
     *
     * @param family family which will be converted to DTO
     * @return OutputFamilyDTO - object containing the family name, family administrator and the registration date
     */
    public OutputFamilyDTO toDTO(Family family) {
        return new OutputFamilyDTO(family.getName().toString(), family.id().toString(), family.getAdmin().toString(), family.getRegistrationDate().toString());
    }

    public PersonID personIDOneToDomain(InputRelationDTO inputRelationDTO) {

        return new PersonID(inputRelationDTO.getPersonIDOne());
    }

    public PersonID personIDTwoToDomain(InputRelationDTO inputRelationDTO) {

        return new PersonID(inputRelationDTO.getPersonIDTwo());
    }

    public RelationDesignation relationDesignationToDomain(InputRelationDTO inputRelationDTO) {
        return new RelationDesignation(inputRelationDTO.getDesignation());
    }

    public FamilyID familyIDToDomain(InputRelationDTO inputRelationDTO) {
        return new FamilyID(inputRelationDTO.getFamilyID());
    }

    public OutputRelationDTO toDTO(Relation relation) {
        String personIDOne = relation.getMemberA().toString();
        String personIDTwo = relation.getMemberB().toString();
        String designation = relation.getRelationDesignation().toString();
        String relationID = relation.getId().toString();

        OutputRelationDTO outputRelationDTO = new OutputRelationDTO(personIDOne, personIDTwo, designation, relationID);
        outputRelationDTO.setMemberOneID(personIDOne);
        outputRelationDTO.setMemberTwoID(personIDTwo);
        outputRelationDTO.setRelationDesignation(designation);
        outputRelationDTO.setRelationID(relationID);

        return outputRelationDTO;
    }


    public FamilyID familyIDToDomain(String familyID) {
        return new FamilyID(familyID);
    }
}