package switch2020.project.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {

    @Test
    void AddFamilyMembers() {
        int familyMemberID1 = 1;
        int familyMemberID2 = 2;
        FamilyMember familyMember1 = new FamilyMember(familyMemberID1);
        FamilyMember familyMember2 = new FamilyMember(familyMemberID2);

        int familyID = 1;
        Family family = new Family(familyID);

        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);

        int expected = 2;

        int result = family.numberOfFamilyMembers();

        assertEquals(expected, result);
    }

    @Test
    void AddFamilyMembersArray() {
        int familyMemberID1 = 1;
        int familyMemberID2 = 2;
        FamilyMember familyMember1 = new FamilyMember(familyMemberID1);
        FamilyMember familyMember2 = new FamilyMember(familyMemberID2);

        ArrayList<FamilyMember> familyMembersList = new ArrayList<>();

        familyMembersList.add(familyMember1);
        familyMembersList.add(familyMember2);

        int familyID = 1;
        Family family = new Family(familyID);

        family.addFamilyMemberArray(familyMembersList);

        int expected = 2;

        int result = family.numberOfFamilyMembers();

        assertEquals(expected, result);
    }

    @Test
    void IsAdminTrue() {
        int familyMemberID = 1;
        FamilyMember familyMember1 = new FamilyMember(familyMemberID);
        familyMember1.makeAdmin();

        int familyID = 1;
        Family family = new Family(familyID);

        family.addFamilyMember(familyMember1);

        assertTrue(family.isAdmin(familyMemberID));
    }

    @Test
    void IsAdminFalse() {
        int familyMemberID = 1;
        FamilyMember familyMember1 = new FamilyMember(familyMemberID);

        int familyID = 1;
        Family family = new Family(familyID);

        family.addFamilyMember(familyMember1);

        assertFalse(family.isAdmin(familyMemberID));
    }

    @Test
    void AdminWithGivenIDNotFoundNoFamilyMemberWithThatID() {
        int familyMemberID1 = 1;
        int familyMemberID2 = 2;
        FamilyMember familyMember1 = new FamilyMember(familyMemberID1);
        FamilyMember familyMember2 = new FamilyMember(familyMemberID2);
        familyMember1.makeAdmin();

        int familyID = 1;
        Family family = new Family(familyID);

        family.addFamilyMember(familyMember1);
        family.addFamilyMember(familyMember2);

        int notAtribuitedID = 3;

        assertFalse(family.isAdmin(notAtribuitedID));
    }

    @Test
    void FamilyMemberWithGivenIDDoesntExist() {
        int familyMemberID = 1;
        int familyMemberIDThatDoesntExist = 2;
        FamilyMember familyMember = new FamilyMember(familyMemberID);

        int familyID = 1;
        Family family = new Family(familyID);
        family.addFamilyMember(familyMember);

        String relationDesignation = "Mother";
        Relation relation = new Relation(relationDesignation);

        assertThrows(IllegalArgumentException.class, () -> family.addRelationToFamilyMember(familyMemberIDThatDoesntExist, relation));
    }
}