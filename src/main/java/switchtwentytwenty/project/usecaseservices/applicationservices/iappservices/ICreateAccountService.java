package switchtwentytwenty.project.usecaseservices.applicationservices.iappservices;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.dto.accounts.OutputAccountDTO;
import switchtwentytwenty.project.dto.accounts.AccountInputDTO;

@Component
public interface ICreateAccountService {

    OutputAccountDTO createAccount(AccountInputDTO inputAccountDTO);
}
