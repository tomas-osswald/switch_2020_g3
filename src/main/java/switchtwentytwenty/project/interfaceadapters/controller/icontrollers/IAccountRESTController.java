package switchtwentytwenty.project.interfaceadapters.controller.icontrollers;

import org.springframework.http.ResponseEntity;
import switchtwentytwenty.project.dto.accounts.CreateAccountDTO;

public interface IAccountRESTController {

    ResponseEntity<Object> createAccount(CreateAccountDTO createAccountDTO);
}
