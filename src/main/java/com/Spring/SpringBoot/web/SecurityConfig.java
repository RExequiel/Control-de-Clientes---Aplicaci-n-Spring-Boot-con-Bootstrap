package com.Spring.SpringBoot.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /* @Bean
      public UserDetailsService userDetailsService() {
            UserDetails admin =
                    User.withUsername("admin")
                            .password("{noop}password")
                            .roles("ADMIN","USER")
                            .build();
            UserDetails user =
                    User.withUsername("user")
                            .password("{noop}password-user")
                            .roles("USER")
                            .build();

            return new InMemoryUserDetailsManager(admin, user);
      }*/

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .authorizeHttpRequests((requests) -> requests
                            .requestMatchers("/agregar/**", "/editar/**","/eliminar/**","/guardar/**")
                            .hasRole("ADMIN")
                                .requestMatchers("/")
                                .hasAnyRole("ADMIN","USER")
                    )
                    .formLogin((form) -> form
                            .loginPage("/login")
                            .permitAll()
                    )
                    .logout((logout) -> logout.permitAll());

            return http.build();
    }
}