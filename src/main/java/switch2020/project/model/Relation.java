package switch2020.project.model;

public class Relation {

    // Attributes
    private String relationDesignation;

    // Constructors
    public Relation(String relationDesignation) {
        isEmpty(relationDesignation);
        this.relationDesignation = relationDesignation;
    }

    // Business Methods

    /**
     * Method to verify if a given relation designation to instantiate is null or empty
     *
     * @param relationDesignation Relation Designation to instantiate a Relation
     */

    private void isEmpty(String relationDesignation) {
        if (relationDesignation == null || relationDesignation.isBlank() || relationDesignation.isEmpty()) {
            // If is null or empty, a exception is throw
            throw new IllegalArgumentException("Empty or Null relation designation");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Relation)) {
            return false;
        }

        Relation that = (Relation) o;

        return relationDesignation != null ? relationDesignation.equals(that.relationDesignation) : that.relationDesignation == null;
    }

    @Override
    public int hashCode() {
        return relationDesignation != null ? relationDesignation.hashCode() : 0;
    }

    /**
     * Method to get the relation designation of the Relation
     *
     * @return String relation designation
     */

    public String getRelationDesignation() {
        return relationDesignation;
    }

}
