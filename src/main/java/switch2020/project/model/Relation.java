package switch2020.project.model;

public class Relation {
    private String relationDesignation;

    protected Relation(String relationDesignation) {
        isEmpty(relationDesignation);

        this.relationDesignation = relationDesignation;
    }

    /**
     *
     * @return
     */

    protected String getRelationDesignation() {
        return this.relationDesignation;
    }

    /**
     *
     * @param relationDesignation
     */

    private void isEmpty(String relationDesignation) {
        if (relationDesignation == null || relationDesignation.equals(""))
            throw new IllegalArgumentException("Empty or Null relation designation");
    }

}
