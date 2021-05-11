package switchtwentytwenty.project.dto.assemblers.implassemblers;

import switchtwentytwenty.project.dto.accounts.AccountInputDTO;
import switchtwentytwenty.project.dto.accounts.CreateAccountDTO;
import switchtwentytwenty.project.dto.assemblers.iassemblers.IAccountInputDTOAssembler;

public class AccountInputDTOAssembler implements IAccountInputDTOAssembler {

    @Override
    public AccountInputDTO toInputDTO(CreateAccountDTO createAccountDTO) {
        String designation = createAccountDTO.getDesignation();
        Integer initialAmount = createAccountDTO.getInitialAmount();
        String currency = createAccountDTO.getCurrency();
        String ownerID = createAccountDTO.getOwnerID();
        String accountType = createAccountDTO.getAccountType();
        AccountInputDTO accountInputDTO = new AccountInputDTO(designation, initialAmount, currency, ownerID, accountType);
        return accountInputDTO;
    }
}
