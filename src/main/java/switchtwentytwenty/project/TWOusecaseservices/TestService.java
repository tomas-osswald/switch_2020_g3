package switchtwentytwenty.project.TWOusecaseservices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService implements  TestIService{

    @Autowired
    TestIRepository testRepo;

    public String getNameById(int id) {

        return testRepo.getNameByID(id);
    }
}
