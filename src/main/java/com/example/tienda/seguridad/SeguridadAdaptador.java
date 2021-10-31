package com.example.tienda.seguridad;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeguridadAdaptador extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(a -> a
                .antMatchers("/", "/error", "/webjars/**,",
                        "/api/**").permitAll()
                .anyRequest().authenticated()
        );

        http.cors().and().csrf().disable();
    }
}
