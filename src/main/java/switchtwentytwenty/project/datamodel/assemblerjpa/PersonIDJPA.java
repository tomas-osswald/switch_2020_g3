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

    private String id;

    public PersonIDJPA(String id) {
        this.id = id;
    }


}
