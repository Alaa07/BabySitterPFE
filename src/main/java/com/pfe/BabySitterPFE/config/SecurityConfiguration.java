package com.pfe.BabySitterPFE.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static com.pfe.BabySitterPFE.entities.Permission.*;
import static com.pfe.BabySitterPFE.entities.Role.*;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

    private static final String[] WHITE_LIST_URL =
            {"/auth/**",
            "/posts/**",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui/**",
            "/webjars/**",
            "/swagger-ui.html"};
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req.requestMatchers(WHITE_LIST_URL)
                                .permitAll()
                                .requestMatchers("/auth/**").hasAnyRole(ADMIN.name(), BABYSITTER.name())
                                .requestMatchers(GET, "/auth/**").hasAnyAuthority(PARENT.name(), BABYSITTER_READ.name())
                                .requestMatchers(POST, "/auth/**").hasAnyAuthority(PARENT_CREATE.name(), BABYSITTER_CREATE.name())
                                .requestMatchers(PUT, "/auth/**").hasAnyAuthority(PARENT_UPDATE.name(), BABYSITTER_UPDATE.name())
                                .requestMatchers(DELETE, "/auth/**").hasAnyAuthority(PARENT_DELETE.name(), BABYSITTER_DELETE.name())
                                .requestMatchers("/posts/**").hasAnyRole(ADMIN.name(), BABYSITTER.name())
                                .requestMatchers(GET, "/posts/**").hasAnyAuthority(PARENT.name(), BABYSITTER_READ.name())
                                .requestMatchers(POST, "/posts/**").hasAnyAuthority(PARENT_CREATE.name(), BABYSITTER_CREATE.name())
                                .requestMatchers(PUT, "/posts/**").hasAnyAuthority(PARENT_UPDATE.name(), BABYSITTER_UPDATE.name())
                                .requestMatchers(DELETE, "/posts/**").hasAnyAuthority(PARENT_DELETE.name(), BABYSITTER_DELETE.name())
                                .anyRequest()
                                .authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout ->
                        logout.logoutUrl("/auth/logout")
                                .addLogoutHandler(logoutHandler)
                                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
                )
        ;

        return http.build();
    }
}
