package switchtwentytwenty.project.dto;

import java.util.Objects;

public class InputPersonIDDTO {

    private String id;

    public InputPersonIDDTO(String id) {
        this.id = id;
    }

    public String unpackUserID(){
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InputPersonIDDTO)) return false;
        InputPersonIDDTO that = (InputPersonIDDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
