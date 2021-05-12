package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.aggregates.account.IAccount;
import switchtwentytwenty.project.domain.valueobject.*;
import switchtwentytwenty.project.dto.accounts.InputAccountDTO;
import switchtwentytwenty.project.dto.accounts.OutputAccountDTO;
import switchtwentytwenty.project.dto.assemblers.iassemblers.IAccountDTODomainAssembler;

import java.math.BigDecimal;

@Component
public class AccountDTODomainAssembler implements IAccountDTODomainAssembler {

    public Designation designationToDomain(InputAccountDTO inputAccountDTO) {
        return new Designation(inputAccountDTO.getDesignation());
    }

    public Monetary initialAmountToDomain(InputAccountDTO inputAccountDTO){
        BigDecimal amount = inputAccountDTO.getInitialAmount();
        Monetary monetary = new Monetary(inputAccountDTO.getCurrency(), amount);
        return monetary;
    }

    public OwnerID ownerIDToDomain(InputAccountDTO inputAccountDTO) {

        /**
         * Alterar o @ no próximo sprint. Check FamilyID.
         */
        char validation = inputAccountDTO.getOwnerID().charAt(0);
        String validationID = Character.toString(validation);
        OwnerID ownerID;

        if ( validationID == "@" ){
            ownerID = new FamilyID(inputAccountDTO.getOwnerID());
        } else {
            ownerID = new PersonID(inputAccountDTO.getOwnerID());
        }
        return ownerID;

    }

    public String accountTypeToDomain(InputAccountDTO inputAccountDTO) {
        return inputAccountDTO.getAccountType();
    }

    @Override
    public OutputAccountDTO toDTO(IAccount IAccount) {
        return null;
    }
}