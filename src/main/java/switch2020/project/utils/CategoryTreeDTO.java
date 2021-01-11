package switch2020.project.utils;

import switch2020.project.model.CustomCategory;
import switch2020.project.model.StandardCategory;
import switch2020.project.services.CategoryService;
import switch2020.project.services.FamilyService;

import java.util.ArrayList;
import java.util.List;

public class CategoryTreeDTO {
    List<StandardCategory> standardCategories = new ArrayList();
    List<CustomCategory> customCategories = new ArrayList();

    public CategoryTreeDTO(CategoryService categoryService, FamilyService familyService, int familyID) {
        this.standardCategories.addAll(categoryService.getStandardCategories());
        this.customCategories.addAll(familyService.getCustomCategories(familyID));
    }

    public List<StandardCategory> getStandardCategories() {
        return standardCategories;
    }

    public List<CustomCategory> getCustomCategories() {
        return customCategories;
    }

    public void printTree() {
        ArrayList<Integer> ids = new ArrayList<>();
        for (StandardCategory standardCategory : standardCategories) {
            if (!ids.contains(standardCategory.getCategoryID())) {
                System.out.println("== " + standardCategory.getName() + " ==");
                ids.add(standardCategory.getCategoryID());
            }
            for (StandardCategory standardCategory1 : standardCategories) {
                if (standardCategory1.getParentID() == standardCategory.getCategoryID() && !ids.contains(standardCategory1.getCategoryID())) {
                    System.out.println("    -- " + standardCategory1.getName() + " --");
                    ids.add(standardCategory1.getCategoryID());
                }
            }
            for (CustomCategory customCategory : customCategories) {
                if (customCategory.getParentID() == standardCategory.getCategoryID()) {
                    System.out.println("    -- " + customCategory.getCategoryName() + " --");
                    printChildren(customCategory);
                }
            }
        }

    }

    public String[] getArrayOfStandardCategoriesNames() {
        String[] categoriesNames = new String[standardCategories.size()];
        int index = 0;
        for (StandardCategory standardcategory : standardCategories) {
            categoriesNames[index] = standardcategory.getName();
            index++;
        }
        return categoriesNames;
    }

    public void printChildren(CustomCategory category) {
        for (CustomCategory childCategory : customCategories) {
            if (category.getCategoryID() == childCategory.getParentID()) {
                System.out.println("        - " + childCategory.getCategoryName() + " -");
                printChildren(childCategory);
            }
        }
    }


}
