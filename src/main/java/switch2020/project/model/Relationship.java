package switch2020.project.model;

public class Relationship {

    private String designation;

    /**
     * Construtor com obrigatoriedade de ser passado parâmetro de designação da relação. Admite valores null ou "" (String vazia),
     * convertendo esses valores em "relação por definir" como value do atributo designation (Isto de acordo com a informação
     * do PO que referiu que não há obrigatoriedade de definir relação quando se adiciona um FamilyMember, por serem
     * US diferentes, logo serão funcionalidades distintas).
     * @param designation
     */
    public Relationship (String designation) {
        if (designation == null || designation == ""){
            designation = "relação por definir";
        }
        this.designation = designation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Relationship)) {
            return false;
        }

        Relationship that = (Relationship) o;

        return designation != null ? designation.equals(that.designation) : that.designation == null;
    }

    @Override
    public int hashCode() {
        return designation != null ? designation.hashCode() : 0;
    }


    public String getDesignation() {
        return designation;
    }
}
