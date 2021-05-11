package switchtwentytwenty.project.usecaseservices.applicationservices.iappservices;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.dto.accounts.OutputAccountDTO;
import switchtwentytwenty.project.dto.accounts.InputAccountDTO;

@Component
public interface ICreateAccountService {

    OutputAccountDTO createAccount(InputAccountDTO inputAccountDTO);
}

