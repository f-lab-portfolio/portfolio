package com.ecommerce.security;

import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SecretKetGenerator {
    @Getter
    private static String secretKey;

    @PostConstruct
    public void generateSecretKey() {
        byte[] keyBytes = UUID.randomUUID().toString().replace("-", "").getBytes();
        secretKey = Base64.getEncoder().encodeToString(Keys.hmacShaKeyFor(keyBytes).getEncoded());

        System.setProperty("JWT_SECRET", secretKey);
    }
}
