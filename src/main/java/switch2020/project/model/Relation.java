package switch2020.project.model;

public class Relation {
    private String relationDesignation;

    public Relation(String relationDesignation) {
        isEmpty(relationDesignation);

        this.relationDesignation = relationDesignation;
    }

    /**
     * Method to get relation designation of Relation
     *
     * @return
     */

    protected String getRelationDesignation() {
        return this.relationDesignation;
    }

    /**
     * Method to verify if a given relation designation to instantiate is null or empty
     *
     * @param relationDesignation Relation Designation to instantiate a Relation
     */

    private void isEmpty(String relationDesignation) {
        if (relationDesignation == null || relationDesignation.equals(""))
            // If is null or empty, a exception is throw
            throw new IllegalArgumentException("Empty or Null relation designation");
    }

}
