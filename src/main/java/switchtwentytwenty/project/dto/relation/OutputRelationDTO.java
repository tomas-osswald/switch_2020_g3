package switchtwentytwenty.project.dto.relation;

import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;

public class OutputRelationDTO extends RepresentationModel<OutputRelationDTO> {

    private String memberOneID;
    private String memberTwoID;
    private String relationDesignation;
    private String familyID;


    public OutputRelationDTO(String memberOneID, String memberTwoID, String relationDesignation, String familyID) {
        this.memberOneID = memberOneID;
        this.memberTwoID = memberTwoID;
        this.relationDesignation = relationDesignation;
        this.familyID = familyID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OutputRelationDTO that = (OutputRelationDTO) o;
        return memberOneID.equals(that.memberOneID) && memberTwoID.equals(that.memberTwoID) && relationDesignation.equals(that.relationDesignation) && familyID.equals(that.familyID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), memberOneID, memberTwoID, relationDesignation, familyID);
    }
}