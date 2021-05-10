package switchtwentytwenty.project.usecaseservices.applicationservices.iappservices;

import switchtwentytwenty.project.dto.accounts.OutputAccountDTO;
import switchtwentytwenty.project.dto.accounts.AccountInputDTO;

public interface ICreateAccountService {

    OutputAccountDTO createAccount(AccountInputDTO inputAccountDTO);
}
