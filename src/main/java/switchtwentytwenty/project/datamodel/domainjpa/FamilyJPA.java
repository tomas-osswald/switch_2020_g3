package switchtwentytwenty.project.datamodel.domainjpa;

import lombok.Data;
import lombok.NoArgsConstructor;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.domain.valueobject.PersonID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor

@Entity
@Table(name="families")
public class FamilyJPA {

        @Id
        private FamilyID id;
        private String familyName;
        private String registrationDate;
        private PersonID adminID;

    }
