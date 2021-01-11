package switch2020.project.utils;

public class StandardCategoryDTO {
    private String categoryName;

    public StandardCategoryDTO(String categoryName ){
        this.categoryName = categoryName;
    }


    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StandardCategoryDTO that = (StandardCategoryDTO) o;
        return standardCategory == that.standardCategory && Objects.equals(categoryName, that.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryName, standardCategory);
    }*/
}
