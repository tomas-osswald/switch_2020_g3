package switchtwentytwenty.project.Category;

import switchtwentytwenty.project.ValueObject;

public class CategoryName implements ValueObject {
    private final String name;

    public CategoryName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
