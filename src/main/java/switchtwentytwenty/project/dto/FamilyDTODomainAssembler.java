package switchtwentytwenty.project.dto;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.domain.valueobject.FamilyName;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.domain.valueobject.RegistrationDate;
@Component
public class FamilyDTODomainAssembler {

    /**
     * Assembler method to create a Family domain object from a DTO.
     * @param inputFamilyDTO DTO that contains the Family's information
     * @param familyID Domain object representing the FamilyID of the Family to be created
     * @param adminID Domain object representing the PersonID of the Administrator of the Family to be created
     * @return Family domain object
     */
    public Family toDomain(InputFamilyDTO inputFamilyDTO, FamilyID familyID, PersonID adminID) {

        FamilyName familyName = new FamilyName(inputFamilyDTO.unpackFamilyName());

        RegistrationDate registrationDate = new RegistrationDate(inputFamilyDTO.unpackLocalDate());

        Family family = new Family(familyID, familyName, registrationDate, adminID);

        return family;
    }

}
