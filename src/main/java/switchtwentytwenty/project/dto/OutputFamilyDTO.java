package switchtwentytwenty.project.dto;

import org.springframework.hateoas.RepresentationModel;

public class OutputFamilyDTO extends RepresentationModel<OutputFamilyDTO> {

    private String familyName;

    public OutputFamilyDTO(String familyName) {
        this.familyName = familyName;
    }

}