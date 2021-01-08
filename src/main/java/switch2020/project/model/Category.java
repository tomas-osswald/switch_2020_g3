package switch2020.project.model;

public class Category {

    //atributes
    //private int categoryID;
    private String categoryName;
    private int categoryLevel;
    // private int parentID; //zero if one of the root categories
    private int parentID;
    private boolean standardCategory;
    private int categoryID;

    public Category(String categoryName) {
        if (!isNameValid(categoryName)) throw new IllegalArgumentException("Name invalid");
        this.categoryName = categoryName.trim().toUpperCase();
        categoryLevel = 0;
        standardCategory = true;
    }

    //constructor
    public Category(String categoryName, int parentNumber) {
        this.categoryName = categoryName;
        this.parentID = parentNumber;

        if (this.categoryName.length() < 1) {
            try {
                throw new Exception("Category Name must have at least 1 character");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            this.categoryName = this.categoryName;
        }
    }

    public int getParentID() {
        return parentID;
    }

    //Create constructor to create family category. uses name, level and parent id as arguments.//

/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return Objects.equals(categoryName);
    }
 */

    public int getCategoryID() {
        return categoryID;
    }

    /**
     * Method to validate if name is not null
     *
     * @param categoryName
     * @return
     */


    private boolean isNameValid(String categoryName) {
        if (categoryName == null || categoryName.isBlank()) return false;
        return true;
    }

    public String getName() {
        return this.categoryName;
    }

    /**
     * Method to determine if this category is one of the Standard categories
     *
     * @return true if one of the Standard categories, false otherwise
     */

    public boolean isStandardCategory() {
        return this.standardCategory;
    }


}
