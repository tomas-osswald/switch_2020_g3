package switchtwentytwenty.project.datamodel.repositoryjpa;

import org.springframework.data.repository.CrudRepository;
import switchtwentytwenty.project.datamodel.domainjpa.CategoryIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.CategoryJPA;

public interface ICategoryRepositoryJPA extends CrudRepository<CategoryJPA, CategoryIDJPA> {
}
