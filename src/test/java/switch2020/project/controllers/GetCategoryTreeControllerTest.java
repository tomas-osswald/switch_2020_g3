package switch2020.project.controllers;

import org.junit.jupiter.api.Test;
import switch2020.project.model.Application;
import switch2020.project.model.Family;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GetCategoryTreeControllerTest {

    int testFamilyID = 10;
    String testFamilyName = "Silva";
    Family testFamily = new Family(testFamilyName,testFamilyID);
    Application app = new Application(testFamily);
    GetCategoryTreeController categoryTreeController = new GetCategoryTreeController(app);
    AddStandardCategoryController addStandardCategoryController = new AddStandardCategoryController(app);


    public void setup() {
        addStandardCategoryController.addStandardCategory("House", 0);//id 1
        addStandardCategoryController.addStandardCategory("Electricity", 1); //id 2
        addStandardCategoryController.addStandardCategory("Water", 1);//id 3
        addStandardCategoryController.addStandardCategory("Transport", 0);//id 4
        addStandardCategoryController.addStandardCategory("Car", 4);//id 5
        addStandardCategoryController.addStandardCategory("Public Transport", 4);//id 6
        addStandardCategoryController.addStandardCategory("Fuel", 5);//id 7
        addStandardCategoryController.addStandardCategory("Repairs", 5);//id 8
        addStandardCategoryController.addStandardCategory("Parking", 5);//id 9
        addStandardCategoryController.addStandardCategory("Taxes", 0);//id 10
        addStandardCategoryController.addStandardCategory("Income", 10);//id11
        addStandardCategoryController.addStandardCategory("Sales", 10);//id 12
        addStandardCategoryController.addStandardCategory("Gas", 1);//id 13
    }

    @Test
    public void getCategoryTreeTest() {
        setup();
        assertTrue(categoryTreeController.getCategoryTree(10));
    }

    @Test
    public void getCategoryTreeNoFamilyIDTest() {
        setup();
        assertFalse(categoryTreeController.getCategoryTree(11));

    }

}