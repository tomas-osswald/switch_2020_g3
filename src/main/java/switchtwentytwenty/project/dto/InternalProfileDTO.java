package switchtwentytwenty.project.dto;

import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class InternalProfileDTO {

    @Setter
    private String id;

    public String unpackID() {
        return this.id;
    }


}
