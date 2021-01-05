package switch2020.project.model;
import java.util.ArrayList;
import java.util.List;


public class CategoryService {
    private List<Category> categories;

    public CategoryService() {
        this.categories = new ArrayList<>();
    }


    public List<Category> getCategories() {
        return categories;
    }
}


