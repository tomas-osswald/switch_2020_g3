package switch2020.project.domain.model.categories;

public class StandardCategory implements Category {

    //Attributes
    private int categoryID;
    private String categoryName;
    private StandardCategory parentCategory;

    //Constructor

    public StandardCategory(String categoryName, StandardCategory parentCategory, int categoryID) {
        if (!isNameValid(categoryName)) throw new IllegalArgumentException("Name invalid");
        this.categoryID = categoryID;
        this.categoryName = categoryName.trim().toUpperCase();
        this.parentCategory = parentCategory;
    }

    public int getParentID() {
        try {
            return parentCategory.getCategoryID();
        } catch (NullPointerException e) {
            return 0;
        }
    }

    public String getParentName() {
        if (this.parentCategory != null) {
            return this.parentCategory.getCategoryName();
        }
        return "root";
    }

    public int getCategoryID() {
        return categoryID;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    /*public boolean isChildOf(StandardCategory standardCategory) {
        if (this.getParentName() != null) {
            return standardCategory.equals(this.parentCategory);
        } else return false;
    }*/

    //Validation Methods

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof StandardCategory)) return false;
        StandardCategory otherCategory = (StandardCategory) other;
        return categoryName.equals(otherCategory.categoryName);
    }

    /**
     * Method to validate if name is valid. Tests if String is null, empty or composed only of blank spaces
     *
     * @param categoryName String representing the name to be validated
     * @return true if name follows the rules, false otherwise
     */

    private boolean isNameValid(String categoryName) {
        if (categoryName == null || categoryName.isEmpty() || categoryName.trim().length()==0) return false;
        return true;
    }

    /**
     * Method that compares a given ID is equal to the ID of this category
     *
     * @param categoryID int the categoryID you want to compare
     * @return true if the IDs match, otherwise false
     */
    public boolean isIDOfThisCategory(int categoryID) {
        return categoryID == this.categoryID;
    }

    public boolean isDesignationOfThisCategory(String categoryName) {
        return this.categoryName.compareToIgnoreCase(categoryName) == 0;
    }

}
