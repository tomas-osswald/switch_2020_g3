package switch2020.project.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import switch2020.project.model.Application;
import switch2020.project.model.Family;
import switch2020.project.model.StandardCategory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GetCategoryTreeControllerTest {

    Family testFamily = new Family(10);
    Application app = new Application(testFamily);
    GetCategoryTreeController categoryTreeController = new GetCategoryTreeController(app);
    AddStandardCategoryController addStandardCategoryController = new AddStandardCategoryController(app);
    List<StandardCategory> expected = new ArrayList();


    @BeforeEach
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

        StandardCategory house = new StandardCategory("House", 1);
        expected.add(house);
        StandardCategory elec = new StandardCategory("Electricity", house, 2);
        expected.add(elec);
        StandardCategory water = new StandardCategory("Water", house, 3);
        expected.add(water);
        StandardCategory transport = new StandardCategory("Transport", 4);
        expected.add(transport);
        StandardCategory car = new StandardCategory("Car", transport, 5);
        expected.add(car);
        StandardCategory publicTransport = new StandardCategory("Public Transport", transport, 6);
        expected.add(publicTransport);
        StandardCategory fuel = new StandardCategory("Fuel", car, 7);
        expected.add(fuel);
        StandardCategory repairs = new StandardCategory("Repairs", car, 8);
        expected.add(repairs);
        StandardCategory park = new StandardCategory("Parking", car, 9);
        expected.add(park);
        StandardCategory taxes = new StandardCategory("Taxes", 10);
        expected.add(taxes);
        StandardCategory income = new StandardCategory("Income", taxes, 11);
        expected.add(income);
        StandardCategory sales = new StandardCategory("Sales", taxes, 12);
        expected.add(sales);
        StandardCategory gas = new StandardCategory("Gas", house, 13);
        expected.add(gas);
    }
    /*
    @Test
    public void compareCategoryTree(){
        CategoryTreeDTO categoryTree = app.getCategoryService().getCategoryTree(10,app.getFamilyService());
        List<StandardCategory> result = categoryTree.getStandardCategories();
        assertArrayEquals(expected,result);
    }
    */

    @Test
    public void getCategoryTreeTest() {
        assertTrue(categoryTreeController.getCategoryTree(10));
    }

    @Test
    public void getCategoryTreeNoFamilyIDTest() {
        assertFalse(categoryTreeController.getCategoryTree(11));

    }

}