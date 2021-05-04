package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import switchtwentytwenty.project.dto.family.InputFamilyDTO;
import switchtwentytwenty.project.dto.person.InputPersonDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.ICreateFamilyService;


@Controller
public class CreateFamilyController  {

    final private ICreateFamilyService createFamilyService;

    @Autowired
    public CreateFamilyController(ICreateFamilyService createFamilyService){
        this.createFamilyService = createFamilyService;
    }

    /**
     * Method to create a family and add a person as administrator
     * @param inputFamilyDTO
     * @param inputPersonDTO
     * @return True if Family successfully created and added. False (by Exception e catch) if anything fails validation. False (by boolean false return on line 24) if admin email is already registered.
     */
    public boolean createFamilyAndAdmin(InputFamilyDTO inputFamilyDTO, InputPersonDTO inputPersonDTO) {
        boolean result;
        try {
            createFamilyService.createFamilyAndAddAdmin(inputFamilyDTO, inputPersonDTO);
            result = true;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
}
