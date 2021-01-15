package switch2020.project.domain.utils;

public class FamilyMemberRelationDTO {

    // Attributes
    private final String name;
    private final String relationDesignation;

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

        return this.name.equals(that.name) && this.relationDesignation.equals(that.relationDesignation);
    }

    /*@Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (relationDesignation != null ? relationDesignation.hashCode() : 0);
        return result;
    }*/
}

