package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import switchtwentytwenty.project.dto.OptionsDTO;
import switchtwentytwenty.project.dto.assemblers.iassemblers.ICategoryDTODomainAssembler;
import switchtwentytwenty.project.dto.assemblers.implassemblers.CategoryDTODomainAssembler;
import switchtwentytwenty.project.dto.category.CategoryTreeDTO;
import switchtwentytwenty.project.dto.category.CreateStandardCategoryDTO;
import switchtwentytwenty.project.dto.category.InputCategoryDTO;
import switchtwentytwenty.project.dto.category.OutputCategoryDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICategoriesOptionsService;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICreateStandardCategoryService;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IGetStandardCategroyTreeService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/categories")
@CrossOrigin
public class CategoryRESTController {

    private final ICreateStandardCategoryService createStandardCategoryService;

    private final ICategoriesOptionsService categoriesOptionsService;

    private final ICategoryDTODomainAssembler categoryAssembler;

    private final IGetStandardCategroyTreeService getStandardCategroyTreeService;

    @Autowired
    public CategoryRESTController(ICreateStandardCategoryService createStandardCategoryService, ICategoriesOptionsService categoryOptionsService, IGetStandardCategroyTreeService getStandardCategroyTreeService ) {
        this.createStandardCategoryService = createStandardCategoryService;
        this.categoriesOptionsService = categoryOptionsService;
        this.categoryAssembler = new CategoryDTODomainAssembler();
        this.getStandardCategroyTreeService = getStandardCategroyTreeService;

    }

    /**
     * Controller method to create a standard category
     *
     * @param createStandardCategoryDTO Input dto for the creation of the standard category, includes category designation and parentID fields
     * @return Response entity with Http status 201 if created and status 422 if unable to create the category
     */
    @PostMapping
    public ResponseEntity<OutputCategoryDTO> createStandardCategory(@RequestBody CreateStandardCategoryDTO createStandardCategoryDTO) {
        InputCategoryDTO inputCategoryDTO = categoryAssembler.toInputCategoryDTO(createStandardCategoryDTO);

        HttpStatus status;
        OutputCategoryDTO outputCategoryDTO;

        try {
            outputCategoryDTO = createStandardCategoryService.createStandardCategory(inputCategoryDTO);
            status = HttpStatus.CREATED;
            Link selfLink = linkTo(methodOn(CategoryRESTController.class).getCategory(outputCategoryDTO.getCategoryID().toString())).withSelfRel();
            outputCategoryDTO.add(selfLink);
            return new ResponseEntity<>(outputCategoryDTO, status);

        } catch (Exception e) {
            status = HttpStatus.UNPROCESSABLE_ENTITY;

            return new ResponseEntity("Error: " + e.getMessage(), status);

        }
    }

    /**
     * Controller method to return the options for the Categories collection
     *
     * @return A Response Entity containing the links, methods allowed and the status code 200
     */
    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<OptionsDTO> categoriesOptions() {

        OptionsDTO options = categoriesOptionsService.getCategoriesOptions();

        HttpHeaders header = new HttpHeaders();
        header.set("Allow", "POST, OPTIONS");

        return new ResponseEntity(options, header, HttpStatus.OK);
    }

    //TODO: Method to return data from one Standard Category
    @GetMapping("/{categoryID}")
    public ResponseEntity<Object> getCategory(@PathVariable String categoryID) {
        throw new UnsupportedOperationException();
    }

    @GetMapping()
    public ResponseEntity<Object> getCategoryTree(){

        HttpStatus status;
        try {
            CategoryTreeDTO categoryTreeDTO = getStandardCategroyTreeService.getStandardCategoryTree();
            status = HttpStatus.CREATED;
            //Link selfLink = linkTo(methodOn(CategoryRESTController.class));

            return new ResponseEntity(categoryTreeDTO,status);

        } catch(Exception e){
            status = HttpStatus.UNPROCESSABLE_ENTITY;

            return new ResponseEntity("Error: " + e.getMessage(),status);
        }

    }
}