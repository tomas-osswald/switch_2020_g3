package switchtwentytwenty.project.interfaceadapters.implrepositories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa.CategoryDataDomainAssembler;
import switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa.FamilyDataDomainAssembler;
import switchtwentytwenty.project.datamodel.domainjpa.CategoryJPA;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyIDJPA;
import switchtwentytwenty.project.datamodel.repositoryjpa.ICategoryRepositoryJPA;
import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.domain.aggregates.category.CustomCategory;
import switchtwentytwenty.project.domain.aggregates.category.StandardCategory;
import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.domain.valueobject.CategoryName;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.domain.valueobject.ParentCategoryPath;
import switchtwentytwenty.project.usecaseservices.irepositories.ICategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository implements ICategoryRepository {

    private final ICategoryRepositoryJPA categoryRepositoryJPA;
    private final CategoryDataDomainAssembler categoryAssembler;

    @Autowired
    public CategoryRepository(ICategoryRepositoryJPA categoryRepositoryJPA, CategoryDataDomainAssembler categoryAssembler) {
        this.categoryRepositoryJPA = categoryRepositoryJPA;
        this.categoryAssembler = categoryAssembler;
    }


    @Override
    public Category getByID(CategoryID id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Category add(Category entity) {

        throw new UnsupportedOperationException();
    }


    @Override
    public List<Category> getCustomCategoryList (FamilyID familyID) {
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
            Category category;
            CategoryName categoryName = categoryAssembler.createCategoryName(jpa);
            CategoryID categoryID = categoryAssembler.createCategoryID(jpa);
            ParentCategoryPath parentID = categoryAssembler.createParentID(jpa);
            if (jpa.isStandard()) {
                category = new StandardCategory(categoryName, categoryID, parentID);
            } else {
                FamilyID familyID = categoryAssembler.createFamilyID(jpa);
                category = new CustomCategory(categoryID, parentID, categoryName, familyID);
            }
            categoryList.add(category);
        }
        return categoryList;
    }

}