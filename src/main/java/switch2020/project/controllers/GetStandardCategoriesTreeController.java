package switch2020.project.controllers;

import switch2020.project.model.Application;
import switch2020.project.services.CategoryService;
import switch2020.project.utils.StandardCategoryDTO;

import java.util.List;

public class GetStandardCategoriesTreeController {
    private Application ffmApplication;


    public GetStandardCategoriesTreeController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    public List<StandardCategoryDTO> getStandardCategories(){
        CategoryService categoryService = this.ffmApplication.getCategoryService();
        return categoryService.getStandardCategoriesDTOList();
    }
}
