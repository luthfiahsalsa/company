package com.project.company.security;


import com.project.company.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user1 = User.withUsername("admin@gmail.com")
//                .password(passwordEncoder().encode("12345"))
//                .roles("Admin")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1);
//    }
//
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((request) -> request
                .requestMatchers("/css/**").permitAll()
                .requestMatchers("/user/**").permitAll()
                .requestMatchers("/biodata/view").hasAuthority("Calon Karyawan")
                .requestMatchers("/biodata/addBiodata").hasAuthority("Calon Karyawan")
                .requestMatchers("/biodata/add").hasAuthority("Calon Karyawan")
                .requestMatchers("/biodata/viewAll").hasAuthority("Admin")
              .requestMatchers("/api/v1/**").permitAll()
                .anyRequest().authenticated()
        ).formLogin((form) -> form
                .loginPage("/user/loginForm").permitAll()
                .loginProcessingUrl("/authenticating")
                        .usernameParameter("email")
                .defaultSuccessUrl("/", true)
        ).logout((logout) -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout")
                .permitAll()
        );
        return http.build();
    }

    @Autowired
    private UserDetailsService userDetailsService;

    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}

