package com.gianfcop.ssd.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.csrf.CookieServerCsrfTokenRepository;

@Configuration
public class SecurityConfig {

   @Bean
   public SecurityWebFilterChain springSecurityFilterChain ( ServerHttpSecurity http) {

        http
            .csrf().disable()
            //.csrf(csrf -> csrf.csrfTokenRepository(CookieServerCsrfTokenRepository.withHttpOnlyFalse()))
            .authorizeExchange()
                .pathMatchers("/index", "/images/**").permitAll()


            .pathMatchers("/prenotazioni/**").hasRole("USER")
            .pathMatchers("/centro-sportivo/**").hasRole("ADMIN")
            .pathMatchers("strutture/**").hasRole("ADMIN")
            .anyExchange()
            .authenticated()
         .and()
            .oauth2Login(); // to redirect to oauth2 login page.

      return http.build();
   }

   

}