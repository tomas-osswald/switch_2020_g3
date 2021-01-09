package switch2020.project.controllers;

import org.junit.jupiter.api.Test;
import switch2020.project.model.Application;
import switch2020.project.model.Category;

import java.util.ArrayList;
import java.util.List;

class GetStandardCategoriesTreeControllerTest {

    List<Category> categoriesOne = new ArrayList<>();
    Category cat1 = new Category("Alimentação", 0);
    Category cat2 = new Category("Saúde", 0);
    Category cat3 = new Category("Educação", 0);
    Category cat4 = new Category("Diversos", 0);
    Application App = new Application();
    GetStandardCategoriesTreeController getStandard = new GetStandardCategoriesTreeController(App);

   /* @Test
    void testGetStandardCategories(){
        App.getCategoryService().getStandardCategories();

    } */
}