package switchtwentytwenty.project.interfaceadapters.controller.ImplControllers;

import switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices.AddEmailService;

import switchtwentytwenty.project.dto.AddEmailDTO;

public class AddEmailController {





    public boolean addEmail(AddEmailDTO addEmailDTO){
        boolean result = false;
        //TODO: autowire de addEmailService
        AddEmailService addEmailService = null;
        result = true;
        try{
            addEmailService.addEmail(addEmailDTO);
        }catch(Exception e){
            result = false;
        }
        return result;
    }

}
