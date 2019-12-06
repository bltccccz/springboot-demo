package com.oauth2.pojo;

import net.bytebuddy.utility.RandomString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author zhicheng.zhang
 * @date 2019-11-29
 * @description
 */
public class SecretTools {

    private final static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String secretenerate() {
        return RandomString.make(15);
    }

    public static String encodeSecret(String secret) {
        return encoder.encode(secret);
    }
}
