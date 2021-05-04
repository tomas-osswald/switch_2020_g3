package switchtwentytwenty.project.dto.assemblers.iassemblers;

import switchtwentytwenty.project.domain.aggregates.account.Account;
import switchtwentytwenty.project.dto.accounts.InputAccountDTO;
import switchtwentytwenty.project.dto.accounts.OutputAccountDTO;

public interface IAccountDTODomainAssembler {

    OutputAccountDTO toDTO(Account account);

    Account toDomain(InputAccountDTO inputAccountDTO);
}