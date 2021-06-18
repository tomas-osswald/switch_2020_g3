package switchtwentytwenty.project.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.web.cors.CorsUtils;

//Code adapted from https://www.javainuse.com/spring/boot-jwt and https://www.javainuse.com/spring/boot-jwt-mysql

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private UserDetailsService jwtUserDetailsService;

    @Autowired
    private JWTFilter jwtRequestFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // configure AuthenticationManager so that it knows from where to load
        // user for matching credentials
        // Use BCryptPasswordEncoder
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    CorsFilter corsFilter() {
        CorsFilter filter = new CorsFilter();
        return filter;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // We don't need CSRF for this example
        httpSecurity.csrf().disable()

                // use .authorizeRequests().anyRequest().permitAll() to allow all requests

                // allow the following requests
                .authorizeRequests()
                .antMatchers("/authenticate").permitAll()
                .antMatchers(HttpMethod.GET, "/categories").permitAll()

                // allow requests to these urls if token has familyAdministrator authority
                .antMatchers(HttpMethod.POST, "/people", "/families/{familyID}/relations", "/families/{familyID}/categories").hasAuthority("familyAdministrator")
                .antMatchers(HttpMethod.GET, "/families/{familyID}/relations", "/families/{familyID}/categories", "/families/{familyID}", "/families/{familyID}/categories/{categoryID}").hasAuthority("familyAdministrator")
                .antMatchers(HttpMethod.PATCH, "/families/{familyID}/relations/{relationID}").hasAuthority("familyAdministrator")
                //.antMatchers(HttpMethod.OPTIONS, "/families/{familyID}", "/families/{familyID}/categories").hasAuthority("familyAdministrator")

                // allow requests to these urls if token has either familyMember or familyAdministrator authority
                .antMatchers(HttpMethod.POST, "/people/{personID}/emails", "/accounts").hasAnyAuthority("familyMember", "familyAdministrator")
                .antMatchers(HttpMethod.GET, "/people/{personID}", "/accounts/{accountID}", "/people/{personID}/emails").hasAnyAuthority("familyMember", "familyAdministrator")
                .antMatchers(HttpMethod.DELETE, "/people/{personID}/emails/{email}").hasAnyAuthority("familyMember", "familyAdministrator")
                //.antMatchers(HttpMethod.OPTIONS,"/people", "/people/{personID}").hasAnyAuthority("familyMember", "familyAdministrator")

                // allow requests to these urls if token has systemManager authority
                .antMatchers(HttpMethod.POST, "/families", "/categories").hasAuthority("systemManager")
                .antMatchers(HttpMethod.GET, "/categories/all", "/categories/{categoryID}").hasAuthority("systemManager")
                //.antMatchers(HttpMethod.OPTIONS, "/categories", "/families").hasAuthority("systemManager")

                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                // all other requests need to be authenticated
                .anyRequest().authenticated().and()
                // make sure we use stateless session; session won't be used to
                // store user's state.
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Add a filter to validate the tokens with every request
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class).addFilterBefore(corsFilter(), SessionManagementFilter.class);
        //adds your custom CorsFilter
    }
}
