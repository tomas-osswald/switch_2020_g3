package java.switch2020.project.model;

import java.util.ArrayList;
import java.switch2020.project.model.Family;
import java.switch2020.project.model.Category;


public class Application {

    private ArrayList<Family> families = new ArrayList<Family>();
    private ArrayList<Category> categories = new ArrayList<Category>();

    public Application() {

    }

    public boolean createRelation(int selfID, int otherID, String relationDesignation, int familyID) {
        Relation relation;
        Family fam = getFamily(familyID);

        if (fam.isAdmin(selfID)) {
            if (fam.hasDesignation(relationDesignation)) {
                relation = new Relation(relationDesignation);
                fam.addRelationToFamilyMember(otherID, relation);

            } else {
                relation = new Relation(relationDesignation);
                fam.addToRelationList(relation);
                fam.addRelationToFamilyMember(otherID,relation);
            }
            return true;
        }
        return false;
    }

    private Family getFamily(int familyID) {
        for (Family family : families) {
            if (family.getFamilyID() == familyID)
                return family;
        }

        throw new IllegalArgumentException("No family with such ID");
    }

}
