package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.aggregates.account.AbAccount;
import switchtwentytwenty.project.domain.aggregates.account.IAccount;
import switchtwentytwenty.project.domain.valueobject.AccountType;
import switchtwentytwenty.project.domain.valueobject.Designation;
import switchtwentytwenty.project.domain.valueobject.Movement;
import switchtwentytwenty.project.domain.valueobject.OwnerID;
import switchtwentytwenty.project.dto.accounts.InputAccountDTO;
import switchtwentytwenty.project.dto.accounts.OutputAccountDTO;

@Component
public class AccountDTODomainAssembler {

   /* public OwnerID ownerIDToDomain(InputAccountDTO inputAccountDTO) {
        OwnerID ownerID = new OwnerID(inputAccountDTO.unpackOwnerID());
        return ownerID;
    }

    public Movement movementToDomain(InputAccountDTO inputAccountDTO) {
        Movement movement = new Movement(inputAccountDTO.unpackMovement());
        return movement;
    }

    public Designation designationToDomain(InputAccountDTO inputAccountDTO) {
        Designation designation = new Designation(inputAccountDTO.unpackDesignation());
        return designation;
    }

    public AccountType accountTypeToDomain(InputAccountDTO inputAccountDTO) {
        return inputAccountDTO.unpackAccountType();

    }*/

    public OutputAccountDTO toDTO(AbAccount savedAccount) {
        return null;
    }

}