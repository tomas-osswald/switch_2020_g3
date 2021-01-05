package switch2020.project.model;

import java.util.ArrayList;


public class Application {

    private ArrayList<Family> families = new ArrayList<>();
    private ArrayList<Category> categories = new ArrayList<>();

    public Application() {

    }

    /**
     * Method to add a Family to Families List -> families
     *
     * @param family Family to add
     */

    protected void addFamily(Family family) {
        this.families.add(family);
    }

    /**
     * Method to create a Relation and assign it to a Family Member
     *
     * @param selfID ID of the Family Member how wants to create a Relation
     * @param otherID ID of the Family Member to be added a Relation
     * @param relationDesignation Relation Designation
     * @param familyID FamilyID of Family Member how wants to create a Relation
     * @return boolean
     */

    public boolean createRelation(int selfID, int otherID, String relationDesignation, int familyID) {
        Relation relation;
        Family fam = getFamily(familyID);

        if (fam.isAdmin(selfID)) { // If is Administrator
            if (fam.hasDesignation(relationDesignation)) { // Verify if a given relation designation is already present in list of relations assigned
                relation = new Relation(relationDesignation);
                fam.addRelationToFamilyMember(otherID, relation); // Create a Relation instance and assign to a Family Member

            } else { // If not, add to list of relations assigned
                relation = new Relation(relationDesignation);
                fam.addToRelationDesignationList(relationDesignation);
                fam.addRelationToFamilyMember(otherID,relation); // Create a Relation instance and assign to a Family Member
            }
            return true; // Return true if is administrator and a Relation has been created and assigned to given Family Member
        }
        return false; // Return false if isn't administrator
    }

    /**
     *  Method to get a family by ID in families
     *
     * @param familyID FamilyID of required family
     * @return Family instance
     */

    protected Family getFamily(int familyID) {
        for (Family family : families) {
            if (family.getFamilyID() == familyID)
                return family;
        }
        throw new IllegalArgumentException("No family with such ID");
    }

}
