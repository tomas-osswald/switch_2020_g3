package switchtwentytwenty.project.authentication;

import java.util.ArrayList;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//Code adapted from https://www.javainuse.com/spring/boot-jwt
@Service
@Primary
public class JWTUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("tonyze@latinlover.com".equals(username)) {
            return new User("tonyze@latinlover.com", "$2a$10$hMTc9TikPS69ITBUZFZ2gec1lzqvbSVghT5.JSVwt7SZHrBwJRZj2",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
