package switchtwentytwenty.project.THREEinterfaceadapters.repositories;


import switchtwentytwenty.project.ONEdomain.valueobject.CategoryID;
import switchtwentytwenty.project.TWOusecaseservices.irepositories.Repository;
import switchtwentytwenty.project.ONEdomain.aggregates.category.Category;

public class CategoryRepository implements Repository<Category, CategoryID> {


    @Override
    public Category getByID(CategoryID id) {
        return null;
    }
}
