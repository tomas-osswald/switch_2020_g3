package switchtwentytwenty.project.util;

public class FamilyIDFactory {

    private int lastFamilyID = 0;

    public int generateFamilyID() {
        this.lastFamilyID++;
        return this.lastFamilyID;
    }
}
