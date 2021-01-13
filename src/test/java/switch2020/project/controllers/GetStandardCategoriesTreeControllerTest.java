package switch2020.project.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import switch2020.project.model.Application;
import switch2020.project.model.StandardCategory;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GetStandardCategoriesTreeControllerTest {

    Application App = new Application();
    GetStandardCategoriesTreeController standardCategoriesTreeController = new GetStandardCategoriesTreeController(App);
    AddStandardCategoryController addStandardCategoryController = new AddStandardCategoryController(App);

    @BeforeEach
    public void setup(){

    }

    @Test
    void getStandardCategoriesList() {

    }

}