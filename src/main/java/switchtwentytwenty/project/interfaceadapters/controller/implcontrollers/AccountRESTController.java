package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import switchtwentytwenty.project.dto.accounts.CreateAccountDTO;
import switchtwentytwenty.project.dto.assemblers.iassemblers.IAccountInputDTOAssembler;
import switchtwentytwenty.project.interfaceadapters.controller.icontrollers.IAccountRESTController;

public class AccountRESTController implements IAccountRESTController {

    @Autowired
    IAccountInputDTOAssembler accountInputDTOAssembler;

    @Override
    public ResponseEntity<Object> createAccount(CreateAccountDTO createAccountDTO) {
        throw new UnsupportedOperationException();
    }
}
