package com.example.springrestjwt.config;

import com.example.springrestjwt.config.param.JWTConfigProperties;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    private final DefaultTokenServices defaultTokenServices;
    private final JWTConfigProperties jwtConfigProperties;

    public ResourceServerConfig(DefaultTokenServices defaultTokenServices, JWTConfigProperties jwtConfigProperties) {
        this.defaultTokenServices = defaultTokenServices;
        this.jwtConfigProperties = jwtConfigProperties;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenServices(defaultTokenServices)
                .resourceId(jwtConfigProperties.getJwt().getResourceIds());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.requestMatchers().and()
                .authorizeRequests()
                .antMatchers("/app/**").authenticated();
    }
}
