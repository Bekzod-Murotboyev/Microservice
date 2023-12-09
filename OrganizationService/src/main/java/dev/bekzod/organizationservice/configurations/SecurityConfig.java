package dev.bekzod.organizationservice.configurations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // DEFAULT SETTINGS
        http
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .sessionManagement(configurer -> configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // CORS CONFIGURATION TO OPEN API FOR ALL
        http
                .cors(configurer -> configurer.configurationSource(
                        it -> {
                            var item = new CorsConfiguration()
                                    .applyPermitDefaultValues();
                            item.addAllowedHeader(CorsConfiguration.ALL);
                            return item;
                        }
                ));


        // THIS LINE TELLS TO USE JWT BASED AUTHORIZATION
        http.oauth2ResourceServer(oauth2 -> oauth2.jwt(withDefaults()));

        // CUSTOM SETTINGS
        http
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
                    authorizationManagerRequestMatcherRegistry
                            .requestMatchers("/organizations/free")
                            .permitAll()
                            .anyRequest()
                            .authenticated();
                });

        return http.build();
    }
}