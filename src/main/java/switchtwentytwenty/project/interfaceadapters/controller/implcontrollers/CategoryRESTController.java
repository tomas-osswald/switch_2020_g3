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
import switchtwentytwenty.project.dto.category.CreateStandardCategoryDTO;
import switchtwentytwenty.project.dto.category.InputCategoryDTO;
import switchtwentytwenty.project.dto.category.OutputCategoryDTO;
import switchtwentytwenty.project.dto.category.OutputCategoryTreeDTO;
import switchtwentytwenty.project.interfaceadapters.controller.icontrollers.ICategoryRESTController;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICategoriesOptionsService;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICreateStandardCategoryService;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IGetStandardCategoryTreeService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/categories")
@CrossOrigin
public class CategoryRESTController implements ICategoryRESTController {

    private final ICreateStandardCategoryService createStandardCategoryService;

    private final ICategoriesOptionsService categoriesOptionsService;

    private final ICategoryDTODomainAssembler categoryAssembler;

    private final IGetStandardCategoryTreeService getStandardCategoryTreeService;

    @Autowired
    public CategoryRESTController(ICreateStandardCategoryService createStandardCategoryService, ICategoriesOptionsService categoryOptionsService, IGetStandardCategoryTreeService getStandardCategoryTreeService ) {
        this.createStandardCategoryService = createStandardCategoryService;
        this.categoriesOptionsService = categoryOptionsService;
        this.categoryAssembler = new CategoryDTODomainAssembler();
        this.getStandardCategoryTreeService = getStandardCategoryTreeService;

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
            Link selfLink = linkTo(methodOn(CategoryRESTController.class).getCategory(outputCategoryDTO.getCategoryID())).withSelfRel();
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
            OutputCategoryTreeDTO outputCategoryTreeDTO = getStandardCategoryTreeService.getStandardCategoryTree();
            status = HttpStatus.OK;
            Link optionsLinks = linkTo(methodOn(CategoryRESTController.class).categoriesOptions()).withRel("Categories Options");
            outputCategoryTreeDTO.add(optionsLinks);

            return new ResponseEntity(outputCategoryTreeDTO,status);

        } catch(Exception e){
            status = HttpStatus.BAD_REQUEST;

            return new ResponseEntity("Error: " + e.getMessage(),status);
        }

    }
}