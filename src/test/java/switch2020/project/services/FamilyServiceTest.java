package switch2020.project.services;

import org.junit.jupiter.api.Test;
import switch2020.project.model.Family;
import switch2020.project.model.FamilyMember;

import static org.junit.jupiter.api.Assertions.*;

class FamilyServiceTest {

    @Test
    void GetFamilyByID() {
        int familyID1 = 1;
        int familyID2 = 2;
        Family family1 = new Family(familyID1);
        Family family2 = new Family(familyID2);
        FamilyService familyService = new FamilyService();

        familyService.addFamily(family1);
        familyService.addFamily(family2);

        int familyID = 2;

        int expected = 2;

        int result = familyService.getFamily(familyID).getFamilyID();

        assertEquals(expected, result);
    }

    @Test
    void GivenFamilyIDNotFound() {
        int familyID1 = 1;
        int familyID2 = 2;
        Family family1 = new Family(familyID1);
        Family family2 = new Family(familyID2);
        FamilyService familyService = new FamilyService();

        familyService.addFamily(family1);
        familyService.addFamily(family2);

        int familyID = 3; //Dont exist any family with that ID number

        assertThrows(IllegalArgumentException.class, () -> familyService.getFamily(familyID));
    }

    @Test
    void CreateRelation() {
        String relationDesignation = "Mother";
        FamilyService familyService = new FamilyService();

        int familyMemberID1 = 1;
        int familyMemberID2 = 2;
        FamilyMember familyMember1 = new FamilyMember(familyMemberID1);
        FamilyMember familyMember2 = new FamilyMember(familyMemberID2);
        familyMember1.makeAdmin();

        int familyID = 1;
        Family family = new Family(familyID);

        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);

        familyService.addFamily(family);

        assertTrue(familyService.createRelation(familyMemberID1, familyMemberID2, relationDesignation, familyID));
    }

    @Test
    void NotAdminTryingToCreateRelationReturningFalse() {
        String relationDesignation = "Mother";
        FamilyService familyService = new FamilyService();

        int familyMemberID1 = 1;
        int familyMemberID2 = 2;
        FamilyMember familyMember1 = new FamilyMember(familyMemberID1);
        FamilyMember familyMember2 = new FamilyMember(familyMemberID2);

        int familyID = 1;
        Family family = new Family(familyID);

        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);

        familyService.addFamily(family);

        assertFalse(familyService.createRelation(familyMemberID1, familyMemberID2, relationDesignation, familyID));
    }

    @Test
    void FamilyDontExist() {
        String relationDesignation = "Mother";
        FamilyService familyService = new FamilyService();

        int familyMemberID1 = 1;
        int familyMemberID2 = 2;
        FamilyMember familyMember1 = new FamilyMember(familyMemberID1);
        FamilyMember familyMember2 = new FamilyMember(familyMemberID2);
        familyMember1.makeAdmin();

        int familyID = 1;
        Family family = new Family(familyID);

        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);

        familyService.addFamily(family);

        int familyID2 = 2;

        assertThrows(IllegalArgumentException.class, () -> familyService.createRelation(familyMemberID1, familyMemberID2, relationDesignation, familyID2));
    }

    @Test
    void CreateAnExistingRelationDesignation() {
        String relationDesignation1 = "Mother";
        String relationDesignation2 = "mother";
        FamilyService familyService = new FamilyService();

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

        familyService.addFamily(family);

        familyService.createRelation(familyMemberID1, familyMemberID2, relationDesignation1, familyID);

        int result = family.numberOfRelationDesignations();

        assertTrue(familyService.createRelation(familyMemberID1, familyMemeberID3, relationDesignation2, familyID));
        assertEquals(expected, result);
    }

    @Test
    void FamilyMemberWithARelationAssigned() {
        String relationDesignation1 = "Mother";
        String relationDesignation2 = "Father";
        FamilyService familyService = new FamilyService();

        int familyMemberID1 = 1;
        int familyMemberID2 = 2;
        FamilyMember familyMember1 = new FamilyMember(familyMemberID1);
        FamilyMember familyMember2 = new FamilyMember(familyMemberID2);
        familyMember1.makeAdmin();

        int familyID = 1;
        Family family = new Family(familyID);

        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);

        familyService.addFamily(family);

        familyService.createRelation(familyMemberID1, familyMemberID2, relationDesignation1, familyID);

        assertThrows(IllegalArgumentException.class, () -> familyService.createRelation(familyMemberID1, familyMemberID2, relationDesignation2, familyID));
    }
}