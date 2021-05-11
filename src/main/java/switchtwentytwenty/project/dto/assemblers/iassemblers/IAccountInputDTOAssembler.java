package switchtwentytwenty.project.dto.assemblers.iassemblers;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.dto.accounts.AccountInputDTO;
import switchtwentytwenty.project.dto.accounts.CreateAccountDTO;
import switchtwentytwenty.project.dto.accounts.InputAccountDTO;

public interface IAccountInputDTOAssembler {

    InputAccountDTO toInputDTO (CreateAccountDTO createAccountDTO);
}
