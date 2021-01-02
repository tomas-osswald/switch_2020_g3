package switch2020.project.model;


public class FamilyMember {

    private String name;
    private Relationship relationship;
    private int memberId;

    /**
     * Para efeitos de teste da US 104 (Obter lista de membros e relacionamento) só tem estes dois parâmetros
     * não nulos no familyMember. A US 101 é que irá implementar a funcionalidade de invocar o construtor de FamilyMember
     * e consequentemente criar objetos deste tipo.
     * @param name
     * @param relationship
     */
    public FamilyMember (String name, Relationship relationship, int memberId){
    if (name == null){
        throw new IllegalArgumentException("Nome não pode ser nulo");
    }
        this.name = name;
        this.relationship = relationship;
    }

    public String getRelationship(){
        return relationship.getDesignation();
    }

    public String getName() {
        return name;
    }
}
