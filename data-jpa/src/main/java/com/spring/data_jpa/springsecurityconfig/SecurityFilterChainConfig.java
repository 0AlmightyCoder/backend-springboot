package com.spring.data_jpa.springsecurityconfig;

import com.spring.data_jpa.jwtsecurityconfig.JWTAuthenticationEntryPoint;
import com.spring.data_jpa.jwtsecurityconfig.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityFilterChainConfig {

    @Autowired
    private JWTAuthenticationEntryPoint point;

    @Autowired
    private JwtRequestFilter filter;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public DefaultSecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
//                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize)-> authorize
                        .requestMatchers("/auth/login", "/api/user/create-user")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                // these two ways for integrating spring security with basic
//                .httpBasic(Customizer.withDefaults());
//                .httpBasic(withDefaults());

                .exceptionHandling((ex)-> ex.authenticationEntryPoint(point))
                .sessionManagement((session)-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        httpSecurity.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }
}
