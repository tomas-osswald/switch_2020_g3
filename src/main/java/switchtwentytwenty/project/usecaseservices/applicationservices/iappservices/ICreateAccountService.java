package switchtwentytwenty.project.usecaseservices.applicationservices.iappservices;

import switchtwentytwenty.project.dto.accounts.OutputAccountDTO;
import switchtwentytwenty.project.dto.accounts.InputAccountDTO;

public interface ICreateAccountService {

    OutputAccountDTO createAccount(InputAccountDTO inputAccountDTO);
}
