package switch2020.project.model;

import switch2020.project.services.CategoryService;

import java.util.ArrayList;
import java.util.List;

public class CategoryTree {
    List<Category> categoryTree = new ArrayList();

    public CategoryTree(CategoryService service){
        this.categoryTree.addAll(service.getStandardCategories());
    }
}
