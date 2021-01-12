package switch2020.project.utils;

import switch2020.project.model.StandardCategory;

import java.util.ArrayList;
import java.util.List;

public class StandardCategoryDTO {
    private String categoryName;
    private List<StandardCategoryDTO> childs = new ArrayList<StandardCategoryDTO>();

    public StandardCategoryDTO(String categoryName, StandardCategoryDTO parentCategory , StandardCategoryDTO child ){
        this.categoryName = categoryName;
        this.childs.add(StandardCategoryDTO);
    }

    public addToChilds(){

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
