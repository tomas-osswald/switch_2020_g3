package switchtwentytwenty.project.controller;

import switchtwentytwenty.project.dataaccesslayer.AddPersonService;
import switchtwentytwenty.project.dataaccesslayer.Application;
import switchtwentytwenty.project.dto.AddPersonDTO;

public class AddPersonController {

    private Application application;

    public AddPersonController(Application application) {
        this.application = application;
    }

    public boolean addPerson(AddPersonDTO addPersonDTO) {
        boolean result;
        AddPersonService addPersonService = new AddPersonService(addPersonDTO, application);
        try {
            addPersonService.addPerson();
            result = true;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
}
