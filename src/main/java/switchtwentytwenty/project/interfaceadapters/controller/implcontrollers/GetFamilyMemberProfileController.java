package switchtwentytwenty.project.interfaceadapters.controller.implcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import switchtwentytwenty.project.dto.InternalGetProfileDTO;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;
import switchtwentytwenty.project.interfaceadapters.controller.icontrollers.IGetFamilyMemberProfileController;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IGetFamilyMemberProfileService;

@Controller
public class GetFamilyMemberProfileController implements IGetFamilyMemberProfileController {

    @Autowired
    IGetFamilyMemberProfileService getProfileService;

    public OutputPersonDTO getFamilyMemberProfile(InternalGetProfileDTO internalGetProfileDTO){
        OutputPersonDTO outputPersonDTO;

        outputPersonDTO = getProfileService.getFamilyMemberProfile(internalGetProfileDTO);

        return outputPersonDTO;
    }
}