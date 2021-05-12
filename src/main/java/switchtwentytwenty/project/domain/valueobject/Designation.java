package switchtwentytwenty.project.domain.valueobject;

import java.util.Objects;

public class Designation {

    private String designation;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Designation that = (Designation) o;
        return Objects.equals(designation, that.designation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(designation);
    }

    public Designation(String designation) {
        this.designation = designation;
    }
}