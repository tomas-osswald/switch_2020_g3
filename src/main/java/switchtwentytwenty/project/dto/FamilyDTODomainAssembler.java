package switchtwentytwenty.project.dto;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.domain.valueobject.FamilyName;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.domain.valueobject.RegistrationDate;
@Component
public class FamilyDTODomainAssembler {

    public Family toDomain(InputFamilyDTO inputFamilyDTO, FamilyID familyID, PersonID adminID) {

        FamilyName familyName = new FamilyName(inputFamilyDTO.unpackFamilyName());

        RegistrationDate registrationDate = new RegistrationDate(inputFamilyDTO.unpackLocalDate());

        Family family = new Family(familyID, familyName, registrationDate, adminID);

        return family;
    }

}
