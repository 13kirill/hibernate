package ru.netology.hibernate.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Kirill").password("{noop}Kirill123").authorities("read", "write")
                .and()
                .withUser("test").password("{noop}test123").authorities("read");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeRequests().antMatchers("/persons/by-city").permitAll()
                .and()
                .authorizeRequests().antMatchers("/persons/by-age").hasAuthority("write")
                .and()
                .authorizeRequests().antMatchers("/persons/by-name-and-surname").hasAuthority("read")
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }
}
