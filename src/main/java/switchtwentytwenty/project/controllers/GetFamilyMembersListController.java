package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.services.FamilyService;
import switchtwentytwenty.project.domain.services.RelationService;


public class GetFamilyMembersListController {
    private final Application ffmApplication;

    public GetFamilyMembersListController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }


    /**
     * Method that obtains the FFMapp, that has the FamilyService as
     * its attribute. Then uses a method of the FamilyService
     * which is the getDTOList, that iterates through the
     * specific family (familyID) obtains the necessary info from its familyMembers
     * and converts it to a DTO, returning it back here to the Controller
     *
     * @param familyID representing the unique ID given to each family
     * @return DTOList with members name and the relation they have towards the Family Administrator
     */
    public boolean getFamilyMembersAndRelation(int familyID, String adminCCNumber) {
        boolean controllerSuccess;
        try {
            FamilyService familyService = this.ffmApplication.getFamilyService();
            RelationService relationService = this.ffmApplication.getRelationService();
            Family targetFamily = familyService.getFamily(familyID);
            if (!targetFamily.verifyAdministrator(adminCCNumber)) {
                controllerSuccess = false;
            } else {
                relationService.getFamilyMembersRelationDTOList(targetFamily);
                controllerSuccess = true;
            }
        } catch (IllegalArgumentException wrongFamilyID) {
            controllerSuccess = false;
        }
        return controllerSuccess;
    }

}

