package switchtwentytwenty.project.dto.person;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class InputGetProfileDTO {

    @Setter
    private String id;

    public String unpackID() {
        return this.id;
    }


}
