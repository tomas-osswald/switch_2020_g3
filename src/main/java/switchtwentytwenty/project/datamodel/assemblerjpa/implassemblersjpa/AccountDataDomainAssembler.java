package switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.datamodel.assemblerjpa.iassemblersjpa.IAccountDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.AccountIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.AccountJPA;
import switchtwentytwenty.project.domain.aggregates.account.IAccount;
import switchtwentytwenty.project.domain.valueobject.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDataDomainAssembler implements IAccountDataDomainAssembler {

    @Override
    public AccountJPA toData(IAccount account) {

        AccountIDJPA accountIDJPA = new AccountIDJPA();
        char validation = account.getOwnerId().toString().charAt(0);
        String validationID = Character.toString(validation);
        OwnerID ownerId;

        if( validationID == "@" ){
           ownerId = (FamilyID) account.getOwnerId();
        } else {
            ownerId = (PersonID) account.getOwnerId();
        }

        String designation = account.getDesignation().toString();
        String accountType = account.getAccountType().toString();

        AccountJPA accountJPA = null;
        // TODO: Verificar se é esta a ordem no construtor de AccountJPA
        //accountJPA = new AccountJPA(accountIDJPA, ownerId, designation, accountType);

        return accountJPA;
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

    public PersonID createOwnerID(AccountJPA accountJPA) {
        PersonID personID = new PersonID(accountJPA.getOwnerID().toString());
        return personID;
    }


    public Designation createDesignation(AccountJPA accountJPA) {
        Designation designation = new Designation(accountJPA.getDesignation().toString());
        return designation;
    }

    public AccountType createAccountType(AccountJPA accountJPA) {
        AccountType accountType = new AccountType(accountJPA.getAccountType());
        return accountType;
    }

    public List<Movement> createMovements(AccountJPA accountJPA){
        List<Movement> movements = new ArrayList<>();


        return movements;
    }


}