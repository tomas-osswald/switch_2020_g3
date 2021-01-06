package switch2020.project.utils;

public class FamilyMemberRelationDTO {
    private String name;
    private String relation;

    public FamilyMemberRelationDTO(String name, String relation) {
        this.name = name;
        this.relation = relation;
    }

    public String getName() {
        return name;
    }

    public String getrelation() {
        return relation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FamilyMemberRelationDTO)) {
            return false;
        }

        FamilyMemberRelationDTO that = (FamilyMemberRelationDTO) o;

        if (name != null ? !name.equals(that.name) : that.name != null) {
            return false;
        }
        return relation != null ? relation.equals(that.relation) : that.relation == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (relation != null ? relation.hashCode() : 0);
        return result;
    }
}

