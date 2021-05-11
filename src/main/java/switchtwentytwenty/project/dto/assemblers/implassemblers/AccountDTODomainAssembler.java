package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.aggregates.account.IAccount;
import switchtwentytwenty.project.domain.valueobject.Designation;
import switchtwentytwenty.project.dto.accounts.InputAccountDTO;
import switchtwentytwenty.project.dto.accounts.OutputAccountDTO;
import switchtwentytwenty.project.dto.assemblers.iassemblers.IAccountDTODomainAssembler;

@Component
public class AccountDTODomainAssembler implements IAccountDTODomainAssembler {

    public Designation designationToDomain(InputAccountDTO inputAccountDTO) {
        return new Designation(inputAccountDTO.getDesignation());
    }

    public Integer initialAmmountToDomain(InputAccountDTO inputAccountDTO) {
        return inputAccountDTO.getInitialAmount();
    }

    public String currencyToDomain(InputAccountDTO inputAccountDTO) {
        return inputAccountDTO.getCurrency();
    }

    public String ownerIDToDomain(InputAccountDTO inputAccountDTO) {
        return inputAccountDTO.getOwnerID();
    }

    public String accountTypeToDomain(InputAccountDTO inputAccountDTO) {
        return inputAccountDTO.getAccountType();
    }

    @Override
    public OutputAccountDTO toDTO(IAccount IAccount) {
        return null;
    }
}