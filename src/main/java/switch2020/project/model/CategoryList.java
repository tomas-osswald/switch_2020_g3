package switch2020.project.model;

import java.util.List;

public class CategoryList {
    private List<Category> categories;


    public CategoryList(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }
}
