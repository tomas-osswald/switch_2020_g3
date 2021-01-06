package switch2020.project.model;

import java.util.ArrayList;
import java.util.List;

public class FamilyService {

    private List<Family> families;

    public FamilyService() {
        this.families = new ArrayList<>();
    }

    public boolean addFamily(String familyName) {
        try {
            Family newFamily = new Family(familyName);
            families.add(newFamily);
            return true;
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }
}
