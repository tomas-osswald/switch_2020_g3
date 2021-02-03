package switchtwentytwenty.project.domain.dtos.output;

import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.model.categories.CustomCategory;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.services.CategoryService;
import switchtwentytwenty.project.domain.services.FamilyService;

import java.util.ArrayList;
import java.util.Collections;
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
        this.customCategories.addAll(familyService.getCustomCategories(familyID));
    }

    public List<CustomCategory> getCustomCategories() {
        return Collections.unmodifiableList(this.customCategories);
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
            if (standardcategory instanceof StandardCategory) {
                categoriesNames[index] = standardcategory.getCategoryName();
                index++;
            }

        }
        return categoriesNames;
    }


}
