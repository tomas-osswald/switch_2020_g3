package switch2020.project.controllers;

import org.junit.jupiter.api.Test;
import switch2020.project.model.Application;
import switch2020.project.model.StandardCategory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GetStandardCategoriesTreeControllerTest {

    Application App = new Application();
    GetStandardCategoriesTreeController standardCategoriesTreeController = new GetStandardCategoriesTreeController(App);

    @Test
    public void Controller_Test1() {
        List<StandardCategory> stdCategoriesOne = new ArrayList<>();
        StandardCategory cat1 = new StandardCategory("Casa", 0);
        StandardCategory cat2 = new StandardCategory("Saude", 0);
        StandardCategory cat3 = new StandardCategory("Educacao", 0);
        stdCategoriesOne.add(cat1);
        stdCategoriesOne.add(cat2);
        stdCategoriesOne.add(cat3);
        assertTrue(standardCategoriesTreeController.getStandardCategoriesList());
    }
}