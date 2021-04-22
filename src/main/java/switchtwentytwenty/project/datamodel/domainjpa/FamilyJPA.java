package switchtwentytwenty.project.datamodel.domainjpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import switchtwentytwenty.project.datamodel.assemblerjpa.FamilyIDJPA;
import switchtwentytwenty.project.datamodel.assemblerjpa.PersonIDJPA;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "families")
public class FamilyJPA {

    @Id
    private FamilyIDJPA id;

    private String familyName;
    private String registrationDate;
    @Column(name = "adminID")
    private PersonIDJPA adminID;


}
