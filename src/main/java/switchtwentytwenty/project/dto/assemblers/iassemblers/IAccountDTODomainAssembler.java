package switchtwentytwenty.project.dto.assemblers.iassemblers;

import switchtwentytwenty.project.domain.aggregates.account.Account;
import switchtwentytwenty.project.dto.accounts.OutputAccountDTO;

public interface IAccountDTODomainAssembler {

    OutputAccountDTO toDTO(Account account);


    //TODO: método para cada value object
}
