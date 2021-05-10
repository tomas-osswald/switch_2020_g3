package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.domain.valueobject.FamilyName;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.domain.valueobject.RegistrationDate;
import switchtwentytwenty.project.dto.family.InputFamilyDTO;
import switchtwentytwenty.project.dto.family.OutputFamilyDTO;

@Component
public class FamilyDTODomainAssembler {

    /**
     * Assembler method to create a Family domain object from a DTO.
     *
     * @param inputFamilyDTO DTO that contains the Family's information
     * @param familyID       Domain object representing the FamilyID of the Family to be created
     * @param adminID        Domain object representing the PersonID of the Administrator of the Family to be created
     * @return Family domain object
     */
    @Deprecated
    public Family toDomain(InputFamilyDTO inputFamilyDTO, FamilyID familyID, PersonID adminID) {

        FamilyName familyName = new FamilyName(inputFamilyDTO.unpackFamilyName());

        RegistrationDate registrationDate = new RegistrationDate(inputFamilyDTO.unpackLocalDate());

        Family family = new Family(familyID, familyName, registrationDate, adminID);

        return family;
    }

    public FamilyName createFamilyName(InputFamilyDTO inputFamilyDTO) {
        FamilyName familyName = new FamilyName((inputFamilyDTO.unpackFamilyName()));
        return familyName;
    }

    public RegistrationDate createRegistrationDate(InputFamilyDTO inputFamilyDTO) {
        RegistrationDate registrationDate = new RegistrationDate(inputFamilyDTO.unpackLocalDate());
        return registrationDate;
    }

    public OutputFamilyDTO toDTO(Family family) {
        OutputFamilyDTO outputFamilyDTO = new OutputFamilyDTO(family.getName().toString(), family.id().toString(), family.getAdmin().toString(), family.getRegistrationDate().toString());
        return outputFamilyDTO;
    }

}