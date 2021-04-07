package switchtwentytwenty.project.THREEinterfaceadapters;

import org.springframework.stereotype.Repository;

@Repository
public class TestRepository {

    public String getNameByID(int id) {
        if (id == 150) return "TonyZe";
        else if (id == 100) return "AnaMaria";
        else return "other";
    }


}
