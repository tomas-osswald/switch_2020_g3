package switchtwentytwenty.project.interfaceadapters.controller.ImplControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices.CreateFamilyService;
import switchtwentytwenty.project.dto.AddPersonDTO;
import switchtwentytwenty.project.dto.CreateFamilyDTO;


@Controller
public class CreateFamilyController  {

    @Autowired
    private CreateFamilyService createFamilyService;

    /**
     * Method to create a family and add a person as administrator
     * @param createFamilyDTO
     * @param addPersonDTO
     * @return True if Family successfully created and added. False (by Exception e catch) if anything fails validation. False (by boolean false return on line 24) if admin email is already registered.
     */
    public boolean createFamilyAndAdmin(CreateFamilyDTO createFamilyDTO, AddPersonDTO addPersonDTO) {
        boolean result;
        try {
            createFamilyService.createFamilyAndAddAdmin(createFamilyDTO, addPersonDTO);
            result = true;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
}
