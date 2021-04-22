package switchtwentytwenty.project.datamodel.repositoryjpa;

import org.springframework.data.repository.CrudRepository;
import switchtwentytwenty.project.datamodel.PersonJPA;
import switchtwentytwenty.project.datamodel.assemblerjpa.PersonIDJPA;

import java.util.List;
import java.util.Optional;

public interface IPersonRepositoryJPA extends CrudRepository<PersonJPA, PersonIDJPA> {

    List<PersonJPA> findAll();

    Optional<PersonJPA> findById(PersonIDJPA id);

}
