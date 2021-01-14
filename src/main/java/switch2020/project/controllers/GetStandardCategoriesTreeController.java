package switch2020.project.controllers;

import switch2020.project.model.Application;
import switch2020.project.model.StandardCategory;
import switch2020.project.services.CategoryService;
import switch2020.project.utils.StandardCategoryDTO;

import java.util.ArrayList;
import java.util.List;

public class GetStandardCategoriesTreeController {
    private Application app;


    public GetStandardCategoriesTreeController(Application app) {
        this.app = app;
    }

    public boolean getStandardCategoriesTree() {
        CategoryService ser = app.getCategoryService();
        try {
            List<StandardCategoryDTO> stdCats = ser.getStandardCategoriesTree();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
