package switch2020.project.model;

import switch2020.project.services.FamilyService;

import java.util.ArrayList;


public class Application {

    private ArrayList<Category> categories = new ArrayList<>();

    private FamilyService familyService;

    public Application() {

    }

    public FamilyService getFamilyService() {
        return this.familyService;
    }
}
