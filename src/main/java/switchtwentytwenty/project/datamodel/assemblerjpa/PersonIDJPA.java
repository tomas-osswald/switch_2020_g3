package switchtwentytwenty.project.datamodel.assemblerjpa;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.io.Serializable;

@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class PersonIDJPA implements Serializable {

    private String personID;

    public PersonIDJPA(String personID) {
        this.personID = personID;
    }


}
