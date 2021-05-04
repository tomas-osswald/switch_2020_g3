package switchtwentytwenty.project.domain.valueobject;

import switchtwentytwenty.project.exceptions.InvalidNameException;

import java.util.Objects;

public class CategoryName implements ValueObject {
    private String name;

    public CategoryName(String name) {
        this.name = name;
        validation();
        trimData();
    }

    private void trimData() {
        this.name = this.name.trim();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryName that = (CategoryName) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
