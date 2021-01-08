package switch2020.project.model;

import switch2020.project.services.CategoryService;
import switch2020.project.services.FamilyService;

import java.util.ArrayList;
import java.util.List;

public class CategoryTree {
    List<Category> standardCategories = new ArrayList();
    List<Category> customCategories = new ArrayList();

    public CategoryTree(CategoryService categoryService, FamilyService familyService, int familyID) {
        this.standardCategories.addAll(categoryService.getStandardCategories());
        this.customCategories.addAll(familyService.getCustomCategories(familyID));
    }

    public void printTree() {
        for (Category standardCategory : standardCategories) {
            System.out.println("== " + standardCategory.getName() + " ==");
            for (Category customCategory : customCategories) {
                if (customCategory.getParentID() == standardCategory.getCategoryID()) {
                    System.out.println("    -- " + customCategory.getName() + " --");
                    printChildren(customCategory);
                }
            }
        }

    }

    public void printChildren(Category category) {
        for (Category childCategory : customCategories) {
            if (category.getCategoryID() == childCategory.getParentID()) {
                System.out.println("        - " + childCategory.getName() + " -");
                printChildren(childCategory);
            }
        }
    }

}
