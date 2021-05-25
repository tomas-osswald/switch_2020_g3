package switchtwentytwenty.project.interfaceadapters.implrepositories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import switchtwentytwenty.project.datamodel.assemblerjpa.iassemblersjpa.AssemblerDataDomain;
import switchtwentytwenty.project.datamodel.assemblerjpa.iassemblersjpa.ICategoryDataDomainAssembler;
import switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa.CategoryDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.CategoryJPA;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyIDJPA;
import switchtwentytwenty.project.datamodel.repositoryjpa.ICategoryRepositoryJPA;
import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.usecaseservices.irepositories.ICategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository implements ICategoryRepository {

    private CategoryDataDomainAssembler categoryDataDomainAssembler = new CategoryDataDomainAssembler();

    @Autowired
    ICategoryRepositoryJPA iCategoryRepositoryJPA;

    @Override
    public Category getByID(CategoryID id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Category add(Category entity) {

        throw new UnsupportedOperationException();
    }

    @Override
    public List<Category> getByFamilyID (FamilyID familyID) {
        FamilyIDJPA familyIDJPA = categoryDataDomainAssembler.toData(familyID);
        List<CategoryJPA> customCategoryJPA = iCategoryRepositoryJPA.findAllByFamilyIDJPA(familyIDJPA);
        List<Category> aFamilyCategoriesList = new ArrayList<>();

    }

}