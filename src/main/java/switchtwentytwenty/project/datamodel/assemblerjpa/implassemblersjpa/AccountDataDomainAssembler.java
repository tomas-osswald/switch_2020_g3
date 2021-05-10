package switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.datamodel.assemblerjpa.iassemblersjpa.IAccountDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.AccountJPA;
import switchtwentytwenty.project.domain.aggregates.account.Account;

@Component
public class AccountDataDomainAssembler implements IAccountDataDomainAssembler {

    @Override
    public AccountJPA toData(Account account){

        // ESTA COMENTADO PARA NÃO PARTIR. DESCOMENTAR QUANDO FOR NECESSÁRIO //

        //AccountIDJPA accountIDJPA = new AccountIDJPA(account.getId());

        String ownerId = account.getOwnerId().toString();
        String designation = account.getDesignation().toString();
        String balance = account.getBalance().toString();
        String accountType = account.getAccountType().toString();

        // TODO: Verificar se é esta a ordem no construtor de AccountJPA
        //AccountJPA accountJPA = new AccountJPA(accountIDJPA, ownerId, balance, designation, accountType);

        return null; //accountJPA;
    }

    @Override
    public Account toDomain(AccountJPA accountJPA) {
        return null;
    }


}
