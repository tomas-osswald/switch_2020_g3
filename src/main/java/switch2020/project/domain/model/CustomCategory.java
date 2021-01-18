package switch2020.project.domain.model;

public class CustomCategory {
    private int categoryID;
    private String categoryName;
    private StandardCategory parentStandardCategory;
    private CustomCategory parentCustomCategory;

    public CustomCategory(String categoryName, StandardCategory parentCategory, int categoryID) {
        if (!isNameValid(categoryName)) throw new IllegalArgumentException("Name invalid");
        this.categoryName = categoryName.trim().toUpperCase();
        this.parentStandardCategory = parentCategory;
        this.categoryID = categoryID;
    }

    public CustomCategory(String categoryName, CustomCategory parentCategory, int categoryID) {
        if (!isNameValid(categoryName)) throw new IllegalArgumentException("Name invalid");
        this.categoryName = categoryName.trim().toUpperCase();
        this.parentCustomCategory = parentCategory;
        this.categoryID = categoryID;
    }


    public String getCategoryName() {
        return categoryName;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public int getParentID() {
        if (this.parentStandardCategory != null) {
            return this.parentStandardCategory.getCategoryID();
        } else {
            return this.parentCustomCategory.getCategoryID();
        }
    }

    private boolean isNameValid(String categoryName) {
        if (categoryName == null || categoryName.isEmpty() || categoryName.isBlank()) return false;
        return true;
    }
}
