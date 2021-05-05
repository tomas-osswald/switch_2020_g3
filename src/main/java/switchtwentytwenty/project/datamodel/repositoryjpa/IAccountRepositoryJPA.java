package switchtwentytwenty.project.datamodel.repositoryjpa;

import org.springframework.data.repository.CrudRepository;
import switchtwentytwenty.project.datamodel.domainjpa.AccountIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.AccountJPA;

public interface IAccountRepositoryJPA extends CrudRepository<AccountJPA, AccountIDJPA> {
}
