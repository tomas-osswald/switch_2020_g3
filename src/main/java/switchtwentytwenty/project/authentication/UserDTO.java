package switchtwentytwenty.project.authentication;

//Code adapted from https://www.javainuse.com/spring/boot-jwt and https://www.javainuse.com/spring/boot-jwt-mysql

public class UserDTO {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
