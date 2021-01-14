package switch2020.project.utils;

import java.util.ArrayList;
import java.util.List;

public class StandardCategoryDTO {
    private String categoryName;
    private List<StandardCategoryDTO> childs;

    public StandardCategoryDTO(String categoryName) {
        this.categoryName = categoryName;
        this.childs = new ArrayList<StandardCategoryDTO>();
    }

    public void addChild(StandardCategoryDTO dto) {
        this.childs.add(dto);
    }
}
