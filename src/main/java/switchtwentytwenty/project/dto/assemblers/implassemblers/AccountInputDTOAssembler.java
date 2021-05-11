package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.dto.accounts.AccountInputDTO;
import switchtwentytwenty.project.dto.accounts.CreateAccountDTO;
import switchtwentytwenty.project.dto.accounts.InputAccountDTO;
import switchtwentytwenty.project.dto.assemblers.iassemblers.IAccountInputDTOAssembler;

@Component
public class AccountInputDTOAssembler implements IAccountInputDTOAssembler {

    @Override
    public InputAccountDTO toInputDTO(CreateAccountDTO createAccountDTO) {
        String designation = createAccountDTO.getDesignation();
        Integer initialAmount = createAccountDTO.getInitialAmount();
        String currency = createAccountDTO.getCurrency();
        String ownerID = createAccountDTO.getOwnerID();
        String accountType = createAccountDTO.getAccountType();
        InputAccountDTO inputAccountDTO = new InputAccountDTO(designation, initialAmount, currency, ownerID, accountType);
        return inputAccountDTO;
    }
}

