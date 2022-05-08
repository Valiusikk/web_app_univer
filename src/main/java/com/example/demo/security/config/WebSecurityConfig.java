package com.example.demo.security.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests().antMatchers("/api/auth/registration/**").permitAll()
//                .antMatchers("/api/auth/login/**").permitAll().anyRequest().authenticated().and()
//                .formLogin();
                http.authorizeRequests().
                anyRequest().authenticated()
                .and().formLogin()
                        .loginPage("/login").permitAll();
    }
}
