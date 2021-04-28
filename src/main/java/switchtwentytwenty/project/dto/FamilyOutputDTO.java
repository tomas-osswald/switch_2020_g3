package switchtwentytwenty.project.dto;

import org.springframework.hateoas.RepresentationModel;

public class FamilyOutputDTO extends RepresentationModel<FamilyOutputDTO> {
    private String familyName;
    private String familyID;
    private String adminID;

    public FamilyOutputDTO(String familyName, String familyID, String adminID) {
        this.familyName = familyName;
        this.familyID = familyID;
        this.adminID = adminID;

    }

    public String getFamilyName() {
        return familyName;
    }

    public String getAdminID() {
        return adminID;
    }
}