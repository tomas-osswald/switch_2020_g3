package switchtwentytwenty.project.domain.valueobject;

public class RelationID implements ID<Integer>{
    private final int id;

    public RelationID(int relationID) {
        this.id=relationID;
    }
}
