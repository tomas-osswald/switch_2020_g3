package switchtwentytwenty.project.dto.person;

import lombok.Getter;
import lombok.Setter;;

import java.util.List;
@Getter
@Setter
public class OutputRemoveEmailDTO {

    private List<String> emailAddresses;

    public OutputRemoveEmailDTO() {
    }
}

