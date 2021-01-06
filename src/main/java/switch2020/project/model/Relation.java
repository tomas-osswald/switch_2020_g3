package switch2020.project.model;

public class Relation {

    private String relationDesignation;

    /**
     * Construtor com obrigatoriedade de ser passado parâmetro de designação da relação. Admite valores null ou "" (String vazia),
     * convertendo esses valores em "relação por definir" como value do atributo relationDesignation (Isto de acordo com a informação
     * do PO que referiu que não há obrigatoriedade de definir relação quando se adiciona um FamilyMember, por serem
     * US diferentes, logo serão funcionalidades distintas).
     * @param relationDesignation
     */
    public Relation(String relationDesignation) {
        if (relationDesignation == null || relationDesignation == ""){
            relationDesignation = "relação por definir";
        }
        this.relationDesignation = relationDesignation;
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

    public String getRelationDesignation() {
        return relationDesignation;
    }
}
