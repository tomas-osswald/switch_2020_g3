package switchtwentytwenty.project.shared;

public interface Entity <K extends ID> {
    public K id();

    public boolean hasID(ID id);

}
