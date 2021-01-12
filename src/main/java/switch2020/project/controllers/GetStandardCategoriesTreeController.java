package switch2020.project.controllers;

import switch2020.project.model.Application;
import switch2020.project.model.CategoryMap;
import switch2020.project.services.CategoryService;


public class GetStandardCategoriesTreeController {
    private Application App;


    public GetStandardCategoriesTreeController(Application app) {
        this.App = app;
    }

    /*public boolean getStandardCategoriesList(){
        CategoryService categoryService = this.App.getCategoryService();
        try {
            List<StandardCategory> standardCategory = categoryService.cloneOfStandardCategoriesList();
            return true;
        } catch (Exception e){
            return false;
        }*/

    public CategoryMap getStandardCategories(){
        CategoryService categoryService = this.App.getCategoryService();
        return categoryService.getStandardCategoriesDTOList();

    }

}
