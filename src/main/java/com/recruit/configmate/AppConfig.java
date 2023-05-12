package com.recruit.configmate;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.recruit.commonmate.comcode.EnumFactory;
import com.recruit.commonmate.comcode.dto.EnumMapper;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.reflections.Reflections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;

@Configuration
public class AppConfig {

//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Bean
//    public JPAQueryFactory jpaQueryFactory(){
//        return new JPAQueryFactory(entityManager);
//    }

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder(16);
    }

    @Bean
    public EnumFactory enums(){
        EnumFactory enumFactory = new EnumFactory();
        Reflections reflections = new Reflections("com.recruit.commonmate.comcode.enums");
        Set<Class<? extends EnumMapper>> set = reflections.getSubTypesOf(EnumMapper.class);
        for (Class<? extends EnumMapper> aClass : set){
            enumFactory.put(aClass.getSimpleName(), aClass);
        }
        return enumFactory;
    }

    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor(){
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(System.getProperty("jasypt.encryptor.password"));
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.NoIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        return encryptor;
    }

}
