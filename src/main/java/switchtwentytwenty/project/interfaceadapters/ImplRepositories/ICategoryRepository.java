package switchtwentytwenty.project.interfaceadapters.ImplRepositories;


import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.usecaseservices.irepositories.Repository;

public class ICategoryRepository implements Repository<Category, CategoryID> {


    @Override
    public Category getByID(CategoryID id) {
        return null;
    }

    @Override
    public Category add(Category entity) {
        return null;
    }
}
