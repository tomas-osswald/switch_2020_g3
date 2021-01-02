package switch2020.project.utils;

public class FamilyMemberRelationshipDTO {
    private String name;
    private String relationship;

    public FamilyMemberRelationshipDTO (String name, String relationship) {
        this.name = name;
        this.relationship = relationship;
    }

    public String getName() {
        return name;
    }

    public String getRelationship() {
        return relationship;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FamilyMemberRelationshipDTO)) {
            return false;
        }

        FamilyMemberRelationshipDTO that = (FamilyMemberRelationshipDTO) o;

        if (name != null ? !name.equals(that.name) : that.name != null) {
            return false;
        }
        return relationship != null ? relationship.equals(that.relationship) : that.relationship == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (relationship != null ? relationship.hashCode() : 0);
        return result;
    }
}
