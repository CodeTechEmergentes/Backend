package com.api.codetech.user.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("userMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public UserMapper userMapper(){
        return new UserMapper();
    }

    @Bean
    public ReviewMapper reviewMapper(){
        return new ReviewMapper();
    }
}
