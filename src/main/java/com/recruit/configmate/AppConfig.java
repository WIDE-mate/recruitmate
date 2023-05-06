package com.recruit.configmate;

import com.recruit.commonmate.util.EnumFactory;
import com.recruit.commonmate.enums.Gender;
import com.recruit.commonmate.enums.Grade;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
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
