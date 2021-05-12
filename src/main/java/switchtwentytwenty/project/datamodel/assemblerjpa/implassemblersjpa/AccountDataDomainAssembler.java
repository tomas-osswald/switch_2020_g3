package switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.datamodel.assemblerjpa.iassemblersjpa.IAccountDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.AccountJPA;
import switchtwentytwenty.project.domain.aggregates.account.IAccount;
import switchtwentytwenty.project.domain.valueobject.AccountID;
import switchtwentytwenty.project.domain.valueobject.AccountType;
import switchtwentytwenty.project.domain.valueobject.Designation;
import switchtwentytwenty.project.domain.valueobject.PersonID;

@Component
public class AccountDataDomainAssembler implements IAccountDataDomainAssembler {

    @Override
    public AccountJPA toData(IAccount IAccount) {

        // ESTA COMENTADO PARA NÃO PARTIR. DESCOMENTAR QUANDO FOR NECESSÁRIO //

        //AccountIDJPA accountIDJPA = new AccountIDJPA(account.getId());

        String ownerId = IAccount.getOwnerId().toString();
        String designation = IAccount.getDesignation().toString();
        String accountType = IAccount.getAccountType().toString();

        // TODO: Verificar se é esta a ordem no construtor de AccountJPA
        //AccountJPA accountJPA = new AccountJPA(accountIDJPA, ownerId, balance, designation, accountType);

        return null; //accountJPA;
    }

    
    @Deprecated
    public IAccount toDomain(AccountJPA accountJPA) {

        // ESTA COMENTADO PARA NÃO PARTIR. DESCOMENTAR QUANDO FOR NECESSÁRIO //
        //coisas comentadas é porque ainda não estão implementadas em domínio


        AccountID accountID = new AccountID(accountJPA.getId().toLong());
        PersonID ownerID = new PersonID(accountJPA.getOwnerID().toString());
        //Designation designation = new Designation(accountJPA.getDesignation());
        //AccountType accountType = new AccountType(accountJPA.getAccountType());

        //Account account = new Account(accountID, ownerID, balance, designation, accountType);

        //return account;
        return null;
    }

    public AccountID createAccountID(AccountJPA accountJPA) {
        AccountID accountID = new AccountID(accountJPA.getId().toLong());
        return accountID;
    }

    public PersonID createPersonID(AccountJPA accountJPA) {
        PersonID personID = new PersonID(accountJPA.getOwnerID().toString());
        return personID;
    }

    public Designation createDesignation(AccountJPA accountJPA) {
        Designation designation = new Designation(accountJPA.getDesignation().toString());
        return designation;
    }

    public AccountType createAccountType(AccountJPA accountJPA) {
        AccountType accountType = new AccountType();
        return accountType;
    }


}