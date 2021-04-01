package switchtwentytwenty.project.domain.category;

import switchtwentytwenty.project.shared.FamilyID;

public class CustomCategory implements Category {

    private CategoryData categoryData;
    private FamilyID family;

    public CustomCategory(CategoryData categoryData) {
        this.categoryData = categoryData;
    }
}
