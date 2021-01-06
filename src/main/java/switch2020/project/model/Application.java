package switch2020.project.model;


import switch2020.project.services.FamilyService;

import java.util.ArrayList;

public class Application {

    private FamilyService familyService = new FamilyService();
    private ArrayList<Category> categories = new ArrayList();

    public Application() {

    }

    public Application(Family family) {
        this.familyService.addFamily(family);

    }

    public boolean addEmail(String emailToAdd, int familyID, int familyMemberID) {
        return this.familyService.addEmail(emailToAdd, familyID, familyMemberID);
    }
}
