package switchtwentytwenty.project.domain.valueobject;

import lombok.Getter;

import java.util.Objects;

public class CategoryID implements ID<Long> {
    @Getter
    private final long id;

    public CategoryID(long categoryID) {
        this.id = categoryID;
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

    @Override
    public String toString(){
        return String.valueOf(id);
    }

}
