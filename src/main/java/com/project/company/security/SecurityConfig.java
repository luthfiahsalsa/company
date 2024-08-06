package com.project.company.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((request) -> request
                .requestMatchers("/css/**").permitAll()
                        .requestMatchers("/user/**").permitAll()
                        .requestMatchers("/api/v1/**").permitAll()
//                .requestMatchers("/delivery/",
//                        "/category/upsertForm",
//                        "/category/delete",
//                        "/region/upsertForm",
//                        "/region/delete",
//                        "/region/assignDetailForm",
//                        "/region/deleteDetail",
//                        "/salesman/upsertForm",
//                        "/salesman/delete",
//                        "/salesman/assignDetailForm",
//                        "/salesman/deleteDetail").hasAuthority("Administrator")
//                .requestMatchers("/customer/",
//                        "/static/resources/image/product/upsertForm",
//                        "/static/resources/image/product/delete").hasAnyAuthority("Administrator", "Salesman")
//                .requestMatchers("/order/**").hasAnyAuthority("Administrator", "Finance")
                .anyRequest().authenticated()
        ).formLogin((form) -> form
                .loginPage("/user/loginForm").permitAll()
                .loginProcessingUrl("/authenticating")
        ).logout((logout) -> logout
                .logoutUrl("/logout")
                .permitAll()
        );
        return http.build();
    }
}

