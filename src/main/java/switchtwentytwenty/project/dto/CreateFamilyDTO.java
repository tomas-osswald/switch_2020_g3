package switchtwentytwenty.project.dto;

import java.time.LocalDate;

public class CreateFamilyDTO {


    private String familyName;
    private String localDate;

    public CreateFamilyDTO(String familyName, String localDate) {
        this.familyName = familyName;
        this.localDate = localDate;

    }


    public String unpackFamilyName() {
        return this.familyName;
    }

    public String unpackLocalDate() {
        return this.localDate;
    }


}
