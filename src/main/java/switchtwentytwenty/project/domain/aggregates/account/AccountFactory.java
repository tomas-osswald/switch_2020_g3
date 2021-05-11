package switchtwentytwenty.project.domain.aggregates.account;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.valueobject.Designation;
import switchtwentytwenty.project.domain.valueobject.Monetary;
import switchtwentytwenty.project.domain.valueobject.Movement;
import switchtwentytwenty.project.domain.valueobject.OwnerID;

@Component
public class AccountFactory {

    @Autowired
    private Environment environment;

    //Isto nao aceita só uma String, aceita um DTO que tem lá o string do account type. Terá de ser adaptado
    public IAccount createAccount(Designation designation, Monetary monetary, OwnerID ownerID, String accountType) {
        IAccount newIAccount;
        Movement movement = new Movement(monetary);

        //Isto vai ao application.properties buscar o endereço da classe de acordo com o string que recebemos.
        //O toLowerCase() é para bater certo

        String classpath = environment.getProperty(accountType.toLowerCase());
        try {
            //Cria uma instancia do tipo especifico de conta
            newIAccount = (IAccount) Class.forName(classpath).newInstance();

            // BATISTA !!!
            // Como já não ha build e não sabemos qual instancia de Account a "newAccount" se vai tornar,
            // usamos construtores vazios para instanciar qualquer tipo de Account e set's para adicionar os atributos
            // que são comuns a todas elas.
            newIAccount.setDesignation(designation);
            newIAccount.addMovement(movement);
            newIAccount.setOwner(ownerID);

        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException exception){
            //Isto é para apanhar todas as exceptions possiveis do string nao ser reconhecido ou processado corretamente pelo application.properties
            throw new IllegalArgumentException();
        }
        return newIAccount;
    }
}