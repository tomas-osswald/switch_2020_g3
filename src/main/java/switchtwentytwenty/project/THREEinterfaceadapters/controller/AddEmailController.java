package switchtwentytwenty.project.THREEinterfaceadapters.controller;

import switchtwentytwenty.project.TWOusecaseservices.applicationservices.AddEmailService;

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
