package switchtwentytwenty.project.domain.valueobject;

import java.util.Objects;

public class CategoryID implements ID<Long> {

    private final long id;

    public CategoryID(long categoryID) {
        this.id = categoryID;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryID)) return false;
        CategoryID that = (CategoryID) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
