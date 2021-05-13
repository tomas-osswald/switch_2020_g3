package switchtwentytwenty.project.domain.aggregates.account;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.valueobject.*;

import java.util.List;

@Component
public class AccountFactory {

    @Autowired
    private Environment environment;

    public IAccount createAccount(Designation designation, Monetary monetary, OwnerID ownerID, String accountType) {
        IAccount newIAccount;
        Movement movement = new Movement(monetary);

        String classpath = environment.getProperty(accountType.toLowerCase());
        try {
            newIAccount = (IAccount) Class.forName(classpath).newInstance();
            newIAccount.setDesignation(designation);
            newIAccount.addMovement(movement);
            newIAccount.setOwner(ownerID);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException exception) {
            throw new IllegalArgumentException();
        }
        return newIAccount;
    }

    public IAccount createAccount(AccountID accountID, List<Movement> movements, OwnerID ownerID, Designation designation, String accountType) {
        IAccount account;

        String classpath = environment.getProperty(accountType.toLowerCase());

        try {
            account = (IAccount) Class.forName(classpath).newInstance();
            account.setAccountID(accountID);
            account.setDesignation(designation);
            account.setMovements(movements);
            account.setOwner(ownerID);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException exception) {
            throw new IllegalArgumentException();
        }
        return account;
    }
}