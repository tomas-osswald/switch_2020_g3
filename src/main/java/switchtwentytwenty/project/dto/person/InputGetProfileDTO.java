package switchtwentytwenty.project.dto.person;

import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class InputGetProfileDTO {

    @Setter
    private String id;

    public String unpackID() {
        return this.id;
    }


}
