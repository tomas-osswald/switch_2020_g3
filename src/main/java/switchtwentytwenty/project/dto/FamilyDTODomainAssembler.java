package switchtwentytwenty.project.dto;

import switchtwentytwenty.project.datamodel.assemblerjpa.FamilyDataDomainAssembler;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.domain.valueobject.FamilyName;
import switchtwentytwenty.project.domain.valueobject.PersonID;
import switchtwentytwenty.project.domain.valueobject.RegistrationDate;

public class FamilyDTODomainAssembler {

    public Family toDomain(CreateFamilyDTO createFamilyDTO, FamilyID familyID, PersonID personID) {

        FamilyName familyName = new FamilyName(createFamilyDTO.unpackFamilyName());

        RegistrationDate registrationDate = new RegistrationDate(createFamilyDTO.unpackLocalDate());

        Family family = new Family(familyID, familyName, registrationDate, personID);

        return family;
    }

}
