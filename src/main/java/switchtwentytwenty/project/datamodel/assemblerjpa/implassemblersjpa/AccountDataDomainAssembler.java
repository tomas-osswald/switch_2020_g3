package switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.datamodel.domainjpa.AccountIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.AccountJPA;
import switchtwentytwenty.project.domain.aggregates.account.Account;

@Component
public class AccountDataDomainAssembler {

    public AccountJPA toData(Account account){

        AccountIDJPA accountIDJPA = new AccountIDJPA(account.getId());

        String ownerId = account.getOwnerId().toString();
        String designation = account.getDesignation().toString();
        String balance = account.getBalance().toString();
        String accountType = account.getAccountType().toString();

        // TODO: Verificar se é esta a ordem no construtor de AccountJPA
        AccountJPA accountJPA = new AccountJPA(accountIDJPA, ownerId, balance, designation, accountType);

        return accountJPA;
    }
}
