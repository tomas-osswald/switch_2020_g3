package switchtwentytwenty.project.THREEinterfaceadapters;

import org.springframework.http.ResponseEntity;

public interface TestIController {

    public ResponseEntity<Object> getUsers();
    public ResponseEntity<Object> getUser(int id);

}
