package switch2020.project.controllers;

import org.junit.jupiter.api.Test;
import switch2020.project.model.Application;
import switch2020.project.model.StandardCategory;
import switch2020.project.services.CategoryService;
import switch2020.project.utils.StandardCategoryDTO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class GetStandardCategoriesTreeControllerTest {

    List<StandardCategory> categoriesOne = new ArrayList<>();
    StandardCategory cat1 = new StandardCategory("Alimentação", null,1);
    StandardCategory cat2 = new StandardCategory("Saúde", null,2);
    StandardCategory cat3 = new StandardCategory("Educação", null,3);
    StandardCategory cat4 = new StandardCategory("Diversos", null,4);

/*    GetStandardCategoriesTreeController getStandard = new GetStandardCategoriesTreeController(App);*/


    @Test
    void Controller_Test1() {
        Application app = new Application();
        GetStandardCategoriesTreeController tester = new GetStandardCategoriesTreeController(app);
        app.getCategoryService();



    }
}