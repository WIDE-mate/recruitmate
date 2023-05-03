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
    public OpenAPI openAPI(){
        Info info = new Info()
                .version("v1.0.0")
                .title("채용 사이트 API")
                .description("API Description");
        return new OpenAPI().info(info);
    }

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
