package java.switch2020.project.controllers;

import org.junit.jupiter.api.Test;
import switch2020.project.controllers.AddEmailController;
import switch2020.project.model.Application;
import switch2020.project.model.Family;
import switch2020.project.model.FamilyMember;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AddEmailAddressTest {


    FamilyMember familyMember1 = new FamilyMember(666);
    FamilyMember familyMember2 = new FamilyMember(777);
    FamilyMember familyMember3 = new FamilyMember(888);
    Family testFamily = new Family(10);
    Application app = new Application(testFamily);
    AddEmailController controller = new AddEmailController(app);

    @Test
    public void checkIfEmailAdded() {
        testFamily.addFamilyMember(familyMember1);
        assertTrue(controller.addEmail("adolin@highprince.com", 10, 666));
    }


    @Test
    public void checkEmailAlreadyPresent() {
        testFamily.addFamilyMember(familyMember2);
        controller.addEmail("kaladin@depression.com", 10, 777);
        assertFalse(controller.addEmail("kaladin@depression.com", 10, 777));
    }

    @Test
    public void checkIfThrowsWhenNoSuchMemberID() {
        assertFalse(controller.addEmail("hoid@cosmere.com", 10, 888));
    }

    @Test
    public void checkIfThrowsWhenNoSuchFamilyID() {
        testFamily.addFamilyMember(familyMember3);
        assertFalse(controller.addEmail("shallan@mentalhospital.com", 11, 888));
    }
}