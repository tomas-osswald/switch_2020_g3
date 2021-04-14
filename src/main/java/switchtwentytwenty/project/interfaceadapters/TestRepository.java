package switchtwentytwenty.project.interfaceadapters;

import org.springframework.stereotype.Repository;
import switchtwentytwenty.project.usecaseservices.TestIRepository;

@Repository
public class TestRepository implements TestIRepository {

    public String getNameByID(int id) {
        if (id == 150) return "TonyZe";
        else if (id == 100) return "AnaMaria";
        else return "other";
    }


}
