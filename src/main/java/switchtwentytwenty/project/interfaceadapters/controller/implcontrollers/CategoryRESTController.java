package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICreateStandardCategoryService;

@RestController
@RequestMapping("/categories")
@CrossOrigin
public class CategoryRESTController {

    private ICreateStandardCategoryService createStandardCategoryService;


}