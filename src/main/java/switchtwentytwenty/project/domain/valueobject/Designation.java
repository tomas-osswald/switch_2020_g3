package switchtwentytwenty.project.domain.valueobject;

import java.util.Objects;

public class Designation {

    private String designation;


    public Designation(String designation) {
        validateDesignation(designation);
        this.designation = designation;
    }

    private void validateDesignation(String designation) {
        if(designation==null || designation.trim().length()==0){
            throw new IllegalArgumentException("Designation can't be null or empty");
        }
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