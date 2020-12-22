package switch2020.project.model;

import org.junit.jupiter.api.Test;
import switch2020.project.controllers.AddEmailController;

import static org.junit.jupiter.api.Assertions.*;

class AddEmailAddressTest {


    FamilyMember familyMember1 = new FamilyMember(666);
    FamilyMember familyMember2 = new FamilyMember(777);
    Family testFamily = new Family(familyMember1, familyMember2);
    Application app = new Application(testFamily);
    AddEmailController controller = new AddEmailController(app);

    @Test
    public void checkifEmailAdded() {
        assertTrue(controller.addEmail("test@isep.ipp.pt", 666));
    }


    @Test
    public void checkEmailAlreadyPresent() {
        controller.addEmail("test2@isep.ipp.pt", 666);
        assertFalse(controller.addEmail("test2@isep.ipp.pt", 666));

    }

    @Test
    public void checkIfThrowsWhenNoSuchID() {
        assertThrows(IllegalArgumentException.class, () -> controller.addEmail("test3@isep.ipp.pt", 888));
    }
}