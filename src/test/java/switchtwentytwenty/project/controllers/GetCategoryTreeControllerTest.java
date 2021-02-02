package switchtwentytwenty.project.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.domain.dtos.input.AddFamilyMemberDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.dtos.output.CategoryTreeDTO;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class GetCategoryTreeControllerTest {

    int testFamilyID = 10;
    String testFamilyName = "Silva";
    Family testFamily = new Family(testFamilyName, testFamilyID);
    Application app = new Application(testFamily);
    AddFamilyMemberController familyMemberController = new AddFamilyMemberController(app);
    AddFamilyAdministratorController familyAdministratorController = new AddFamilyAdministratorController(app);
    GetCategoryTreeController categoryTreeController = new GetCategoryTreeController(app);
    AddStandardCategoryController addStandardCategoryController = new AddStandardCategoryController(app);
    String[] expected = {"OTHER","HOUSE", "ELECTRICITY", "WATER", "TRANSPORT", "CAR", "PUBLIC TRANSPORT", "FUEL", "REPAIRS", "PARKING", "TAXES", "INCOME", "SALES", "GAS", "FOOD", "OTHERS", "GROCERIES", "RESTAURANTS", "BUS", "TAXI"};
    Date birthdate = new Date(1954, 8, 26);
    String adminCC = "000000000ZZ4";
    String cc2 = "137843828ZX3";
    AddFamilyMemberDTO familyMemberDTO = new AddFamilyMemberDTO(adminCC, cc2, "Not Admin", birthdate, 919999999, "abc@gmail.com", 212122233, "Rua Nossa", "4444-555", "Zinde", "Porto", 13);

    @BeforeEach
    public void setup() {
        familyAdministratorController.addFamilyAdministrator(adminCC, "Admin", birthdate, 919999999, "lol@gmail.com", 212122233, "Rua Nossa", "4444-555", "Zinde", "Porto", 10);
        familyMemberController.addFamilyMember(familyMemberDTO);

        addStandardCategoryController.addStandardCategory("House", 0);//id 1
        addStandardCategoryController.addStandardCategory("Electricity", 1); //id 2
        addStandardCategoryController.addStandardCategory("WatEr", 1);//id 3
        addStandardCategoryController.addStandardCategory("Transport", 0);//id 4
        addStandardCategoryController.addStandardCategory("Car", 4);//id 5
        addStandardCategoryController.addStandardCategory("Public TraNsport", 4);//id 6
        addStandardCategoryController.addStandardCategory("Fuel", 5);//id 7
        addStandardCategoryController.addStandardCategory("Repairs", 5);//id 8
        addStandardCategoryController.addStandardCategory("Parking", 5);//id 9
        addStandardCategoryController.addStandardCategory("Taxes", 0);//id 10
        addStandardCategoryController.addStandardCategory("income", 10);//id11
        addStandardCategoryController.addStandardCategory("Sales", 10);//id 12
        addStandardCategoryController.addStandardCategory("Gas", 1);//id 13
        addStandardCategoryController.addStandardCategory("Food", 0);//id 14
        addStandardCategoryController.addStandardCategory("Others", 0);//id 15
        addStandardCategoryController.addStandardCategory("Groceries", 14);//id 16
        addStandardCategoryController.addStandardCategory("restaurants", 14);//id 17
        addStandardCategoryController.addStandardCategory("Bus", 6);//id 18
        addStandardCategoryController.addStandardCategory("Taxi", 6);//id 19

    }

    @Test
    public void compareCategoryTree() {
        CategoryTreeDTO categoryTree = app.getCategoryService().getCategoryTree(10, app.getFamilyService());
        assertArrayEquals(categoryTree.getArrayOfStandardCategoriesNames(), expected);
    }


    @Test
    public void getCategoryTreeTest() {
        assertTrue(categoryTreeController.getCategoryTree(10, adminCC));
    }

    @Test
    public void getCategoryTreeNoFamilyWithThatIDTest() {
        assertFalse(categoryTreeController.getCategoryTree(11, adminCC));

    }

    @Test
    public void getCategoryTreeNotAnAdminTest() {
        assertFalse(categoryTreeController.getCategoryTree(11, cc2));

    }

    @Test
    public void getCategoryTreeNoSuchFamilyMemberID() {
        assertFalse(categoryTreeController.getCategoryTree(10, "137476457tr4"));

    }

}