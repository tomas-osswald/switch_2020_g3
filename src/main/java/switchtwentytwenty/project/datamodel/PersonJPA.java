package switchtwentytwenty.project.datamodel;


import lombok.Data;
import lombok.NoArgsConstructor;
import switchtwentytwenty.project.domain.valueobject.PersonID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor

@Entity
@Table(name="familymembers")
public class PersonJPA {
    @Id
    private PersonID id;
    private String name;

}
