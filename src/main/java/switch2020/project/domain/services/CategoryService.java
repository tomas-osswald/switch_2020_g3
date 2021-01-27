package switch2020.project.domain.services;

import switch2020.project.domain.model.categories.CustomCategory;
import switch2020.project.domain.model.Family;
import switch2020.project.domain.model.categories.StandardCategory;
import switch2020.project.domain.DTOs.output.CategoryTreeDTO;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {

    private List<StandardCategory> categories;

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryService that = (CategoryService) o;
        return categories.equals(that.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categories);
    }*/

    public CategoryService() {
        this.categories = new ArrayList<>();
        StandardCategory other = new StandardCategory("Other", null, 0);
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
     *
     * @return List of StandardCategory objects
     */
    public List<StandardCategory> getCategories() {
        return this.categories;
    }

    public CategoryTreeDTO getStandardCategoryTree() {
        CategoryTreeDTO standardCategoryTree = new CategoryTreeDTO(this);
        return standardCategoryTree;
    }

    /**
     * Method to create and return a Family's CategoryTree
     *
     * @param familyID      ID of the target family
     * @param familyService The Application's familyService
     * @return CategoryTreeDTO Object
     */
    public CategoryTreeDTO getCategoryTree(int familyID, FamilyService familyService) {
        CategoryTreeDTO categoryTree = new CategoryTreeDTO(this, familyService, familyID);
        return categoryTree;
    }

    /**
     * Method to get all the Standard Categories
     *
     * @return List
     */
    public List<StandardCategory> getStandardCategories() {
        if (this.categories.size() == 0 || this.categories == null) {
            throw new IllegalArgumentException("There are no standard categories");
        }
        List standardCategories = new ArrayList<StandardCategory>();
        standardCategories = categories;
        return standardCategories;
    }


    //No Parent
    public boolean addCategoryToFamilyTree(Family targetFamily, String categoryDesignation, int parentID) {
        if (parentID > 0) {
            StandardCategory parent = getStandardCategoryByID(parentID);
            checkIfParentNull(parent);
            CustomCategory newCustomCategory = new CustomCategory(categoryDesignation, parent, generateCustomCategoryID(targetFamily));
            return targetFamily.addCategory(newCustomCategory);
        } else if (parentID < 0) {
            CustomCategory parent = getCustomCategoryByID(parentID, targetFamily);
            checkIfParentNull(parent);
            CustomCategory newCustomCategory = new CustomCategory(categoryDesignation, parent, generateCustomCategoryID(targetFamily));
            return targetFamily.addCategory(newCustomCategory);
        } else {
            CustomCategory newCustomCategory = new CustomCategory(categoryDesignation, generateCustomCategoryID(targetFamily));
            return targetFamily.addCategory(newCustomCategory);
        }
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

    private void checkIfParentNull(CustomCategory parent) {
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


    /**
     * Method to get the parent name of a passed category name
     *
     * @param standardCategories
     * @return list of parents, i.e., a list of categories that have at least one child
     */
    /*private List<StandardCategory> getParents(List<StandardCategory> standardCategories) {
        List<StandardCategory> parents = new ArrayList<>();
        for (StandardCategory cat : standardCategories
        ) {
            if (cat.getParentName() != null) {
                parents.add(cat);
            }
        }
        return parents;
    }*/

    /*private boolean hasParent(){

    }*/

    /*private List<StandardCategory> getParentss(List<StandardCategory> standardCategories) {
        List<StandardCategory> parents = new ArrayList<>();
        for (StandardCategory cat : standardCategories
        ) {
            if (cat.getParentName() != null) {
                parents.add(cat);
            }
        }
        return parents;
    }*/

    /**
     * Method to get the childs of a passed parent category name
     *
     * @param standardCategory
     * @param standardCategories
     * @return list of childs
     */
   /* private List<StandardCategory> getChilds(StandardCategory standardCategory, List<StandardCategory> standardCategories) {
        List<StandardCategory> childs = new ArrayList<>();
        for (StandardCategory cat : standardCategories
        ) {
            if (cat.isChildOf(standardCategory)) {
                childs.add(cat);
            }
        }
        return childs;
    }*/

    /**
     * Method to add the childs of a specific category
     *
     * @param dto
     * @param cat
     * @param categs
     */
    /*private void addChildsToDTO(StandardCategoryDTO dto, StandardCategory cat, List<StandardCategory> categs) {
        List<StandardCategory> stdList = this.getChilds(cat, categs);
        for (StandardCategory c : stdList) {
            StandardCategoryDTO dtoChild = new StandardCategoryDTO(c.getName());
            this.addChildsToDTO(dtoChild, c, categs);
            dto.addChild(dtoChild);
        }
    }*/

    /**
     * Method to obtain a list of sub-lists that have a parent category and their descendants(childs)
     *
     * @param standardCategories
     * @return list of StandardCategoryDTO
     */
    /*private List<StandardCategoryDTO> createStdTree(List<StandardCategory> standardCategories) {
        List<StandardCategoryDTO> totalStdList = new ArrayList<>();

        List<StandardCategory> stdList = this.getParents(standardCategories);
        for (StandardCategory cat : stdList
        ) {
            StandardCategoryDTO dto = new StandardCategoryDTO(cat.getName());
            this.addChildsToDTO(dto, cat, standardCategories);
            totalStdList.add(dto);
        }
        return totalStdList;
    }*/

    /*public List<StandardCategoryDTO> getStandardCategoriesTree() {
        List<StandardCategory> standardCategories = this.getStandardCategories();
        return createStdTree(standardCategories);
    }*/
}
