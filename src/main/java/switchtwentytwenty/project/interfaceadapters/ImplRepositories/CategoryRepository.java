package switchtwentytwenty.project.interfaceadapters.ImplRepositories;


import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.usecaseservices.irepositories.ICategoryRepository;

public class CategoryRepository implements ICategoryRepository {


    @Override
    public Category getByID(CategoryID id) {
        return null;
    }

    @Override
    public Category add(Category entity) {
        return null;
    }
}
