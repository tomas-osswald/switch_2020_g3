package switchtwentytwenty.project.domain.valueobject;

import java.util.Objects;

public class CategoryID implements ID<Long> {

    private long categoryID;

    public CategoryID(long categoryID) {
        this.categoryID = categoryID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryID)) return false;
        CategoryID that = (CategoryID) o;
        return categoryID == that.categoryID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryID);
    }

    /*
    private void validateID(){
        if(!isIDValid()){
            throw new IllegalArgumentException("Invalid ID");
        }
    }

    private boolean isIDValid(){
        return this.categoryID<1;
    }

    public boolean isThisYourID(UUID categoryID){
        boolean result = false;
        if (this.categoryID == categoryID){
            return result;
        }
        return result;
    };

    */
}
