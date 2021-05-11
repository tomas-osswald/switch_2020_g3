package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import switchtwentytwenty.project.datamodel.repositoryjpa.IAccountRepositoryJPA;
import switchtwentytwenty.project.dto.assemblers.implassemblers.AccountDTODomainAssembler;
import switchtwentytwenty.project.usecaseservices.irepositories.IAccountRepository;

@SpringBootTest
public class CreateAccountServiceIT {

    CreateAccountService createAccountService;

    @Mock
    IAccountRepository iAccountRepository;

    @Mock
    IAccountRepositoryJPA iAccountRepositoryJPA;

    @Mock
    AccountDTODomainAssembler accountDTODomainAssembler;

    @Test
    void createAccountSuccessCase() {


    }

}