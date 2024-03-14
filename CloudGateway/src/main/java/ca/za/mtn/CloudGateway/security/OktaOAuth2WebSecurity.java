package ca.za.mtn.CloudGateway.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoders;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class OktaOAuth2WebSecurity {
    @Value("${okta.oauth2.issuer}")
    private String issuerUri;
    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity httpSecurity){
       return httpSecurity
               .authorizeExchange(authorizeExchangeSpec ->
                       authorizeExchangeSpec
                               .anyExchange().authenticated()
                )
               .oauth2Login(oAuth2LoginSpec -> {})
               .oauth2ResourceServer(oAuth2ResourceServerSpec -> oAuth2ResourceServerSpec
                       .jwt(jwtSpec -> jwtSpec
                               .jwtDecoder( token() )
                       )
               ).build();
    }
    @Bean
    public ReactiveJwtDecoder token() {
        return ReactiveJwtDecoders.fromIssuerLocation(issuerUri);
    }
}
