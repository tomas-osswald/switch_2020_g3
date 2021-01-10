package switch2020.project.model;

public class StandardCategory {

    //atributes

    private int categoryID;
    private String categoryName;
    private StandardCategory parentCategory;

    public StandardCategory(String categoryName, StandardCategory parentCategory, int categoryID){
        if (!isNameValid(categoryName)) throw new IllegalArgumentException("Name invalid");
        this.categoryID = categoryID;
        this.categoryName = categoryName.trim().toUpperCase();
        this.parentCategory = parentCategory;
    }

    public int getParentID() {
        return parentCategory.getCategoryID();
    }

    public int getCategoryID() {
        return categoryID;
    }

    public String getName() {
        return this.categoryName;
    }

/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return Objects.equals(categoryName);
    }
 */

    /**
     * Method to validate if name is valid. Tests if String is null, empty or composed only of blank spaces
     * @param categoryName String representing the name to be validated
     * @return true if name follows the rules, false otherwise
     */


    private boolean isNameValid(String categoryName) {
        if (categoryName == null || categoryName.isEmpty() || categoryName.isBlank()) return false;
        return true;
    }

}