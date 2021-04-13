package switchtwentytwenty.project.interfaceadapters.ImplRepositories;


import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.usecaseservices.irepositories.Repository;
import switchtwentytwenty.project.domain.aggregates.category.Category;

public class CategoryRepository implements Repository<Category, CategoryID>, switchtwentytwenty.project.usecaseservices.irepositories.CategoryRepository {


    @Override
    public Category getByID(CategoryID id) {
        return null;
    }
}
