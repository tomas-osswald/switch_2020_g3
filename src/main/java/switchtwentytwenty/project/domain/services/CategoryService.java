package switchtwentytwenty.project.domain.services;

import switchtwentytwenty.project.domain.dtos.output.CategoryTreeDTO;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.model.categories.CustomCategory;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {

    private final List<StandardCategory> categories;
    private FamilyService familyService;


    public CategoryService(FamilyService familyService) {
        this.familyService = familyService;
        this.categories = new ArrayList<>();
        StandardCategory other = new StandardCategory("OTHER", null, 0);
        categories.add(other);
    }

    public CategoryService() {
        this.categories = new ArrayList<>();
        StandardCategory other = new StandardCategory("OTHER", null, 0);
        categories.add(other);
    }

    /**
     * Method to add a Standard Category to the list of Categories in the application
     *
     * @param categoryName categoryName String - name of the category to be added to the list
     * @param parentID     categoryID of the Parent Category
     * @return true if the category was created and added successful, false otherwise
     */

    public boolean addStandardCategory(String categoryName, int parentID) {
        if (isCategoryWithSameNameAlreadyPresent(categoryName)) return false;
        if (!isParentIDInList(parentID)) return false;
        try {
            int categoryID = generateCategoryID();
            StandardCategory parentCategory = getStandardCategoryByID(parentID);
            StandardCategory newStandardCategory = new StandardCategory(categoryName, parentCategory, categoryID);
            categories.add(newStandardCategory);
            return true;
        } catch (IllegalArgumentException nameException) {
            return false;
        }
    }

    /**
     * This method returns a StandardCategory of a given ID
     *
     * @param categoryID ID of the StandardCategory to be returned
     * @return chosen StandardCategory, if the StandardCategory is not found returns null;
     */
    public StandardCategory getStandardCategoryByID(int categoryID) {
        StandardCategory selectedCategory = null;
        int size = this.categories.size();
        for (int index = 0; index < size; index++) {
            if (this.categories.get(index).getCategoryID() == categoryID) {
                selectedCategory = this.categories.get(index);
                index = size;
            }
        }
        return selectedCategory;
    }

    /**
     * Method to determine if a new category is present in the list of categories
     *
     * @param categoryName String with the name of the category
     * @return true if a category with the same name already exists in the list, false otherwise
     */

    private boolean isCategoryWithSameNameAlreadyPresent(String categoryName) {
        int size = this.categories.size();
        boolean categoryPresent = false;
        for (int index = 0; index < size && !categoryPresent; index++) {
            if (this.categories.get(index).isDesignationOfThisCategory(categoryName)) {
                categoryPresent = true;
            }
        }
        return categoryPresent;
    }

    /**
     * Method to determine if a standard category with a given name already exists
     *
     * @param parentID int representing the categoryID of the parent category
     * @return true if the ID exists in the list of Standard Categories, false otherwise
     */
    private boolean isParentIDInList(int parentID) {
        if (parentID == 0) return true;
        boolean idPresent = false;
        int size = this.categories.size();
        for (int index = 0; index < size && !idPresent; index++) {
            if (this.categories.get(index).isIDOfThisCategory(parentID)) {
                idPresent = true;
            }
        }
        return idPresent;
    }

    /**
     * Method that generates an ID for a Standard Category
     *
     * @return generated ID
     */

    private int generateCategoryID() {
        int maxID = 0;
        for (StandardCategory category : this.categories) {
            if (maxID < category.getCategoryID()) maxID = category.getCategoryID();
        }
        return maxID + 1;
    }

    /**
     * Method to retrieve the list of StandardCategories
     *
     * @return List of StandardCategory objects
     */
    public List<StandardCategory> getCategories() {
        List<StandardCategory> categoriesClone = new ArrayList<>();
        categoriesClone.addAll(this.categories);
        return categoriesClone;
    }

    public CategoryTreeDTO getStandardCategoryTree() {
        return new CategoryTreeDTO(this);
    }

    /**
     * Method to create and return a Family's CategoryTree
     *
     * @param familyID      ID of the target family
     * @param familyService The Application's familyService
     * @return CategoryTreeDTO Object
     */
    public CategoryTreeDTO getCategoryTree(int familyID, FamilyService familyService) {
        return new CategoryTreeDTO(this, familyService, familyID);
    }

    /**
     * Method to get all the Standard Categories
     *
     * @return List
     */
    public List<StandardCategory> getStandardCategories() {
        List standardCategories;
        standardCategories = categories;
        return standardCategories;
    }


    /**
     * Method to add a new CustomCategory to a Family's Category List
     *
     * @param categoryDesignation Label/Description to assign to the category
     * @param parentID            ID of the Standard or Custom category to be the parent. 0 for root
     * @return True if the category is successfuly added to the family's category tree.
     */
    public boolean addCategoryToFamilyTree(int familyID, String categoryDesignation, int parentID, String adminCC) {
        Family targetFamily = familyService.getFamily(familyID);
        boolean result = false;
        if (familyService.verifyAdministratorPermission(familyID, adminCC)) {
            if (parentID > 0) {
                StandardCategory parent = getStandardCategoryByID(parentID);
                checkIfParentNull(parent);
                CustomCategory newCustomCategory = new CustomCategory(categoryDesignation, parent, generateCustomCategoryID(targetFamily));
                targetFamily.addCategory(newCustomCategory);
                result = true;
            } else if (parentID < 0) {
                CustomCategory parent = getCustomCategoryByID(parentID, targetFamily);
                checkIfParentNull(parent);
                CustomCategory newCustomCategory = new CustomCategory(categoryDesignation, parent, generateCustomCategoryID(targetFamily));
                targetFamily.addCategory(newCustomCategory);
                result = true;
            } else {
                CustomCategory newCustomCategory = new CustomCategory(categoryDesignation, generateCustomCategoryID(targetFamily));
                targetFamily.addCategory(newCustomCategory);
                result = true;
            }
        }else{
            result = false;
        }
        return result;
    }

    /**
     * This method returns a CustomCategory of a given ID
     *
     * @param categoryID ID of the CustomCategory to be returned
     * @return chosen CustomCategory, if the CustomCategory is not found returns null;
     */
    private CustomCategory getCustomCategoryByID(int categoryID, Family tagetFamily) {
        CustomCategory selectedCategory = null;
        int size = tagetFamily.getFamilyCustomCategories().size();
        for (int index = 0; index < size; index++) {
            if (tagetFamily.getFamilyCustomCategories().get(index).getCategoryID() == categoryID) {
                selectedCategory = tagetFamily.getFamilyCustomCategories().get(index);
                index = size;
            }
        }
        return selectedCategory;
    }

    private void checkIfParentNull(Category parent) {
        if (parent == null) {
            throw new IllegalArgumentException("Expected CustomCategoryParent but was null");
        }
    }

    private void checkIfParentNull(StandardCategory parent) {
        if (parent == null) {

            throw new IllegalArgumentException("Expected StandardCategoryParent but was null");
        }
    }

    private int generateCustomCategoryID(Family targetFamily) {
        int minID = 0;
        for (CustomCategory category : targetFamily.getFamilyCustomCategories()) {
            if (minID > category.getCategoryID()) minID = category.getCategoryID();
        }
        return minID - 1;
    }


}
