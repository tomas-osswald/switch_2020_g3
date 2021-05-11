package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.valueobject.FamilyName;
import switchtwentytwenty.project.domain.valueobject.RegistrationDate;
import switchtwentytwenty.project.dto.family.InputFamilyDTO;
import switchtwentytwenty.project.dto.family.OutputFamilyDTO;

@Component
public class FamilyDTODomainAssembler {

    /**
     * Assembler method to create a FamilyName value object
     *
     * @param inputFamilyDTO DTO that contains the Family's information
     * @return FamilyName value object
     */
    public FamilyName createFamilyName(InputFamilyDTO inputFamilyDTO) {
        FamilyName familyName = new FamilyName((inputFamilyDTO.unpackFamilyName()));
        return familyName;
    }

    /**
     * Assembler method to create a RegistrationDate value object
     *
     * @param inputFamilyDTO DTO that contains the Family's information
     * @return RegistrationDate value object
     */
    public RegistrationDate createRegistrationDate(InputFamilyDTO inputFamilyDTO) {
        RegistrationDate registrationDate = new RegistrationDate(inputFamilyDTO.unpackRegistrationDate());
        return registrationDate;
    }

    /**
     * Assembler Method to create an output DTO from a domain Family Object
     *
     * @param family family which will be converted to DTO
     * @return OutputFamilyDTO - object containing the family name, family administrator and the registration date
     */
    public OutputFamilyDTO toDTO(Family family) {
        OutputFamilyDTO outputFamilyDTO = new OutputFamilyDTO(family.getName().toString(), family.id().toString(), family.getAdmin().toString(), family.getRegistrationDate().toString());
        return outputFamilyDTO;
    }

}