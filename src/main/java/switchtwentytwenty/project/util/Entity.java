package switchtwentytwenty.project.util;

public interface Entity <K extends ID> {
    public K id();

    public boolean hasID(ID id);

}
