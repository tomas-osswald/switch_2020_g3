package switchtwentytwenty.project.dto.assemblers.implassemblers;

import switchtwentytwenty.project.dto.accounts.AccountInputDTO;
import switchtwentytwenty.project.dto.accounts.CreateAccountDTO;
import switchtwentytwenty.project.dto.assemblers.iassemblers.IAccountInputDTOAssembler;

public class AccountInputDTOAssembler implements IAccountInputDTOAssembler {

    @Override
    public AccountInputDTO toInputDTO (CreateAccountDTO createAccountDTO) {
        throw new UnsupportedOperationException();
    }

}
