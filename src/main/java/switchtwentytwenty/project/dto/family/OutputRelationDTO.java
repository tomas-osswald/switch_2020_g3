package switchtwentytwenty.project.dto.family;

import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;

public class OutputRelationDTO extends RepresentationModel<OutputRelationDTO> {

    private String memberOneID;
    private String memberTwoID;
    private String relationDesignation;
    private String relationID;


    public String getMemberOneID() {
        return memberOneID;
    }

    public String getMemberTwoID() {
        return memberTwoID;
    }

    public String getRelationDesignation() {
        return relationDesignation;
    }

    public String getRelationID() {
        return relationID;
    }

    public OutputRelationDTO(String memberOneID, String memberTwoID, String relationDesignation, String relationID) {
        this.memberOneID = memberOneID;
        this.memberTwoID = memberTwoID;
        this.relationDesignation = relationDesignation;
        this.relationID = relationID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OutputRelationDTO that = (OutputRelationDTO) o;
        return memberOneID.equals(that.memberOneID) && memberTwoID.equals(that.memberTwoID) && relationDesignation.equals(that.relationDesignation) && relationID.equals(that.relationID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), memberOneID, memberTwoID, relationDesignation, relationID);
    }

    public void setPersonIDOne(String memberOneID) {
        this.memberOneID = memberOneID;
    }

    public void setPersonIDTwo(String memberTwoID) {
        this.memberTwoID = memberTwoID;
    }

    public void setDesignation(String relationDesignation) {
        this.relationDesignation = relationDesignation;
    }

    public void setRelationID(String relationID) {
        this.relationID = relationID;
    }
}