package switchtwentytwenty.project.dto.assemblers.implassemblers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.aggregates.account.Account;

@Component
public class AccountDTODomainAssembler {

    @Autowired
    private Environment environment;


    //Isto nao aceita só uma String, aceita um DTO que tem lá o string do account type. Terá de ser adaptado
    public Account createAccount(String accountType) {
        Account newAccount;
        //Isto vai ao application.properties buscar o endereço da classe de acordo com o string que recebemos.
        //O toLowerCase() é para bater certo
        String classpath = environment.getProperty(accountType.toLowerCase());
        try {
            //Cria uma instancia do tipo especifico de conta
            newAccount = (Account) Class.forName(classpath).newInstance();
            //E aqui usamos o metodo interno que ainda nao existe da conta, para a construir.
            //newAccount.build();

        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException exception){
            //Isto é para apanhar todas as exceptions possiveis do string nao ser reconhecido ou processado corretamente pelo application.properties
            throw new IllegalArgumentException();
        }
        return newAccount;
    }
}
