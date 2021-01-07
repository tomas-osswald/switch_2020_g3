package switch2020.project.model;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private List<Category> categories;

    public CategoryService() {
        this.categories = new ArrayList<>();
    }

    public List<Category> getCategories() {
        return this.categories;
    }

    public List<Category> getStandardCategories() {
        List standardCategories = new ArrayList<Category>();

        for (Category cat : categories) {
            if (cat.isStandard()) {
                standardCategories.add(cat);
            }
        }
        return standardCategories;
    }
}



