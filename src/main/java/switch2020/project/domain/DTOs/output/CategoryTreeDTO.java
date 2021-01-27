package switch2020.project.domain.DTOs.output;

import switch2020.project.domain.model.categories.Category;
import switch2020.project.domain.model.categories.CustomCategory;
import switch2020.project.domain.model.categories.StandardCategory;
import switch2020.project.domain.services.CategoryService;
import switch2020.project.domain.services.FamilyService;

import java.util.ArrayList;
import java.util.List;

public class CategoryTreeDTO {
    List<Category> categories = new ArrayList();
    List<CustomCategory> customCategories = new ArrayList();

    public CategoryTreeDTO(CategoryService categoryService) {
        this.categories.addAll(categoryService.getStandardCategories());
    }

    /**
     * Constructor of the CategoryTreeDTO Object
     *
     * @param categoryService categoryService object where the StandardCategories will be retrieved.
     * @param familyService   familyService object where the CustomCategories will be retrieved.
     * @param familyID        FamilyID of the target family.
     */
    public CategoryTreeDTO(CategoryService categoryService, FamilyService familyService, int familyID) {
        this.categories.addAll(categoryService.getStandardCategories());
        this.categories.addAll(familyService.getCustomCategories(familyID));
    }


    /*
    /**
     * Method to present the StandardCategory List
     *
     * @return StandardCategory List

    public List<StandardCategory> getStandardCategories() {
        return standardCategories;
    }

    /**
     * Method to present the CustomCategory List
     *
     * @return CustomCategory List

    public List<CustomCategory> getCustomCategories() {
        return customCategories;
    }
*/

    /**
     * Temporary method to print the Tree on the console
     */
    public void printTree() {
        ArrayList<Integer> ids = new ArrayList<>();
        for (Category standardCategory : categories) {
            if (!ids.contains(standardCategory.getCategoryID())) {
                System.out.println("== " + standardCategory.getCategoryName() + " ==");

                ids.add(standardCategory.getCategoryID());
            }
            for (Category standardCategory1 : categories) {
                if (standardCategory1.getParentID() == standardCategory.getCategoryID() && !ids.contains(standardCategory1.getCategoryID())) {
                    System.out.println("    -- " + standardCategory1.getCategoryName() + " --");
                    ids.add(standardCategory1.getCategoryID());
                    for (Category standardCategory2 : categories) {
                        if (standardCategory2.getParentID() == standardCategory1.getCategoryID() && !ids.contains(standardCategory2.getCategoryID())) {
                            System.out.println("        - " + standardCategory2.getCategoryName() + " -");
                            ids.add(standardCategory2.getCategoryID());
                        }
                    }
                }
/*
                for (CustomCategory customCategory : customCategories) {
                    if (customCategory.getParentID() == standardCategory.getCategoryID()) {
                        System.out.println("    -- " + customCategory.getCategoryName() + " --");
                        printChildren(customCategory);
                    }
                }
            }

        }*/
            }
        }
    }

    /**
     * Method to return an Array of all the StandardCategories' Names
     *
     * @return String Array of StandardCategory objects names.
     */
    public String[] getArrayOfStandardCategoriesNames() {
        String[] categoriesNames = new String[categories.size()];
        int index = 0;
        for (Category standardcategory : categories) {
            if(standardcategory instanceof StandardCategory){
                categoriesNames[index] = standardcategory.getCategoryName();
                index++;
            }

        }
        return categoriesNames;
    }
/*
    /**
     * Recursive method to print a Category's children
     * @param category

    public void printChildren(CustomCategory category) {
        for (CustomCategory childCategory : customCategories) {
            if (category.getCategoryID() == childCategory.getParentID()) {
                System.out.println("        - " + childCategory.getCategoryName() + " -");
                printChildren(childCategory);
            }
        }
    }
        */

}
