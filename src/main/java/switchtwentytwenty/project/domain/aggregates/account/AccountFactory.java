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

    public IAccount createAccount(Designation designation, Monetary monetary, IOwnerID ownerID, String accountType) {
        IAccount newIAccount;
        Movement movement = new Movement(monetary);

        String classpath = environment.getProperty(accountType.toLowerCase());

        if (classpath == null)
            throw new IllegalArgumentException("Unsupported Account type");

        try {
            newIAccount = (IAccount) Class.forName(classpath).newInstance();


            //TODO: Já li os comentários! Alterei os construtores para manuais e protected para garantir que só o próprio package pode instanciar Accounts. Neste caso a Factory.

            // BATISTA !!!
            // Como já não ha build e não sabemos qual instancia de Account a "newAccount" se vai tornar,
            // usamos construtores vazios para instanciar qualquer tipo de Account e set's para adicionar os atributos
            // que são comuns a todas elas.

            newIAccount.setDesignation(designation);
            newIAccount.addMovement(movement);
            newIAccount.setOwner(ownerID);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException exception) {
            throw new IllegalArgumentException();
        }
        return newIAccount;
    }

    public IAccount createAccount(AccountID accountID, List<Movement> movements, IOwnerID ownerID, Designation designation, String accountType) {
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