package switchtwentytwenty.project.dto.assemblers.iassemblers;

import switchtwentytwenty.project.dto.accounts.AccountInputDTO;
import switchtwentytwenty.project.dto.accounts.CreateAccountDTO;

public interface IAccountInputDTOAssembler {

    AccountInputDTO toInputDTO (CreateAccountDTO createAccountDTO);
}
