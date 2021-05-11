package switchtwentytwenty.project.dto.assemblers.implassemblers;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.aggregates.account.Account;
import switchtwentytwenty.project.dto.accounts.OutputAccountDTO;

@Component
public class AccountDTODomainAssembler {

    public OutputAccountDTO toDTO(Account savedAccount) {
        return null;
    }

}