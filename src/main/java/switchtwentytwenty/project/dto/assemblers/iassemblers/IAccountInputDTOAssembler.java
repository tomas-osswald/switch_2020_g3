package switchtwentytwenty.project.dto.assemblers.iassemblers;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.dto.accounts.AccountInputDTO;
import switchtwentytwenty.project.dto.accounts.CreateAccountDTO;

@Component
public interface IAccountInputDTOAssembler {

    AccountInputDTO toInputDTO (CreateAccountDTO createAccountDTO);
}
