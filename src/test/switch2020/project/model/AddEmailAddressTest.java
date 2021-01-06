package switch2020.project.model;

import org.junit.jupiter.api.Test;
import switch2020.project.controllers.AddEmailController;
import switch2020.project.model.Application;
import switch2020.project.model.Family;
import switch2020.project.model.FamilyMember;

import static org.junit.jupiter.api.Assertions.*;

class AddEmailAddressTest {


    FamilyMember familyMember1 = new FamilyMember(666);
    FamilyMember familyMember2 = new FamilyMember(777);
    Family testFamily = new Family(10,familyMember1, familyMember2);
    Application app = new Application(testFamily);
    AddEmailController controller = new AddEmailController(app);

    @Test
    public void checkifEmailAdded() {
        assertTrue(controller.addEmail("adolin@highprince.com",10, 666));
    }


    @Test
    public void checkEmailAlreadyPresent() {
        controller.addEmail("kaladin@depression.com", 10,666);
        assertFalse(controller.addEmail("kaladin@depression.com", 10,666));
    }

    @Test
    public void checkIfThrowsWhenNoSuchMemberID() {
        assertFalse(controller.addEmail("hoid@cosmere.com",10, 888));
    }

    @Test
    public void checkIfThrowsWhenNoSuchFamilyID() {
        assertFalse(controller.addEmail("shallan@mentalhospital.com",11, 888));
    }
}