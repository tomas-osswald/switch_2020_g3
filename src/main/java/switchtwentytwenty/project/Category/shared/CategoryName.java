package switchtwentytwenty.project.Category.shared;

import switchtwentytwenty.project.ValueObject;

public class CategoryName implements ValueObject {
    private final String categoryName;

    public CategoryName(String categoryName) {
        this.categoryName = categoryName;
        validateName();
    }

    private void validateName(){
        checkNull();
        checkEmpty();
        checkBlank();
    }

    private void checkNull(){
        if (this.categoryName==null){
            throw new IllegalArgumentException("Name is Null");
        }
    }

    private void checkEmpty(){
        if (this.categoryName.isEmpty()){
            throw new IllegalArgumentException("Name is Empty");
        }
    }

    private void checkBlank(){
        if (this.categoryName.trim().length()==0){
            throw new IllegalArgumentException("Name is Blank");
        }
    }

    public String getName() {
        return name;
    }
}
