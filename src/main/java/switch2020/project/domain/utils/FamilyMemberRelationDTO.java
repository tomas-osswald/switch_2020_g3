package switch2020.project.domain.utils;

public class FamilyMemberRelationDTO {

    // Attributes
    private String name;
    private String relationDesignation;

    // Constructors
    public FamilyMemberRelationDTO(String name, String relationDesignation) {
        this.name = name;
        this.relationDesignation = relationDesignation;
    }

    // Business Methods
    public String getName() {
        return name;
    }

    public String getRelationDesignation() {
        return relationDesignation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof FamilyMemberRelationDTO)) return false;

        FamilyMemberRelationDTO that = (FamilyMemberRelationDTO) o;

        return relationDesignation != null ? relationDesignation.equals(that.relationDesignation) : that.relationDesignation == null;
    }

    /*@Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (relationDesignation != null ? relationDesignation.hashCode() : 0);
        return result;
    }*/
}

