package com.example.animalshelter.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(raquest -> raquest
//                .mvcMatchers("/").permitAll()
////                .mvcMatchers("/register","/confirmation").permitAll()
////                .mvcMatchers("/secured").hasAnyRole("USER","ADMIN")
////                .mvcMatchers("/admin/**").hasRole("ADMIN")
//                .anyRequest().authenticated());
//
//        http.csrf().disable();
//        return http.build();
//    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    WebSecurityCustomizer webSecurityCustomizer(){
        return web -> web.ignoring()
                .mvcMatchers("/css/**","/img/**")
                .antMatchers("/h2-console/**");
    }
}
