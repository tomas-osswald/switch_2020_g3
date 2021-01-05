package switch2020.project.model;

import java.util.Objects;

public class Category {

    //private int categoryID;
    private String categoryName;
    private int categoryLevel;
    // private int parentID; //zero if one of the root categories
    private boolean isStandard;

    public Category(String categoryName){
        if (!isNameValid(categoryName)) throw new IllegalArgumentException("Name invalid");
        this.categoryName = categoryName;
        categoryLevel = 0;
        isStandard = true;
    }

    //Create constructor to create family category. uses name, level and parent id as arguments.//

/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return Objects.equals(categoryName, category.categoryName);
    }
 */

    /**
     * Method to validate if name is not null
     * @param categoryName
     * @return
     */


    private boolean isNameValid (String categoryName){
        if (categoryName==null||categoryName=="") return false;
        return true;
    }



    public String getName(){
        return this.categoryName;
    }

    /**
     * Method to determine if this category is one of the Standard categories
     * @return true if one of the Standard categories, false otherwise
     */

    public boolean isStandard(){
        return this.isStandard;
    }

}
