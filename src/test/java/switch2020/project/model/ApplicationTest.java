package switch2020.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    void GetFamilyByID() {
        int familyID1 = 1;
        int familyID2 = 2;
        Family family1 = new Family(familyID1);
        Family family2 = new Family(familyID2);
        Application application = new Application();

        application.addFamily(family1);
        application.addFamily(family2);

        int familyID = 2;

        int expected = 2;

        int result = application.getFamily(familyID).getFamilyID();

        assertEquals(expected, result);
    }

    @Test
    void GivenFamilyIDNotFound() {
        int familyID1 = 1;
        int familyID2 = 2;
        Family family1 = new Family(familyID1);
        Family family2 = new Family(familyID2);
        Application application = new Application();
        application.addFamily(family1);
        application.addFamily(family2);

        int familyID = 3; //Dont exist any family with that ID number

        assertThrows(IllegalArgumentException.class, () -> application.getFamily(familyID));
    }

    @Test
    void CreateRelation() {
        String relationDesignation = "Mother";
        Application application = new Application();

        int familyMemberID1 = 1;
        int familyMemberID2 = 2;
        FamilyMember familyMember1 = new FamilyMember(familyMemberID1);
        FamilyMember familyMember2 = new FamilyMember(familyMemberID2);
        familyMember1.makeAdmin();

        int familyID = 1;
        Family family = new Family(familyID);

        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);

        application.addFamily(family);

        assertTrue(application.createRelation(familyMemberID1, familyMemberID2, relationDesignation, familyID));
    }

    @Test
    void NotAdminTryingToCreateRelationReturningFalse() {
        String relationDesignation = "Mother";
        Application application = new Application();

        int familyMemberID1 = 1;
        int familyMemberID2 = 2;
        FamilyMember familyMember1 = new FamilyMember(familyMemberID1);
        FamilyMember familyMember2 = new FamilyMember(familyMemberID2);

        int familyID = 1;
        Family family = new Family(familyID);

        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);

        application.addFamily(family);

        assertFalse(application.createRelation(familyMemberID1, familyMemberID2, relationDesignation, familyID));
    }

    @Test
    void FamilyDontExist() {
        String relationDesignation = "Mother";
        Application application = new Application();

        int familyMemberID1 = 1;
        int familyMemberID2 = 2;
        FamilyMember familyMember1 = new FamilyMember(familyMemberID1);
        FamilyMember familyMember2 = new FamilyMember(familyMemberID2);
        familyMember1.makeAdmin();

        int familyID = 1;
        Family family = new Family(familyID);

        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);

        application.addFamily(family);

        int familyID2 = 2;

        assertThrows(IllegalArgumentException.class, () -> application.createRelation(familyMemberID1, familyMemberID2, relationDesignation, familyID2));
    }

    @Test
    void CreateAnExistingRelationDesignation() {
        String relationDesignation1 = "Mother";
        String relationDesignation2 = "mother";
        Application application = new Application();

        int familyMemberID1 = 1;
        int familyMemberID2 = 2;
        int familyMemeberID3 = 3;
        FamilyMember familyMember1 = new FamilyMember(familyMemberID1);
        FamilyMember familyMember2 = new FamilyMember(familyMemberID2);
        FamilyMember familyMember3 = new FamilyMember(familyMemeberID3);
        familyMember1.makeAdmin();

        int familyID = 1;
        Family family = new Family(familyID);

        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);
        family.addFamilyMember(familyMember3);

        int expected = 1;

        application.addFamily(family);

        application.createRelation(familyMemberID1, familyMemberID2, relationDesignation1, familyID);

        int result = family.numberOfRelationDesignations();

        assertTrue(application.createRelation(familyMemberID1, familyMemeberID3, relationDesignation2, familyID));
        assertEquals(expected, result);
    }

    @Test
    void FamilyMemberWithARelationAssigned() {
        String relationDesignation1 = "Mother";
        String relationDesignation2 = "Father";
        Application application = new Application();

        int familyMemberID1 = 1;
        int familyMemberID2 = 2;
        FamilyMember familyMember1 = new FamilyMember(familyMemberID1);
        FamilyMember familyMember2 = new FamilyMember(familyMemberID2);
        familyMember1.makeAdmin();

        int familyID = 1;
        Family family = new Family(familyID);

        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);

        application.addFamily(family);

        application.createRelation(familyMemberID1, familyMemberID2, relationDesignation1, familyID);

        assertThrows(IllegalArgumentException.class, () -> application.createRelation(familyMemberID1, familyMemberID2, relationDesignation2, familyID));
    }
}