package switchtwentytwenty.project.dto;

import java.util.Objects;

//TODO e que tal: criar uma Interface de DTOs para nao ficarmos presos a um só DTO quando implementamos?
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
