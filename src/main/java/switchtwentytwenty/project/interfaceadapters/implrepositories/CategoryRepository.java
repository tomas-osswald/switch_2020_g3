package switchtwentytwenty.project.interfaceadapters.implrepositories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa.CategoryDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.CategoryJPA;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyIDJPA;
import switchtwentytwenty.project.datamodel.repositoryjpa.ICategoryRepositoryJPA;
import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.domain.aggregates.category.CategoryFactory;
import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.usecaseservices.irepositories.ICategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository implements ICategoryRepository {

    private final ICategoryRepositoryJPA categoryRepositoryJPA;
    private final CategoryDataDomainAssembler categoryAssembler = new CategoryDataDomainAssembler();
    private final CategoryFactory categoryFactory = new CategoryFactory();
    @Autowired
    public CategoryRepository(ICategoryRepositoryJPA categoryRepositoryJPA) {
        this.categoryRepositoryJPA = categoryRepositoryJPA;
    }


    @Override
    public Category getByID(CategoryID id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Category add(Category category) {
        CategoryJPA categoryJPA = categoryAssembler.toData(category);
        CategoryJPA registeredCategoryJPA = categoryRepositoryJPA.save(categoryJPA);

        Category savedCategory = categoryFactory.createCategory(registeredCategoryJPA);

        return savedCategory;
    }



    @Override
    public List<Category> getCustomCategoryList(FamilyID familyID) {
        FamilyIDJPA familyIDJPA = categoryAssembler.toData(familyID);
        List<CategoryJPA> customCategoryJPAList = categoryRepositoryJPA.findAllByFamilyIDJPA(familyIDJPA);
        List<Category> aFamilyCategoriesList = convertCategoryJPAListToCategoryList(customCategoryJPAList);
        return aFamilyCategoriesList;
    }


    public List<Category> getStandardCategoryList() {
        List<CategoryJPA> categoryListJPA;
        categoryListJPA = categoryRepositoryJPA.findAllByFamilyIDJPAIsNull();
        return convertCategoryJPAListToCategoryList(categoryListJPA);
    }

    private List<Category> convertCategoryJPAListToCategoryList(List<CategoryJPA> categoryJPAList) {
        List<Category> categoryList = new ArrayList<>();
        for (CategoryJPA jpa : categoryJPAList) {
            categoryList.add(categoryFactory.createCategory(jpa));
        }
        return categoryList;
    }

}