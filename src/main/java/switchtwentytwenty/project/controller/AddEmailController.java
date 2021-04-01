package switchtwentytwenty.project.controller;

import switchtwentytwenty.project.dataaccesslayer.AddEmailService;
import switchtwentytwenty.project.dataaccesslayer.Application;
import switchtwentytwenty.project.dto.AddEmailDTO;

public class AddEmailController {

    private Application application;

    public AddEmailController(Application application) {
        this.application = application;
    }

    public boolean addEmail(AddEmailDTO addEmailDTO){
        boolean result = false;
        AddEmailService addEmailService = new AddEmailService(application);
        result = true;
        try{
            addEmailService.addEmail(addEmailDTO);
        }catch(Exception e){
            result = false;
        }
        return result;
    }

}
