package switchtwentytwenty.project.interfaceadapters.implrepositories;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.datamodel.assemblerjpa.iassemblersjpa.IAccountDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.AccountJPA;
import switchtwentytwenty.project.datamodel.repositoryjpa.IAccountRepositoryJPA;
import switchtwentytwenty.project.domain.aggregates.account.IAccount;

@RunWith(SpringRunner.class)
@SpringBootTest
class AccountRepositoryTest {

    @Mock
    IAccountRepositoryJPA accountRepositoryJPA;

    @Mock
    IAccountDataDomainAssembler accountDataDomainAssembler;

    @Mock
    IAccount account;

    @InjectMocks
    AccountRepository accountRepository;


    @Test
    void addAccountSucess(){
        AccountJPA accountJPA = accountDataDomainAssembler.toData(account);
        accountRepositoryJPA.save(accountJPA);
    }

}