package switchtwentytwenty.project.datamodel.domainjpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import switchtwentytwenty.project.datamodel.assemblerjpa.FamilyIDJPA;
import switchtwentytwenty.project.datamodel.assemblerjpa.PersonIDJPA;

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
    private PersonIDJPA adminID;

    public FamilyJPA(FamilyIDJPA id, String familyName, String registrationDate, PersonIDJPA adminID) {
        this.id = id;
        this.familyName = familyName;
        this.registrationDate = registrationDate;
        this.adminID = adminID;
    }


}
