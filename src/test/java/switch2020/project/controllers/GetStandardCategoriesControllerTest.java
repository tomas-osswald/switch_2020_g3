package switch2020.project.controllers;

import org.junit.jupiter.api.Test;
import switch2020.project.model.Application;

class GetStandardCategoriesControllerTest {

    @Test
    void testGetStandardCategories(){
        Application App = new Application();
        GetStandardCategoriesController controller = new GetStandardCategoriesController(App);
    }
}