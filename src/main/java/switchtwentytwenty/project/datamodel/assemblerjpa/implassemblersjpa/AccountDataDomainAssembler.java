package switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa;

import org.springframework.stereotype.Component;
import switchtwentytwenty.project.datamodel.assemblerjpa.iassemblersjpa.IAccountDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.AccountJPA;
import switchtwentytwenty.project.datamodel.domainjpa.MovementJPA;
import switchtwentytwenty.project.datamodel.domainjpa.OwnerIDJPA;
import switchtwentytwenty.project.domain.aggregates.account.IAccount;
import switchtwentytwenty.project.domain.valueobject.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDataDomainAssembler implements IAccountDataDomainAssembler {

    @Override
    public AccountJPA toData(IAccount account) {


        OwnerIDJPA ownerId = new OwnerIDJPA(account.getOwnerId().toString());

        String designation = account.getDesignation().toString();
        String accountType = account.getAccountType();
        List<Movement> movements = account.getListOfMovements();

        AccountJPA accountJPA;

        if (account.id() == null) {
            accountJPA = new AccountJPA(ownerId, designation, accountType);
        } else {
            accountJPA = new AccountJPA(account.id().getAccountID(), ownerId, designation, accountType);
        }
        List<MovementJPA> movementJPAList = new ArrayList<>();

        for (Movement movement : movements) {
            String currency = movement.getMonetary().getCurrency().toString();
            Long amount = movement.getMonetary().getAmount().longValue();
            MovementJPA movementJPA = new MovementJPA(amount, currency, accountJPA);
            movementJPAList.add(movementJPA);
        }
        accountJPA.setMovements(movementJPAList);
        return accountJPA;
    }

    public AccountID createAccountID(AccountJPA accountJPA) {
        AccountID accountID = new AccountID(accountJPA.getId());
        return accountID;
    }

    public IOwnerID createOwnerID(AccountJPA accountJPA){
        char validation = accountJPA.getOwnerID().toString().charAt(0);
        String validationID = Character.toString(validation);
        IOwnerID ownerID;
        if(validationID.equals("@")){
            ownerID = new FamilyID(accountJPA.getOwnerID().toString());
        } else {
            ownerID = new PersonID(accountJPA.getOwnerID().toString());
        }
        return ownerID;
    }

    public Designation createDesignation(AccountJPA accountJPA) {
        Designation designation = new Designation(accountJPA.getDesignation().toString());
        return designation;
    }

    public AccountType createAccountType(AccountJPA accountJPA) {
        AccountType accountType = new AccountType(accountJPA.getAccountType());
        return accountType;
    }

    public List<Movement> createMovements(AccountJPA accountJPA) {
        List<Movement> movements = new ArrayList<>();
        List<MovementJPA> movementJPAList = accountJPA.getMovements();

        for (MovementJPA movementJPA : movementJPAList) {
            String currency = movementJPA.getCurrency();
            BigDecimal amount = new BigDecimal(movementJPA.getAmount());
            Monetary monetary = new Monetary(currency, amount);
            Movement movement = new Movement(monetary);
            movements.add(movement);
        }

        return movements;
    }


}