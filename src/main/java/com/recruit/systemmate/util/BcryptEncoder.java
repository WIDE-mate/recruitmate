package com.recruit.systemmate.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoder {
    private static final int STRENGTH = 16;
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(STRENGTH);

    public static String encode(String password){
        return encoder.encode(password);
    }

}

