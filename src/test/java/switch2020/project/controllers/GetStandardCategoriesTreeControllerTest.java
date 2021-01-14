package switch2020.project.controllers;

import org.junit.jupiter.api.Test;
import switch2020.project.model.Application;
import switch2020.project.services.CategoryService;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GetStandardCategoriesTreeControllerTest {

    Application app = new Application();
    CategoryService categoryService = app.getCategoryService();
    GetStandardCategoriesTreeController standardCategoriesTreeController = new GetStandardCategoriesTreeController(app);
    AddStandardCategoryController addStandardCategoryController = new AddStandardCategoryController(app);

    @Test
    void getStandardCategoriesTreeReturnListOneCategory() {
        addStandardCategoryController.addStandardCategory("House", 0);//id 1
        boolean result = standardCategoriesTreeController.getStandardCategoriesTree();
        assertTrue(result);
    }

    @Test
    void getStandardCategoriesTreeReturnListManyCategories() {
        addStandardCategoryController.addStandardCategory("House", 0);//id 1
        addStandardCategoryController.addStandardCategory("Electricity", 1); //id 2
        addStandardCategoryController.addStandardCategory("WatEr", 1);//id 3
        addStandardCategoryController.addStandardCategory("Transport", 0);//id 4
        addStandardCategoryController.addStandardCategory("Car", 4);//id 5
        addStandardCategoryController.addStandardCategory("Public TraNsport", 4);//id 6
        boolean result = standardCategoriesTreeController.getStandardCategoriesTree();
        assertTrue(result);
    }

    @Test
    void getStandardCategoriesTreeReturnEmptyListNoStandardCategoriesException() {
        assertFalse(standardCategoriesTreeController.getStandardCategoriesTree());
    }
}