package switchtwentytwenty.project.interfaceadapters.controller.ImplControllers;

import org.springframework.beans.factory.annotation.Autowired;
import switchtwentytwenty.project.usecaseservices.applicationservices.ImplAppServices.AddEmailService;

import switchtwentytwenty.project.dto.AddEmailDTO;

public class AddEmailController {

    @Autowired
    AddEmailService addEmailService;


    public boolean addEmail(AddEmailDTO addEmailDTO){
        boolean result = true;

        try{
            addEmailService.addEmail(addEmailDTO);
        }catch(Exception e){
            result = false;
        }
        return result;
    }

}