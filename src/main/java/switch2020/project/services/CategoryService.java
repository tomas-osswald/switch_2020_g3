package switch2020.project.services;

import switch2020.project.model.CategoryMap;
import switch2020.project.utils.CategoryTreeDTO;
import switch2020.project.model.StandardCategory;
import switch2020.project.utils.StandardCategoryDTO;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {

    private List<StandardCategory> categories;

    public CategoryService() {
        this.categories = new ArrayList<>();
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
     * @param categoryID ID of the StandardCategory to be returned
     * @return chosen StandardCategory, if the StandardCategory is not found returns null;
     */
    private StandardCategory getStandardCategoryByID(int categoryID) {
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
        for (int index = 0; index < size; index++) {
            if (this.categories.get(index).isDesignationOfThisCategory(categoryName)) {
                categoryPresent = true;
                index = size;
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
        for (int index = 0; index < size; index++) {
            if (this.categories.get(index).isIDOfThisCategory(parentID)) {
                idPresent = true;
                index = size;
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
     * @return List of StandardCategory objects
     */
    public List<StandardCategory> getCategories() {
        return this.categories;
    }

    /**
     * Method to create and return a Family's CategoryTree
     * @param familyID ID of the target family
     * @param familyService The Application's familyService
     * @return CategoryTreeDTO Object
     */
    public CategoryTreeDTO getCategoryTree(int familyID, FamilyService familyService) {
        CategoryTreeDTO categoryTree = new CategoryTreeDTO(this, familyService, familyID);
        return categoryTree;
    }

    public List getStandardCategories() {
        if (categories.size() == 0) {
            throw new IllegalArgumentException("There are no standard categories");
        }
        List standardCategories = new ArrayList<StandardCategory>();
        standardCategories = categories;
        return standardCategories;

    }

    public List<StandardCategoryDTO> getStandardCategoriesDTOList() {
        List<StandardCategory> categories = getCategories();
        List<StandardCategoryDTO> standardCategoriesDTOList = new ArrayList<>();
        for (StandardCategory cat : categories) {
            //if (cat.isStandardCategory()){
            String categoryName = cat.getName();
            StandardCategoryDTO newcat = new StandardCategoryDTO(categoryName);
            standardCategoriesDTOList.add(newcat);
            //}
        }
        return standardCategoriesDTOList;
    }
}