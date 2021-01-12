package switch2020.project.model;

import java.util.HashMap;
import java.util.Map;

public class CategoryMap {
    private Map<String, String> categoryRelation ;

    public CategoryMap() {
        this.categoryRelation = new HashMap<String, String>();
    }

    public void addToMap(String parent, String child){
        this.categoryRelation.put(parent, child);
    }
}
