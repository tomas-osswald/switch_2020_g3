package switch2020.project.model;


import java.util.ArrayList;

public class Application {

    private ArrayList<Family> families = new ArrayList();
    private ArrayList<Category> categories = new ArrayList();

    public Application() {

    }

    public Application(Family family) {
        this.families.add(family);
    }

    public boolean addEmail(String emailToAdd, int familyMemberID) {
        return this.families.get(0).addEmail(emailToAdd, familyMemberID);
    }


}
