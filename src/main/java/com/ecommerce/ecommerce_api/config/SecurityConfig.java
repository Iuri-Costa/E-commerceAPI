package com.ecommerce.ecommerce_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").permitAll() // apenas teste depois eu tiro, não subir o controller de teste deixa public por enquanto, na proxima task eu mudo aqui rlx
                        .anyRequest().authenticated()
                );

        return http.build();
    }

}
