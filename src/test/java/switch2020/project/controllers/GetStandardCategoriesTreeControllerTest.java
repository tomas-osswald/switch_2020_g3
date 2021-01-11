package switch2020.project.controllers;

import switch2020.project.model.Application;
import switch2020.project.model.StandardCategory;

import java.util.ArrayList;
import java.util.List;

class GetStandardCategoriesTreeControllerTest {

    List<StandardCategory> categoriesOne = new ArrayList<>();
    StandardCategory cat1 = new StandardCategory("Alimentação", null,1);
    StandardCategory cat2 = new StandardCategory("Saúde", null,2);
    StandardCategory cat3 = new StandardCategory("Educação", null,3);
    StandardCategory cat4 = new StandardCategory("Diversos", null,4);
    Application App = new Application();
    GetStandardCategoriesTreeController getStandard = new GetStandardCategoriesTreeController(App);

   /* @Test
    void testGetStandardCategories(){
        App.getCategoryService().getStandardCategories();

    } */
}