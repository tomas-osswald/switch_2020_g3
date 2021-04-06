package switchtwentytwenty.project.ONEdomain.valueobject;

import java.util.Objects;
import java.util.UUID;

public class CategoryID implements ID<UUID> {

    private UUID categoryID;

    public CategoryID() {
        this.categoryID = UUID.randomUUID();
        //validateID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryID)) return false;
        CategoryID that = (CategoryID) o;
        return categoryID.equals(that.categoryID);
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
