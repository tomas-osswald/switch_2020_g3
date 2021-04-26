package switchtwentytwenty.project.datamodel.repositoryjpa;

import org.springframework.data.repository.CrudRepository;
import switchtwentytwenty.project.datamodel.assemblerjpa.FamilyIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyJPA;
import switchtwentytwenty.project.domain.valueobject.PersonID;

import java.util.List;
import java.util.Optional;

public interface IFamilyRepositoryJPA extends CrudRepository<FamilyJPA, FamilyIDJPA> {

    List<FamilyJPA> findAll();

    Optional<FamilyJPA> findById(FamilyIDJPA id);

}
