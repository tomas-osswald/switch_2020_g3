package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.aggregates.person.Person;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.family.*;
import switchtwentytwenty.project.dto.person.FamilyMemberAndRelationsDTO;
import switchtwentytwenty.project.interfaceadapters.controller.implcontrollers.FamilyRESTController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
    public OutputFamilyDTO toOutputFamilyDTO(Family family) {
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

    public OutputRelationDTO toOutputRelationDTO(Relation relation) {
        String personIDOne = relation.getMemberA().toString();
        String personIDTwo = relation.getMemberB().toString();
        String designation = relation.getRelationDesignation().toString();
        String relationID = relation.getId().toString();

        return new OutputRelationDTO(personIDOne, personIDTwo, designation, relationID);


    }

    public OutputPersonRelationDTO toOutputPersonRelationDTO(Relation relation, String familyID) {
        String personIDOne = relation.getMemberA().toString();
        String personIDTwo = relation.getMemberB().toString();
        String designation = relation.getRelationDesignation().toString();
        String relationID = relation.getId().toString();
        Link changeRelationLink = linkTo(methodOn(FamilyRESTController.class).changeRelation(null, familyID, relationID)).withSelfRel();

        OutputPersonRelationDTO outputPersonRelationDTO = new OutputPersonRelationDTO(personIDOne, personIDTwo, designation, relationID);
        outputPersonRelationDTO.add(changeRelationLink);

        return outputPersonRelationDTO;

    }


    public FamilyID familyIDToDomain(String familyID) {
        return new FamilyID(familyID);
    }

    public FamilyMemberAndRelationsDTO createFamilyMemberAndRelationsDTO(Person person, Family family) {
        FamilyMemberAndRelationsDTO familyMemberAndRelationsDTO = new FamilyMemberAndRelationsDTO();
        familyMemberAndRelationsDTO.setName(person.getName().toString());
        familyMemberAndRelationsDTO.setPersonID(person.id().toString());
        List<OutputPersonRelationDTO> relationsDTO = getRelationsDTO(person.id(), family);
        familyMemberAndRelationsDTO.setRelations(relationsDTO);
        return familyMemberAndRelationsDTO;
    }

    private List<OutputPersonRelationDTO> getRelationsDTO(PersonID id, Family family) {
        List<Relation> personRelationList = family.getRelationsByPersonID(id);
        List<OutputPersonRelationDTO> outputRelationDTOList = new ArrayList<>();
        for (Relation relation : personRelationList) {
            outputRelationDTOList.add(toOutputPersonRelationDTO(relation, family.id().toString()));
        }
        return outputRelationDTOList;
    }
}