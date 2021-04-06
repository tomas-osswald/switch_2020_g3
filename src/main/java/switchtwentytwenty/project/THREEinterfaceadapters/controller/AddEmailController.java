package switchtwentytwenty.project.THREEinterfaceadapters.controller;

import switchtwentytwenty.project.TWOusecaseservices.applicationservices.AddEmailService;
import switchtwentytwenty.project.Application;
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
