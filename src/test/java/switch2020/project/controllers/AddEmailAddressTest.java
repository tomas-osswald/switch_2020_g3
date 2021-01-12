package switch2020.project.controllers;

import org.junit.jupiter.api.Test;
import switch2020.project.model.Application;
import switch2020.project.model.Family;
import switch2020.project.model.FamilyMember;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AddEmailAddressTest {

    FamilyMember familyMember1 = new FamilyMember("000000000ZZ4");
    FamilyMember familyMember2 = new FamilyMember("137843828ZX3");
    FamilyMember familyMember3 = new FamilyMember("137476450ZX0");
    String testFamilyName = "Moura";
    int testFamilyID = 10;
    Family testFamily = new Family(testFamilyName, testFamilyID);
    Application app = new Application(testFamily);
    AddEmailController controller = new AddEmailController(app);

    @Test
    public void checkIfEmailAdded() {
        testFamily.addFamilyMember(familyMember1);
        assertTrue(controller.addEmail("adolin@highprince.com", 10, "000000000ZZ4"));
    }


    @Test
    public void checkEmailAlreadyPresent() {
        testFamily.addFamilyMember(familyMember2);
        controller.addEmail("kaladin@depression.com", 10, "137843828ZX3");
        assertFalse(controller.addEmail("kaladin@depression.com", 10, "137843828ZX3"));
    }

    @Test
    public void checkIfThrowsWhenNoSuchMemberID() {
        assertFalse(controller.addEmail("hoid@cosmere.com", 10, "137476450ZX0"));
    }

    @Test
    public void checkIfThrowsWhenNoSuchFamilyID() {
        testFamily.addFamilyMember(familyMember3);
        assertFalse(controller.addEmail("shallan@mentalhospital.com", 11, "137476450ZX0"));
    }
}