package switchtwentytwenty.project.usecaseservices.irepositories;

import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.domain.valueobject.CategoryID;

public interface ICategoryRepository extends Repository<Category, CategoryID> {

    Category add(Category category);

}
