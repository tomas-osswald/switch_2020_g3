package switchtwentytwenty.project.domain.valueobject;

import java.util.Objects;

public class Designation {

    private String designation;

    //TODO: Add validation of null or empty String
    public Designation(String designation) {
        this.designation = designation;
    }

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

    public String toString(){
        return this.designation;
    }
}