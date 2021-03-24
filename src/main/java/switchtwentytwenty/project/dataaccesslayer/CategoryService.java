package switchtwentytwenty.project.dataaccesslayer;

public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService() {
        this.categoryRepository = new CategoryRepository();
    }
}
