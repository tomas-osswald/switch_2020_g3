package switchtwentytwenty.project.interfaceadapters.ImplRepositories;


import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.usecaseservices.irepositories.Repository;

public class ICategoryRepository implements Repository<Category, CategoryID>, switchtwentytwenty.project.usecaseservices.irepositories.ICategoryRepository {


    @Override
    public Category getByID(CategoryID id) {
        return null;
    }

    @Override
    public void add(Category entity) {

    }
}
