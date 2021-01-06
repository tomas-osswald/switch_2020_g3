package switch2020.project.model;

public class Category {
    //attributes
    private String categoryName;
    private int categoryLevel;
    private boolean standard;

    //constructors
    public Category(String categoryName){
        this.categoryName = categoryName;
        this.standard = true;
    }

    public String getCname() {
        return categoryName;
    }

    public boolean checkIfIsStandard(){
        if(this.standard == true){
            return true;
        }
        return false;
    }

}




