package switch2020.project.model;

import java.util.ArrayList;


public class Application {

    private ArrayList<Family> families = new ArrayList<>();
    private ArrayList<Category> categories = new ArrayList<>();

    public Application() {

    }

    /**
     *
     * @param family
     */

    protected void addFamily(Family family) {
        this.families.add(family);
    }

    /**
     *
     * @param selfID
     * @param otherID
     * @param relationDesignation
     * @param familyID
     * @return
     */

    public boolean createRelation(int selfID, int otherID, String relationDesignation, int familyID) {
        Relation relation;
        Family fam = getFamily(familyID);

        if (fam.isAdmin(selfID)) {
            if (fam.hasDesignation(relationDesignation)) {
                relation = new Relation(relationDesignation);
                fam.addRelationToFamilyMember(otherID, relation);

            } else {
                relation = new Relation(relationDesignation);
                fam.addToRelationDesignationList(relationDesignation);
                fam.addRelationToFamilyMember(otherID,relation);
            }
            return true;
        }
        return false;
    }

    /**
     *
     * @param familyID
     * @return
     */

    protected Family getFamily(int familyID) {
        for (Family family : families) {
            if (family.getFamilyID() == familyID)
                return family;
        }
        throw new IllegalArgumentException("No family with such ID");
    }

}
