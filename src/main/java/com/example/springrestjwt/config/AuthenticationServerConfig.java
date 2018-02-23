package com.example.springrestjwt.config;


import com.example.springrestjwt.config.param.JWTConfigProperties;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Arrays;

@Configuration
@EnableAuthorizationServer
public class AuthenticationServerConfig extends AuthorizationServerConfigurerAdapter {
    private final JWTConfigProperties jwtConfigProperties;
    private final JwtAccessTokenConverter jwtAccessTokenConverter;
    private final TokenStore tokenStore;
    private final AuthenticationManager authenticationManager;

    public AuthenticationServerConfig(JWTConfigProperties jwtConfigProperties, JwtAccessTokenConverter jwtAccessTokenConverter, TokenStore tokenStore, AuthenticationManager authenticationManager) {


        this.jwtConfigProperties = jwtConfigProperties;
        this.jwtAccessTokenConverter = jwtAccessTokenConverter;
        this.tokenStore = tokenStore;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient(jwtConfigProperties.getJwt().getClientId())
                .secret(jwtConfigProperties.getJwt().getClientSecret())
                .resourceIds(jwtConfigProperties.getJwt().getResourceIds())
                .scopes(jwtConfigProperties.getJwt().getScopeRead(), jwtConfigProperties.getJwt().getScopeWrite())
                .authorizedGrantTypes(jwtConfigProperties.getJwt().getGrantType());
    }
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        TokenEnhancerChain tokenEnhancerChain =
                new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(jwtAccessTokenConverter));
        endpoints.tokenStore(tokenStore)
                .authenticationManager(authenticationManager)
                .tokenEnhancer(tokenEnhancerChain);
    }

}
