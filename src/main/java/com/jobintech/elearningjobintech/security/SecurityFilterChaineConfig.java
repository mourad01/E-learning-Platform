package com.jobintech.elearningjobintech.security;

import com.jobintech.elearningjobintech.jwt.JWTTokenGenartorFilter;
import com.jobintech.elearningjobintech.jwt.JWTTokenValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityFilterChaineConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        CsrfTokenRequestAttributeHandler csrfTokenRequestAttributeHandler = new CsrfTokenRequestAttributeHandler();
        csrfTokenRequestAttributeHandler.setCsrfRequestAttributeName("_csrf");

        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(cors -> cors.configurationSource(
                        request -> {
                            var corsConfiguration = new CorsConfiguration();
                            corsConfiguration.setAllowedOrigins(List.of("http://localhost:4200"));
                            corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
                            corsConfiguration.setAllowCredentials(true);
                            corsConfiguration.setAllowedHeaders(List.of("*"));
                            corsConfiguration.setExposedHeaders(List.of("Authorization"));
                            return corsConfiguration;
                        }
                        //)).csrf(csrf->csrf.disable())
                )).csrf(csrf -> csrf.csrfTokenRequestHandler(csrfTokenRequestAttributeHandler)
                        .ignoringRequestMatchers("/user/**","/v3/api-docs/**", "/swagger-ui/**" )
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .addFilterAfter(new CrsfFilterCookie(), BasicAuthenticationFilter.class)
                .addFilterAfter(new JWTTokenGenartorFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new JWTTokenValidator(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests(request ->
                        request
                        .requestMatchers("/parcour/**").authenticated()
                        .requestMatchers( "/v3/api-docs/**").permitAll()
                        .requestMatchers( "/swagger-ui/**").permitAll()
                       .requestMatchers(HttpMethod.POST,  "/user/add").permitAll()
                        .anyRequest().permitAll()

                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());


//        http.authorizeRequests()
//                .requestMatchers("/parcour/**")
//                .permitAll()
//                .requestMatchers(HttpMethod.POST, "/user/add")
//                .permitAll()
//                .anyRequest()
//                .authenticated();
        return http.build();

    }

    /*
    * permit all
    * public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .permitAll();
    *  */

    /*
    * Deny all
    * public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .denyAll();

     */

    //    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("admin")
//                .roles("ADMIN")
//                .build();
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("user")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(admin, user);
//    }
    @Bean
    public InMemoryUserDetailsManager userDetailsManagers() {
        UserDetails admin = User.withUsername("admin")

                .password("admin")
                .roles("ADMIN")
                .build();
        UserDetails user = User.withUsername("user")

                .password("user")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return NoOpPasswordEncoder.getInstance();
    }
}
