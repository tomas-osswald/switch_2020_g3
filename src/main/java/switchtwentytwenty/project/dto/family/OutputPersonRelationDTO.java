package switchtwentytwenty.project.dto.family;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
public class OutputPersonRelationDTO {

    private String memberOneID;
    private String memberTwoID;
    private String relationDesignation;
    private String relationID;

    public OutputPersonRelationDTO(String memberOneID, String memberTwoID, String relationDesignation, String relationID) {
        this.memberOneID = memberOneID;
        this.memberTwoID = memberTwoID;
        this.relationDesignation = relationDesignation;
        this.relationID = relationID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutputPersonRelationDTO that = (OutputPersonRelationDTO) o;
        return Objects.equals(memberOneID, that.memberOneID) && Objects.equals(memberTwoID, that.memberTwoID) && Objects.equals(relationDesignation, that.relationDesignation) && Objects.equals(relationID, that.relationID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberOneID, memberTwoID, relationDesignation, relationID);
    }
}