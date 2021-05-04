package switchtwentytwenty.project.dto.family;

import java.util.Objects;

public class InputFamilyDTO {


    private String familyName;
    private String localDate;

    public InputFamilyDTO(String familyName, String localDate) {
        this.familyName = familyName;
        this.localDate = localDate;

    }


    public String unpackFamilyName() {
        return this.familyName;
    }

    public String unpackLocalDate() {
        return this.localDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputFamilyDTO that = (InputFamilyDTO) o;
        return familyName.equals(that.familyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(familyName);
    }
}
