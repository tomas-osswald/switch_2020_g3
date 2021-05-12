package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.datamodel.repositoryjpa.IAccountRepositoryJPA;
import switchtwentytwenty.project.dto.assemblers.implassemblers.AccountDTODomainAssembler;
import switchtwentytwenty.project.usecaseservices.irepositories.IAccountRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CreateAccountServiceIT {

    CreateAccountService createAccountService;

    @Mock
    IAccountRepository iAccountRepository;

    @Mock
    IAccountRepositoryJPA iAccountRepositoryJPA;

    @Mock
    AccountDTODomainAssembler accountDTODomainAssembler;

    @Test
    public void createAccountSuccessCase() {


    }

}