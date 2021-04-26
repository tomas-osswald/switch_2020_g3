package switchtwentytwenty.project.interfaceadapters.controller.ImplControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import switchtwentytwenty.project.dto.AddEmailDTO;
import switchtwentytwenty.project.interfaceadapters.controller.IControllers.IAddEmailController;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IAddEmailService;

@Controller
public class AddEmailController implements IAddEmailController {

    @Autowired
    IAddEmailService addEmailService;


    public boolean addEmail(AddEmailDTO addEmailDTO) {
        boolean result = true;

        try {
            addEmailService.addEmail(addEmailDTO);
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

}