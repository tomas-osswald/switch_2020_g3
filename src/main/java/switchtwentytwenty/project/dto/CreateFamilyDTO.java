package switchtwentytwenty.project.dto;

import java.time.LocalDate;

public class CreateFamilyDTO {


    private String familyName;
    private LocalDate localDate;

    public CreateFamilyDTO(String familyName, LocalDate localDate) {
        this.familyName = familyName;
        this.localDate = localDate;

    }


    public String unpackFamilyName() {
        return this.familyName;
    }

    public LocalDate unpackLocalDate() {
        return this.localDate;
    }


}
