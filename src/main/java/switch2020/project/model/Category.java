package switch2020.project.model;

import java.util.Scanner;

public class Category {
    //atributes
    private String cname;
    private int parentNumber;
    private boolean isStandard;

    //constructor

    public Category(String cname, int parentNumber) {
        this.cname = cname;
        this.parentNumber = parentNumber;

        if(cname.length() < 1){
            try {
                throw new Exception("Category Name must have at least 1 character");
            } catch (Exception e) {
                e.printStackTrace();
            }
            else {
                this.cname = cname;
            }
        }
    }

}




