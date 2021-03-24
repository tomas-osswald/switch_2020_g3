package switchtwentytwenty.project.controller;

import switchtwentytwenty.project.dataaccesslayer.Application;
import switchtwentytwenty.project.dataaccesslayer.CreateFamilyService;
import switchtwentytwenty.project.dto.CreateFamilyDTO;

public class CreateFamilyController {

    private Application application;

    public CreateFamilyController(Application application) {
        this.application = application;
    }

    public boolean createFamilyAndAdmin(CreateFamilyDTO createFamilyDTO) {
        boolean result;
        CreateFamilyService createFamilyService = new CreateFamilyService(createFamilyDTO, application);
        try {
            createFamilyService.createFamilyAndAddAdmin();
            result = true;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
}
