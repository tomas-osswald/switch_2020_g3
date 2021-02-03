package switchtwentytwenty.project.domain.model.categories;

public class CustomCategory implements Category {
    private int categoryID;
    private String categoryName;
    private Category parentCategory;


    public CustomCategory(String categoryName, Category parentCategory, int categoryID) {
        if (!isNameValid(categoryName)) throw new IllegalArgumentException("Name invalid");
        this.categoryName = categoryName.trim().toUpperCase();
        this.parentCategory = parentCategory;
        this.categoryID = categoryID;
    }

    public CustomCategory(String categoryName, int categoryID) {
        if (!isNameValid(categoryName)) throw new IllegalArgumentException("Name invalid");
        this.categoryName = categoryName.trim().toUpperCase();
        this.categoryID = categoryID;
    }

    public boolean isRootCategory() {
        if (parentCategory == null) {
            return true;
        } else {
            return false;
        }
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public int getParentID() {
        return this.parentCategory.getCategoryID();
    }

    private boolean isNameValid(String categoryName) {
        if (categoryName == null || categoryName.isEmpty() || categoryName.trim().length() == 0) return false;
        return true;
    }
}
