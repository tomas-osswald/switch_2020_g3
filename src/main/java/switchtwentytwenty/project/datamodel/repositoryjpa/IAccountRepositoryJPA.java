package switchtwentytwenty.project.datamodel.repositoryjpa;

import org.springframework.data.repository.CrudRepository;
import switchtwentytwenty.project.datamodel.domainjpa.AccountIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.AccountJPA;
import switchtwentytwenty.project.datamodel.domainjpa.PersonIDJPA;

import java.util.List;
import java.util.Optional;

public interface IAccountRepositoryJPA extends CrudRepository<AccountJPA, AccountIDJPA> {

    List<AccountJPA> findAll();

    Optional<AccountJPA> findById(PersonIDJPA personIDJPA);

}
