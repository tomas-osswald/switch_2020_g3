package switch2020.project.model;

public class Category {
    //attributes
    private String cname;
    private boolean isStandard;

    //constructors
    public Category(String cname){
        this.cname = cname;
        this.isStandard = true;
    }

    public String getCname() {
        return cname;
    }

    public boolean isStandard() {
        return isStandard;
    }

}
