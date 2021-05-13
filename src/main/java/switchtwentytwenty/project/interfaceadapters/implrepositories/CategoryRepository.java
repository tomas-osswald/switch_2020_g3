package switchtwentytwenty.project.interfaceadapters.implrepositories;


import org.springframework.stereotype.Repository;
import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.usecaseservices.irepositories.ICategoryRepository;

@Repository
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