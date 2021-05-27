package io.javabrains.springbootsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Behind the things the Spring Security is using Filters from servlet technology.
 * It allows request to block requests. Filters apply to the set of requests
 * and are called before each servlet process the request. That is why we can and should
 * apply to the set of URLs based on ROLES.
 * We assign to each authenticated user a role.
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * Override  to configure user Authentication
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Set your configuration on the auth object
        auth.inMemoryAuthentication()
                .withUser("blah")
                .password("blah")
                .roles("USER")
                .and()
                .withUser("foo")
                .password("foo")
                .roles("ADMIN");
    }

    /**
     * You don’t want to store passwords in clear format!
     * You need to create a @Bean of type PasswordEncoder
     */
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * Override  to configure user autherization resources access
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // start from the most restrictive access role to less restrictive resources and pages
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("ADMIN", "USER")
                .antMatchers("/").permitAll()
                .and().formLogin();
    }
}
