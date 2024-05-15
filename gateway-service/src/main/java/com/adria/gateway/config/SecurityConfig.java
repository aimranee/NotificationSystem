package com.adria.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity serverHttpSecurity) throws Exception {
//        serverHttpSecurity.csrf()
//                .disable()
//                .authorizeExchange(exchange -> exchange
//                        .pathMatchers("/urlshortening-service/**")
//                        .permitAll()
//                        .anyExchange()
//                        .authenticated())
//                .oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt);
//        return serverHttpSecurity.build();
        return serverHttpSecurity
                .authorizeExchange().pathMatchers("/actuator/health/**").permitAll()
                .anyExchange().authenticated()
                .and()
                .oauth2ResourceServer().jwt().and()
                .and().build();
    }
}
