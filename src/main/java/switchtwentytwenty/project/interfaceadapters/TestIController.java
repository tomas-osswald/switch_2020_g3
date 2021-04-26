package switchtwentytwenty.project.interfaceadapters;

import org.springframework.http.ResponseEntity;

public interface TestIController {

    ResponseEntity<Object> getUsers();
    ResponseEntity<Object> getUser(int id);

}
