package switchtwentytwenty.project.dto;

import sun.awt.image.ImageWatched;
import switchtwentytwenty.project.dto.OutputEmailDTO;
import org.springframework.hateoas.Link;

public class ExternalEmailDTO {

    private final String outputEmail;
    private final String link;


    public ExternalEmailDTO (OutputEmailDTO outputEmailDTO, Link link){
        this.outputEmail = outputEmailDTO.toString();
        this.link = link.toString();
    }
}
