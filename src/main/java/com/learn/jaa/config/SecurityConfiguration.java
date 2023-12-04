package com.learn.jaa.config;

import org.springframework.context.annotation.*;
import org.springframework.core.annotation.*;
import org.springframework.security.config.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.provisioning.*;
import org.springframework.security.web.*;
import org.springframework.security.web.util.matcher.*;

/**
 * @author Krishna Chaitanya
 */
@EnableWebSecurity(debug = true)
@Configuration
public class SecurityConfiguration {

    @Bean
    @Order(1)
    public SecurityFilterChain orderFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .securityMatcher("/order/**")
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()
                )
                .userDetailsService(orderUserDetailsService())
                .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }

    @Bean
    UserDetailsService orderUserDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withDefaultPasswordEncoder().username("order").password("12345").build()
        );
    }

    @Bean
    @Order(2)
    public SecurityFilterChain restaurantFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .securityMatchers(matchers -> matchers
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/restaurant/**"))
                )
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()
                )
                .userDetailsService(
                        new InMemoryUserDetailsManager(
                                User.withDefaultPasswordEncoder().username("restaurant").password("98765").build()
                        )
                )
                .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }

    @Bean
    public SecurityFilterChain rootFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .securityMatcher("/**")
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()
                )
                .userDetailsService(
                        new InMemoryUserDetailsManager(
                                User.withDefaultPasswordEncoder().username("user").password("abcde").build()
                        )
                )
                .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }

}
