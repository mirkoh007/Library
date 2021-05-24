package com.mirko.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String ROLE_ADMIN = "ADMIN";
    private static final String ROLE_USER = "USER";
    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsServiceImpl) {
        this.userDetailsService = userDetailsServiceImpl;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/library").hasAnyRole(ROLE_ADMIN, ROLE_USER)
                .antMatchers(HttpMethod.GET, "/user", "/user/**", "/library/**", "/bookcopy", "/bookcopy/**").hasRole(ROLE_ADMIN)
                .antMatchers(HttpMethod.POST, "/user", "/library","/book/**", "/bookcopy").hasRole(ROLE_ADMIN)
                .antMatchers(HttpMethod.PUT, "/user/**", "/library/**","/book/add", "/bookcopy/**").hasRole(ROLE_ADMIN)
                .antMatchers(HttpMethod.DELETE, "/user/**", "/library/**", "/bookcopy/**").hasRole(ROLE_ADMIN)
                .antMatchers(HttpMethod.GET,"/h2-console", "/swagger-ui.html#").permitAll()
                .and()
                .csrf().disable()
                .headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

}
