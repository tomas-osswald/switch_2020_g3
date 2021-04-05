package switchtwentytwenty.project.dataaccesslayer;


import switchtwentytwenty.project.shared.CategoryID;
import switchtwentytwenty.project.util.Repository;
import switchtwentytwenty.project.domain.category.Category;

public class CategoryRepository implements Repository<Category, CategoryID> {


    @Override
    public Category getByID(CategoryID id) {
        return null;
    }
}
