package switchtwentytwenty.project.dto;

import org.springframework.hateoas.Link;

public class ExternalEmailDTO {

    private final String outputEmail;
    private final String link;


    public ExternalEmailDTO (OutputEmailDTO outputEmailDTO, Link link){
        this.outputEmail = outputEmailDTO.toString();
        this.link = link.toString();
    }

    public String unpackEmail(){return this.outputEmail; }

    public String unpackLink() { return this.link; }
}
