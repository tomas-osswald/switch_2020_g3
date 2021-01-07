package switch2020.project.controllers;

import org.junit.jupiter.api.Test;
import switch2020.project.model.Application;

class GetStandardCategoriesTreeControllerTest {

    @Test
    void testGetStandardCategories(){
        Application App = new Application();
        GetStandardCategoriesTreeController controller = new GetStandardCategoriesTreeController(App);
    }
}