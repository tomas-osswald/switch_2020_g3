package switchtwentytwenty.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.Link;

import javax.persistence.Embedded;

@NoArgsConstructor
@AllArgsConstructor
public class ExternalEmailDTO {

    @Getter
    @Setter
    private String outputEmail;
    private String link;


    public String unpackEmail(){return this.outputEmail; }

    public String unpackLink() { return this.link; }
}
