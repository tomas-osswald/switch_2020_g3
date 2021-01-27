package switch2020.project.domain.DTOs.output;

import switch2020.project.domain.model.categories.CustomCategory;
import switch2020.project.domain.model.categories.StandardCategory;
import switch2020.project.domain.services.CategoryService;
import switch2020.project.domain.services.FamilyService;

import java.util.ArrayList;
import java.util.List;

public class CategoryTreeDTO {
    List<StandardCategory> standardCategories = new ArrayList();
    List<CustomCategory> customCategories = new ArrayList();

    public CategoryTreeDTO(CategoryService categoryService) {
        this.standardCategories.addAll(categoryService.getStandardCategories());
    }

    /**
     * Constructor of the CategoryTreeDTO Object
     *
     * @param categoryService categoryService object where the StandardCategories will be retrieved.
     * @param familyService   familyService object where the CustomCategories will be retrieved.
     * @param familyID        FamilyID of the target family.
     */
    public CategoryTreeDTO(CategoryService categoryService, FamilyService familyService, int familyID) {
        this.standardCategories.addAll(categoryService.getStandardCategories());
        this.customCategories.addAll(familyService.getCustomCategories(familyID));
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
        for (StandardCategory standardCategory : standardCategories) {
            if (!ids.contains(standardCategory.getCategoryID())) {
                System.out.println("== " + standardCategory.getCategoryName() + " ==");

                ids.add(standardCategory.getCategoryID());
            }
            for (StandardCategory standardCategory1 : standardCategories) {
                if (standardCategory1.getParentID() == standardCategory.getCategoryID() && !ids.contains(standardCategory1.getCategoryID())) {
                    System.out.println("    -- " + standardCategory1.getCategoryName() + " --");
                    ids.add(standardCategory1.getCategoryID());
                    for (StandardCategory standardCategory2 : standardCategories) {
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
        String[] categoriesNames = new String[standardCategories.size()];
        int index = 0;
        for (StandardCategory standardcategory : standardCategories) {
            categoriesNames[index] = standardcategory.getCategoryName();
            index++;
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
