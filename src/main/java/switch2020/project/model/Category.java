package switch2020.project.model;

public class Category {
    //attributes
    private String categoryName;
    private int categoryLevel;
    private boolean isStandard;

    //constructors
    public Category(String categoryName){
        this.categoryName = categoryName;
        this.isStandard = true;
    }

    public String getCname() {
        return categoryName;
    }

    public boolean isStandard() {
        return isStandard;
    }
}




