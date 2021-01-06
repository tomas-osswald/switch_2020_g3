package switch2020.project.model;
import java.util.ArrayList;

public class Application {

    private CategoryService categoryService;
    private ArrayList<Category> standardCategories = new ArrayList();

    public Application() {
        this.categoryService = new CategoryService();
    }

}
