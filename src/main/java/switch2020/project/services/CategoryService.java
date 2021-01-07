package switch2020.project.services;
import switch2020.project.model.Category;

import java.util.ArrayList;
import java.util.List;


public class CategoryService {

    // Attributes
    private List<Category> categories;

    // Constructors
    public CategoryService() {
        this.categories = new ArrayList<>();
    }

    // Business Methods
    public List<Category> getCategories() {
        return categories;
    }
}


