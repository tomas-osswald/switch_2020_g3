package switchtwentytwenty.project.authentication;

import java.io.Serializable;

//Code adapted from https://www.javainuse.com/spring/boot-jwt and https://www.javainuse.com/spring/boot-jwt-mysql

public class JWTResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;

    public JWTResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }
}
