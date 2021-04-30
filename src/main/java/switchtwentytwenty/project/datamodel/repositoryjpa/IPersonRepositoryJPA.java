package switchtwentytwenty.project.datamodel.repositoryjpa;

import org.springframework.data.repository.CrudRepository;
import switchtwentytwenty.project.datamodel.domainjpa.PersonJPA;
import switchtwentytwenty.project.datamodel.domainjpa.PersonIDJPA;

import java.util.List;
import java.util.Optional;

public interface IPersonRepositoryJPA extends CrudRepository<PersonJPA, PersonIDJPA> {

    List<PersonJPA> findAll();

    Optional<PersonJPA> findById(PersonIDJPA id);

    // boolean existsPersonJPAById_PersonID(PersonIDJPA personIDJPA);

}
