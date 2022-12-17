package com.inventiverhino.rhinosercurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers("/private").authenticated()
                            .anyRequest().permitAll();
                })
                .formLogin(Customizer.withDefaults())
                .build();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        User.UserBuilder builder = User.withDefaultPasswordEncoder();
        UserDetails userDetails = builder.username("user").password("password").authorities(AuthorityUtils.createAuthorityList("USER")).build();
        return new InMemoryUserDetailsManager(userDetails);
    }

}
