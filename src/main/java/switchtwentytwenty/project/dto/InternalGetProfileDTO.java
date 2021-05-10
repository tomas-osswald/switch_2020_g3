package switchtwentytwenty.project.dto;

import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class InternalGetProfileDTO {

    @Setter
    private String id;

    public String unpackID() {
        return this.id;
    }


}
