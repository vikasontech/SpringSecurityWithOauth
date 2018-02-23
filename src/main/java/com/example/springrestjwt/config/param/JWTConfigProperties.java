package com.example.springrestjwt.config.param;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@ConfigurationProperties(prefix = "security")
@Component
@Data
public class JWTConfigProperties {
    private String signingKey;
    private int encodingStrength;
    private String securityRealm;
    private JWT jwt;

    @Data
    public static class JWT {
        private String clientId;
        private String clientSecret;
        private String grantType;
        private String scopeRead;
        private String scopeWrite;
        private String resourceIds;
    }
}