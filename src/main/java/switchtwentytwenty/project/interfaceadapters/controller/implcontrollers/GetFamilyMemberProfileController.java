package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import switchtwentytwenty.project.dto.InternalProfileDTO;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;
import switchtwentytwenty.project.interfaceadapters.controller.icontrollers.IGetFamilyMemberProfileController;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IGetFamilyMemberProfileService;

@Controller
public class GetFamilyMemberProfileController implements IGetFamilyMemberProfileController {

    @Autowired
    IGetFamilyMemberProfileService getProfileService;

    public OutputPersonDTO getFamilyMemberProfile(InternalProfileDTO internalProfileDTO){
        OutputPersonDTO outputPersonDTO;

        outputPersonDTO = getProfileService.getFamilyMemberProfile(internalProfileDTO);

        return outputPersonDTO;
    }
}