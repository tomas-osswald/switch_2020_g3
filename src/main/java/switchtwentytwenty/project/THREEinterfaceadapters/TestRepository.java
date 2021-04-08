package switchtwentytwenty.project.THREEinterfaceadapters;

import org.springframework.stereotype.Repository;
import switchtwentytwenty.project.TWOusecaseservices.TestIRepository;

@Repository
public class TestRepository implements TestIRepository {

    public String getNameByID(int id) {
        if (id == 150) return "TonyZe";
        else if (id == 100) return "AnaMaria";
        else return "other";
    }


}
