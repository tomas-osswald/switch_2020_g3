package switch2020.project.model;

public class Category {

    // Attributes
    private String cname;
    private boolean isStandard;

    // Constructors
    public Category(String cname){
        this.cname = cname;
        this.isStandard = true;
    }

    // Business Methods
    public String getCname() {
        return cname;
    }

    public boolean isStandard() {
        return isStandard;
    }

}
