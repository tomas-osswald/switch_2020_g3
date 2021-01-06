package switch2020.project.model;


public class FamilyMember {

    private String name;
    private Relation relation;
    private int memberId;

    /**
     * Para efeitos de teste da US 104 (Obter lista de membros e relacionamento) só tem estes dois parâmetros
     * não nulos no familyMember. A US 101 é que irá implementar a funcionalidade de invocar o construtor de FamilyMember
     * e consequentemente criar objetos deste tipo.
     * @param name
     * @param relation
     */
    public FamilyMember (String name, Relation relation, int memberId){
    if (name == null){
        throw new IllegalArgumentException("Nome não pode ser nulo");
    }
        this.name = name;
        this.relation = relation;
    }

    public String getRelation(){
        return relation.getRelationDesignation();
    }

    public String getName() {
        return name;
    }
}
