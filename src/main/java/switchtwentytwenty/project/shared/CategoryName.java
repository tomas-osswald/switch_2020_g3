package switchtwentytwenty.project.shared;

import switchtwentytwenty.project.ValueObject;
import switchtwentytwenty.project.exceptions.InvalidNameException;

public class CategoryName implements ValueObject {
    private String name;

    public CategoryName(String name) {
        this.name = name;
        validation();
        trimData();
    }

    private void trimData() {
        this.name.trim();
    }

    private void validation(){
        checkIfNotNull();
        checkIfNotBlank();
        checkIfNotEmpty();
    }

    private void checkIfNotNull(){
        if (this.name == null){
            throw new InvalidNameException("Name cannot be null");
        }
    }

    private void checkIfNotBlank(){
        if (this.name.isEmpty()){
            throw new InvalidNameException("Name cannot be blank");
        }
    }

    private void checkIfNotEmpty(){
        if (this.name.trim().length() == 0){
            throw new InvalidNameException("Name cannot be empty");
        }
    }
}
