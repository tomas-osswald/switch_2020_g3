package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import switchtwentytwenty.project.dto.accounts.CreateAccountDTO;
import switchtwentytwenty.project.dto.accounts.InputAccountDTO;
import switchtwentytwenty.project.dto.accounts.OutputAccountDTO;
import switchtwentytwenty.project.dto.assemblers.iassemblers.IAccountInputDTOAssembler;
import switchtwentytwenty.project.interfaceadapters.controller.icontrollers.IAccountRESTController;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICreateAccountService;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountRESTControllerTest {

    @Mock
    IAccountInputDTOAssembler mockAccountInputDTOAssembler;

    @Mock
    ICreateAccountService mockCreateAccountService;

    @InjectMocks
    IAccountRESTController accountRESTController;

    //Setup
    String designation = "Conta do tonyZe";
    BigDecimal amount = BigDecimal.valueOf(3);
    String currency = "EUR";
    String ownerID = "tonyze@latinlover.com";
    String accountType = "cash";
    String accountID = "3L";
    CreateAccountDTO cashAccountDTO = new CreateAccountDTO(designation, amount, currency, ownerID, accountType);

    InputAccountDTO inputAccountDTO = new InputAccountDTO(designation, amount, currency, ownerID, accountType);

    OutputAccountDTO outputAccountDTO = new OutputAccountDTO(designation, ownerID, accountID);


    @Test
    @DisplayName("Success case in creating an Account")
    void createCashAccountWithSuccess() {
        //Mockito.when(mockAccountInputDTOAssembler.toInputDTO());



    }
}