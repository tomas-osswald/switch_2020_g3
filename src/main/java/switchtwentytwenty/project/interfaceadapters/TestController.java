package switchtwentytwenty.project.interfaceadapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import switchtwentytwenty.project.usecaseservices.TestIService;

@RestController
@RequestMapping(value = "/api")
public class TestController implements TestIController{

    @Autowired
    TestIService testServ;

    @RequestMapping(value ="/users", method = RequestMethod.GET)
    public ResponseEntity<Object> getUsers() {
        return new ResponseEntity<>("Mock Data: List of users", HttpStatus.OK);
    }

    @RequestMapping(value ="/user", method = RequestMethod.GET)
    public ResponseEntity<Object> getUser(@RequestParam(value="id") int id){
        String name = testServ.getNameById(id);
        return new ResponseEntity<>("Mock Data: User " + name, HttpStatus.OK);
    }

}
