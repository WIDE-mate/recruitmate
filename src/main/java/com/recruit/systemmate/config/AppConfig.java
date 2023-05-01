package com.recruit.systemmate.config;

import com.recruit.systemmate.config.em.EnumFactory;
import com.recruit.systemmate.enums.Gender;
import com.recruit.systemmate.enums.Grade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AppConfig {

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder(16);
    }

    @Bean
    public EnumFactory enums(){
        EnumFactory enumFactory = new EnumFactory();
        enumFactory.put("GENDER", Gender.class);
        enumFactory.put("GRADE", Grade.class);
        return enumFactory;
    }
}
