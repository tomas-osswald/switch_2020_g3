package switchtwentytwenty.project.util;

import switchtwentytwenty.project.shared.FamilyID;

import java.util.UUID;

public class FamilyIDFactory {

    private int lastFamilyID = 0;

    public int generateFamilyID() {
        this.lastFamilyID++;
        return this.lastFamilyID;
    }

}
