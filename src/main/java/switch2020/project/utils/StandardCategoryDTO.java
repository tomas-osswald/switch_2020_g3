package switch2020.project.utils;

import java.util.ArrayList;
import java.util.List;

public class StandardCategoryDTO {
    private String categoryName;
    private List<StandardCategoryDTO> childs;

    public StandardCategoryDTO(String categoryName){
        this.categoryName = categoryName;
        this.childs = new ArrayList<StandardCategoryDTO>();
    }

    public void addChild(StandardCategoryDTO dto) {
        this.childs.add(dto);
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
