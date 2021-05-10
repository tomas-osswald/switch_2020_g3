package switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.datamodel.domainjpa.AccountIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.AccountJPA;
import switchtwentytwenty.project.domain.aggregates.account.Account;

@Component
public class AccountDataDomainAssembler {

    public Account toData(Account account){
        AccountIDJPA accountIDJPA = new AccountIDJPA(account.getId());




        return null;
    }
}
