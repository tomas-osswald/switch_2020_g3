package switchtwentytwenty.project.dto.family;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import switchtwentytwenty.project.dto.person.FamilyMemberAndRelationsDTO;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class FamilyMemberAndRelationsListDTO extends RepresentationModel<FamilyMemberAndRelationsListDTO> {

    List<FamilyMemberAndRelationsDTO> familyMemberAndRelationsDTO = new ArrayList<>();


    public void addDTO(FamilyMemberAndRelationsDTO familyMemberAndRelationsDTO) {
        this.familyMemberAndRelationsDTO.add(familyMemberAndRelationsDTO);
    }


}
