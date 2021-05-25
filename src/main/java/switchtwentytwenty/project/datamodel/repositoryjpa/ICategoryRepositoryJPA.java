package switchtwentytwenty.project.datamodel.repositoryjpa;

import org.springframework.data.repository.CrudRepository;
import switchtwentytwenty.project.datamodel.domainjpa.CategoryIDJPA;
import switchtwentytwenty.project.datamodel.domainjpa.CategoryJPA;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyIDJPA;

import java.util.List;

public interface ICategoryRepositoryJPA extends CrudRepository<CategoryJPA, CategoryIDJPA> {

    List<CategoryJPA> findAllByFamilyIDJPA(FamilyIDJPA familyIDJPA);
<<<<<<< HEAD


  //  List<CategoryJPA> findAllByFamilyIDJPAIsNull();
=======
>>>>>>> 60e13fcb6ff52a75eed070fff1ed7f7ec2a4949c
}
