package com.lineauno.security;

import com.lineauno.security.token.FirebaseEntryPoint;
import com.lineauno.security.token.FirebaseFilter;
import com.lineauno.security.token.FirebaseProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    FirebaseEntryPoint entryPoint;

    @Autowired
    FirebaseProvider provider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated();
        http.exceptionHandling().authenticationEntryPoint(entryPoint);
        http.addFilterBefore(new FirebaseFilter(), BasicAuthenticationFilter.class);
        http.authenticationProvider(provider);
        return http.build();
    }
}
