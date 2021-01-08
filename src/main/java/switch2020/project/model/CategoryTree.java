package switch2020.project.model;

import switch2020.project.services.CategoryService;
import switch2020.project.services.FamilyService;

import java.util.ArrayList;
import java.util.List;

public class CategoryTree {
    List<Category> categoryTree = new ArrayList();
    List<Category> standardCategories = new ArrayList();
    List<Category> customCategories = new ArrayList();

    public CategoryTree(CategoryService categoryService, FamilyService familyService, int familyID) {
        this.standardCategories.addAll(categoryService.getStandardCategories());
        this.customCategories.addAll(familyService.getCustomCategories(familyID));
    }

    public void buildTree() {
        //logica para construir a arvore com as standard e as custom

    }
}
